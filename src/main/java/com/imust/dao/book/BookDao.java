package com.imust.dao.book;

import com.imust.entity.book.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    void updateBook(Book book);

    void deleteById(String id);

    // 查询返回某一个值 -- 查询表记录数
    int findCount();

    // 查询返回对象
    Book findBookById(String id);

    // 查询返回集合
    List<Book> findBook();

    // 批量添加功能
    void batchAddBook(List<Object[]> batchArgs);

    // 批量修改功能
    void batchUpdateBook(List<Object[]> batchArgs);

    // 批量删除功能
    void batchDeleteBook(List<Object[]> batchArgs);
}
