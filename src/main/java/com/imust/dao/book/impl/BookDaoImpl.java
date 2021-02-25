package com.imust.dao.book.impl;

import com.imust.dao.book.BookDao;
import com.imust.entity.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addBook(Book book) {
        String sql = "insert into books values (?,?,?,?);";
        int result = jdbcTemplate.update(sql, book.getId(), book.getTitle(), book.getDesc(), book.getContent());
        System.out.println("result = " + result);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update books set title=?, desc=?, content=? where id=?";
        int result = jdbcTemplate.update(sql, book.getTitle(), book.getDesc(), book.getContent(), book.getId());
        System.out.println("result = " + result);
    }

    @Override
    public void deleteById(String id) {
        String sql = "delete from books where id = ?";
        int result = jdbcTemplate.update(sql, id);
        System.out.println("result = " + result);
    }
}
