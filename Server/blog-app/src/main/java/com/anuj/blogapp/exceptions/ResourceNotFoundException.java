package com.anuj.blogapp.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private String resourceName;
	private String filedName;
	private long filedValue;
	
	
	
	public ResourceNotFoundException(String resourceName, String filedName, long filedValue) {
		super(String.format("%s not found with %s : %s", resourceName, filedName, filedValue));
		this.resourceName = resourceName;
		this.filedName = filedName;
		this.filedValue = filedValue;
	}



	public String getResourceName() {
		return resourceName;
	}



	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}



	public String getFiledName() {
		return filedName;
	}



	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}



	public long getFiledValue() {
		return filedValue;
	}



	public void setFiledValue(long filedValue) {
		this.filedValue = filedValue;
	}

	
	 
}
