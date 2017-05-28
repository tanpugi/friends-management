package com.tanpugi.fm.resource.model;

public abstract class DefaultResponse {

	private boolean success;
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
