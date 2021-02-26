package com.imust.dao.book.impl;

import com.imust.dao.book.BookDao;
import com.imust.entity.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

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
        String sql = "update books set title=?, `desc`=?, content=? where id=?";
        int result = jdbcTemplate.update(sql, book.getTitle(), book.getDesc(), book.getContent(), book.getId());
        System.out.println("result = " + result);
    }

    @Override
    public void deleteById(String id) {
        String sql = "delete from books where id = ?";
        int result = jdbcTemplate.update(sql, id);
        System.out.println("result = " + result);
    }

    @Override
    public int findCount() {
        String sql = "select count(*) from books";
        /**
         * queryForObject(String sql, Class)
         *  第一个参数：sql语句
         *  第三个参数：类型
         */
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book findBookById(String id) {
        String sql = "select * from books where id = ?";
        /**
         * queryForObject(String sql, RowMapper<T> rowMapper, Object... args)
         *  第一个参数：sql语句
         *  第二个参数：RowMapper，是个接口，返回不同类型数据，使用这个接口里面实现类完成数据的封装
         *  第三个参数：sql语句值
         */
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findBook() {
        String sql = "select * from books";
        /**
         * query(String sql, RowMapper<T> rowMapper, Object... args)
         *  第一个参数：sql语句
         *  第二个参数：RowMapper，是个接口，返回不同类型数据，使用这个接口里面实现类完成数据的封装
         */
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into books values (?,?,?,?);";
        int[] messages = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(messages));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update books set title=?, `desc`=?, content=? where id=?";
        int[] messages = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(messages));
    }

    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "delete from books where id = ?";
        int[] messages = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println("messages = " + messages);
    }
}
