package com.friendbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@org.springframework.web.bind.annotation.ExceptionHandler(value = NullPointerException.class)
	public String exceptionHandlerNull() {
		return "nullpage";
	}

}
