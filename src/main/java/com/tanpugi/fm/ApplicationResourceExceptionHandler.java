package com.tanpugi.fm;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Component
public class ApplicationResourceExceptionHandler {

	@ExceptionHandler({DataIntegrityViolationException.class, DataAccessException.class})
	@ResponseBody
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Something went wrong in the server.")
	public ApplicationDefaultResponse handleServerExceptions(Exception ex) {
		ApplicationDefaultResponse response = new ApplicationDefaultResponse();
		response.setSuccess(false);
		response.setMessage("Something went wrong in the server.");
		return response;
	}

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApplicationDefaultResponse handle(MethodArgumentNotValidException exception) {
		ApplicationDefaultResponse response = new ApplicationDefaultResponse();
		response.setSuccess(false);
		response.setMessage("Some of the data in your request is not valid(argument)");
		return response;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApplicationDefaultResponse handle(HttpMessageConversionException exception) {
		ApplicationDefaultResponse response = new ApplicationDefaultResponse();
		response.setSuccess(false);
		response.setMessage("Request is not readable.");
		return response;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApplicationDefaultResponse handle(ConstraintViolationException exception) {
		ApplicationDefaultResponse response = new ApplicationDefaultResponse();
		response.setSuccess(false);
		response.setMessage("Some of the data in your request is not valid(constraint)");
		return response;
    }
}
