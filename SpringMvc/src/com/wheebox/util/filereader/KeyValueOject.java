package com.wheebox.util.filereader;

public class KeyValueOject {

	private String key;
	private String value;

	public KeyValueOject(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		
		return this.getKey()+" "+getValue();
	}
	
	
	

}
