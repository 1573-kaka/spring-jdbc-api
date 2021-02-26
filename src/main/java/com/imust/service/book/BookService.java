package com.imust.service.book;

import com.imust.entity.book.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void deleteById(String id);

    int findCount();

    Book findBookById(String id);

    List<Book> findBook();

    void batchAdd(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchArgs);
}
