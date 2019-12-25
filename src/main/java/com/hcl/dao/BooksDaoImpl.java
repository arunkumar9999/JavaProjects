package com.hcl.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.hcl.dto.RequestDto;
import com.hcl.dto.ResponseDto;
import com.hcl.entity.Books;
import com.hcl.exceptionhandler.ExceptionById;
import com.hcl.exceptionhandler.Exceptions;
import com.hcl.util.BooksUtil;

@Repository
public class BooksDaoImpl implements BooksDao {

	@Autowired
	private SessionFactory sessionFactory;

	ResponseDto responseDto = new ResponseDto();

	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public ResponseDto addBooks(RequestDto requestDto) throws Exceptions {
		if (null != requestDto) {
			Books books = new Books();
			BeanUtils.copyProperties(requestDto, books);
			getSession().save(books);

			responseDto.setMessage(books.getBookName() + BooksUtil.BOOK_ADD_SUCCESS);
			responseDto.setStatusCode(HttpStatus.CREATED.value());
			return responseDto;
		} else {
			throw new Exceptions(BooksUtil.BOOK_ADDITION_FAILURE);
		}
	}

	public ResponseDto getBookById(int bookId) throws ExceptionById {

		if (bookId == 0) {
			throw new ExceptionById(BooksUtil.BOOK_BY_ID_FAILURE);
		}
		Books book = (Books) getSession().get(Books.class, bookId);
		responseDto.setMessage(BooksUtil.BOOK_BY_ID + book.getBookName() + book.getBookId());
		responseDto.setStatusCode(HttpStatus.OK.value());
		return responseDto;
	}

	@SuppressWarnings("unchecked")
	public List<Books> getAllBooks() {
		List<Books> booksList1 = getSession().createCriteria(Books.class).list();
		System.out.println("Books list " + booksList1);
		return booksList1;
	}

	public ResponseDto updateBooks(Books books) {
		getSession().update(books);
		responseDto.setMessage(books.getBookName() + BooksUtil.BOOK_UPDATE_SUCCESS);
		responseDto.setStatusCode(HttpStatus.OK.value());
		return responseDto;

	}

	public ResponseDto deleteBookById(int bookId) {

		Books book = (Books) getSession().load(Books.class, bookId);
		if (book.getBookId() == bookId) {
			getSession().delete(book);
		}
		responseDto.setMessage(book.getBookName() + BooksUtil.BOOK_DELETE_SUCCESS);
		responseDto.setStatusCode(HttpStatus.OK.value());
		return responseDto;
	}

}
