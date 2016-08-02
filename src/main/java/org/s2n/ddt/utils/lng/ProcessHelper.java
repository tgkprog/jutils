package org.s2n.ddt.utils.lng;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.s2n.ddt.util.threads.DdtPools;
import org.s2n.ddt.util.threads.PoolOptions;
import org.s2n.ddt.utils.io.ReadStreamAsync;


public class ProcessHelper implements Runnable {
	private static final Logger logger =  LoggerFactory.getLogger(ProcessHelper.class);
	
	public static final String POOL = "asyncStreams";
	ProcessBuilder pb = null;
	
	static{		
		DdtPools.initPool(POOL,  new PoolOptions () );
	}
	
	public void proc(String[]params){	
		pb= new ProcessBuilder(params);
	}	
	
	public void proc(File dir, String cmd, String ...args){
		pb = new ProcessBuilder();
		try {
			pb.directory(dir);
			pb.command(cmd);
			List<String> c = pb.command();
			for (String arg : args){
	            c.add(arg);
			}
			DdtPools.offer(POOL, this);
		} catch (Exception e) {
			logger.error("Async process p " + cmd + ", " + e, e);
		}
	}
	
	public void run(){
		
		try {
			Process p = pb.start();
			ReadStreamAsync r1 = new ReadStreamAsync(p.getInputStream());
			ReadStreamAsync rEr = new ReadStreamAsync(p.getErrorStream());
			p.waitFor();
			Thread.sleep(100);
			logger.info(r1.getResponse());
			logger.info(rEr.getResponse());
		} catch (Exception e) {
			logger.error("Async process run " + pb.command().get(0) + ", " + e, e);
		}
	}
	
	public static void main(String[] args) {
		
		ProcessHelper ph = new ProcessHelper();
		String cmd = "/u/apps/entertain/youtube-dl/youtube-dl";
		File f = new File("/d/m/saves");
		String ar = "https://www.youtube.com/watch?v=MqkLVJf_ru4";
		ph.proc(f, cmd, ar);
		
		
	}

}
