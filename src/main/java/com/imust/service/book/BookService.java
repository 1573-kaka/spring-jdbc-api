package com.imust.service.book;

import com.imust.entity.book.Book;

public interface BookService {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void deleteById(String id);
}
