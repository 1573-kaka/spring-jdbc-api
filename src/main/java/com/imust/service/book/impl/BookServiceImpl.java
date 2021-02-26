package com.imust.service.book.impl;

import com.imust.dao.book.BookDao;
import com.imust.entity.book.Book;
import com.imust.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteById(String id) {
        bookDao.deleteById(id);
    }

    @Override
    public int findCount() {
        return bookDao.findCount();
    }

    @Override
    public Book findBookById(String id) {
        return bookDao.findBookById(id);
    }

    @Override
    public List<Book> findBook() {
        return bookDao.findBook();
    }

    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        bookDao.batchAddBook(batchArgs);
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        bookDao.batchUpdateBook(batchArgs);
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        bookDao.batchDeleteBook(batchArgs);
    }
}
