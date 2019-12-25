package com.hcl.dao;

import java.util.List;

import com.hcl.dto.RequestDto;
import com.hcl.dto.ResponseDto;
import com.hcl.entity.Books;
import com.hcl.exceptionhandler.ExceptionById;
import com.hcl.exceptionhandler.Exceptions;

public interface BooksDao {

	public ResponseDto addBooks(RequestDto requestDto) throws Exceptions;

	public ResponseDto getBookById(int bookId) throws ExceptionById;

	public List<Books> getAllBooks();

	public ResponseDto updateBooks(Books books);

	public ResponseDto deleteBookById(int bookId);
}
