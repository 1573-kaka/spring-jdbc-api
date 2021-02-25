package com.imust.dao.book;

import com.imust.entity.book.Book;

public interface BookDao {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void deleteById(String id);
}
