package com.tanpugi.fm.service.model;

public class DefaultReturnModel {

	private String errorMessage;
	private ReturnCode returnCode = ReturnCode.OK;

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ReturnCode getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
	}
	
	
}
