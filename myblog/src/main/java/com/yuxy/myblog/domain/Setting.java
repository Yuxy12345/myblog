package com.yuxy.myblog.domain;

public class Setting {

	private String Item;
	private String Value;
	
	public Setting(String Item, String Value) {
		this.setItem(Item);
		this.setValue(Value);
	}

	public String getItem() {
		return Item;
	}

	public void setItem(String item) {
		Item = item;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}
	
}
