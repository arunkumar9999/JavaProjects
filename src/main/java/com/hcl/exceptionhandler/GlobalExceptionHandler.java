package com.hcl.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.util.BooksUtil;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exceptions.class)
	public ResponseEntity<ErrorResponse> exceptions(Exceptions ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), BooksUtil.BOOK_ADDITION_FAILURE);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ExceptionById.class)
	public ResponseEntity<ErrorResponse> exceptionsById(ExceptionById ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), BooksUtil.BOOK_BY_ID_FAILURE);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
