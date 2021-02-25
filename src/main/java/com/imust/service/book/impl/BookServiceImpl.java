package com.imust.service.book.impl;

import com.imust.dao.book.BookDao;
import com.imust.entity.book.Book;
import com.imust.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    @Qualifier(value = "bookDao")
    private BookDao bookDao;

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }
}
