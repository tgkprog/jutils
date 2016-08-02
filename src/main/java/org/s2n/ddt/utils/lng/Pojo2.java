package org.s2n.ddt.utils.lng;

import java.util.ArrayList;
import java.util.List;

public class Pojo2 {
	
	private List<String>returns = new ArrayList<>();
	private String[]inputs;
	
	
	public Pojo2() {
		super();
	}
	
	public Pojo2(String[] inputs) {
		super();
		this.inputs = inputs;
	}
	
	public String getReturnAt(int i) {
		if(returns.size() >= i)return null;
		return returns.get(i);
	}
	public void addReturn(String returns) {
		this.returns.add(returns);
	}
	
	
	public List<String> getReturns() {
		return returns;
	}
	public void setReturns(List<String> returns) {
		this.returns = returns;
	}
	public String[] getInputs() {
		return inputs;
	}
	public void setInputs(String[] inputs) {
		this.inputs = inputs;
	}

}
