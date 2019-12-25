package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.BooksDao;
import com.hcl.dto.RequestDto;
import com.hcl.dto.ResponseDto;
import com.hcl.entity.Books;
import com.hcl.exceptionhandler.ExceptionById;
import com.hcl.exceptionhandler.Exceptions;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	BooksDao booksDao;

	@Transactional
	public ResponseDto addBooks(RequestDto requestDto) throws Exceptions {

		return booksDao.addBooks(requestDto);

	}

	@Transactional
	public ResponseDto getBookById(int bookId) throws ExceptionById {

		return booksDao.getBookById(bookId);
	}

	@Transactional
	public List<Books> getAllBooks() {

		return booksDao.getAllBooks();
	}

	@Transactional
	public ResponseDto updateBooks(Books books) {

		return booksDao.updateBooks(books);
	}

	@Transactional
	public ResponseDto deleteBookById(int bookId) {

		return booksDao.deleteBookById(bookId);
	}

}
