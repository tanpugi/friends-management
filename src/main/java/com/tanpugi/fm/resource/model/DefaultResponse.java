package com.tanpugi.fm.resource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tanpugi.fm.service.model.DefaultReturnModel;
import com.tanpugi.fm.service.model.ReturnCode;

public abstract class DefaultResponse {
	@JsonInclude(value=Include.ALWAYS)
	private boolean success = true;
	@JsonInclude(value=Include.NON_NULL)
	private String message;
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@JsonIgnore
	public void initResponse(DefaultReturnModel returnModel) {
		boolean isOK = ReturnCode.OK == returnModel.getReturnCode();
		this.setMessage(returnModel.getErrorMessage());
		this.setSuccess(isOK);
	}
}
