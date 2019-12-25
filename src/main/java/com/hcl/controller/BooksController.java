package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.RequestDto;
import com.hcl.dto.ResponseDto;
import com.hcl.entity.Books;
import com.hcl.exceptionhandler.ExceptionById;
import com.hcl.exceptionhandler.Exceptions;
import com.hcl.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BooksService booksService;

	@RequestMapping(value = "/addBooks", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> addBooks(RequestDto requestDto) throws Exceptions {
		return new ResponseEntity<ResponseDto>(booksService.addBooks(requestDto), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getBook/{bookId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getBookById(int bookId) throws ExceptionById {
		return new ResponseEntity<ResponseDto>(booksService.getBookById(bookId), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
	public ResponseEntity<List<Books>> getMessage() {
		return new ResponseEntity<List<Books>>(booksService.getAllBooks(), HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<ResponseDto> updateBook(Books books) {
		return new ResponseEntity<ResponseDto>(booksService.updateBooks(books), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{bookId}", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseDto> deleteBookById(int bookId) {
		return new ResponseEntity<ResponseDto>(booksService.deleteBookById(bookId), HttpStatus.OK);
	}
}
