package model;

import java.io.Serializable;

public class Memo implements Serializable {
	private String order;
	
	public Memo(String order) {
		this.order = order;
	}
	
	// getter／setter
	public String getMemo() {
		return this.order;
	}
	
	public void setMemo(String order) {
		this.order = order;
	}

}
