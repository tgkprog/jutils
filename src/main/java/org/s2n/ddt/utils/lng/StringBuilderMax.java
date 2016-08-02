package org.s2n.ddt.utils.lng;

public class StringBuilderMax {
	private StringBuilder sb = new StringBuilder();
	private int max = 5000;
	
	public StringBuilderMax(){
		
	}
	
	public StringBuilderMax(int m){
		max = m;
		
	}
	
	public StringBuilderMax(int m, StringBuilder sb){
		max = m;
		this.sb = sb;
		append("");
		
	}

	public void append(String s) {
		int l = sb.length() ; 
		if(l> max){
			int from  = Math.max(0, (int)(l - (s.length() * .6)));
			sb.delete(from, l);
			if(s.length() > 1){
				sb.append(" ").append(s.substring((int)(s.length() / 2)));
			}else{
				sb.append(s);
			}
		}else{
			sb.append(s);
		}
		
	}
	
	public StringBuilder get() {
		return sb;
		
	}
	

}
