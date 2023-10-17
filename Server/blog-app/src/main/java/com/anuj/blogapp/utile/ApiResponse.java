package com.anuj.blogapp.utile;

public class ApiResponse {

	private String mesaage;
	private boolean success;
	
	
	
	
	
	public ApiResponse() {
		super();
	}
	
	
	public ApiResponse(String mesaage, boolean success) {
		super();
		this.mesaage = mesaage;
		this.success = success;
	}
	
	
	
	public String getMesaage() {
		return mesaage;
	}
	public void setMesaage(String mesaage) {
		this.mesaage = mesaage;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	@Override
	public String toString() {
		return "ApiResponse [mesaage=" + mesaage + ", success=" + success + "]";
	}
	
	
}
