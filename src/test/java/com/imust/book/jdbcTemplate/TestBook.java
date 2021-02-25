package com.imust.book.jdbcTemplate;

import com.imust.entity.book.Book;
import com.imust.service.book.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {

    @Autowired
    private BookService bookService;

    @Test
    public void testAddBook() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        BookService bean = ac.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setId(2);
        book.setTitle("计算机");
        book.setDesc("操作系统");
        book.setContent("管理计算机硬件与软件资源的计算机程序");
        bean.addBook(book);
    }
}
