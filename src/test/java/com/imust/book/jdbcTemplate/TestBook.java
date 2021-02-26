package com.imust.book.jdbcTemplate;

import com.imust.entity.book.Book;
import com.imust.service.book.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {

    @Autowired
    private BookService bookService;

    ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    BookService bean = ac.getBean("bookService", BookService.class);

    @Test
    public void testAddBook() {
        Book book = new Book();
        book.setId("3");
        book.setTitle("计算机");
        book.setDesc("操作系统");
        book.setContent("管理计算机硬件与软件资源的计算机程序");
        bean.addBook(book);
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book();

        book.setTitle("计算机");
        book.setDesc("计算机网络");
        book.setContent("将地理位置不同的具有独立功能的多台计算机及其外部设备，通过通信线路连接起来，在网络操作系统，网络管理软件及网络通信协议的管理和协调下，实现资源共享和信息传递的计算机系统");
        book.setId("2");
        bean.updateBook(book);
    }

    @Test
    public void testDeleteById() {
        bean.deleteById("3");
    }

    @Test
    public void testFindCount() {
        int count = bean.findCount();
        System.out.println("count = " + count);
        ;
    }

    @Test
    public void testFindBookById() {
        Book book = bean.findBookById("1");
        System.out.println("book = " + book);
    }

    @Test
    public void testFindBook() {
        List<Book> books = bean.findBook();
        for (Book book : books) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void testBatchAdd() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {
                "3",
                "计算机",
                "数据库",
                "按照数据结构来组织、存储和管理数据的仓库"
        };
        Object[] o2 = {
                "4",
                "计算机",
                "计算机组成原理",
                "CPU、内存、主板"
        };
        Object[] o3 = {
                "5",
                "计算机",
                "数据结构",
                "计算机存储、组织数据的方式"
        };
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bean.batchAdd(batchArgs);
    }

    @Test
    public void testBatchUpdate() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {
                "计算机",
                "数据库",
                "按照数据结构来组织、存储和管理数据的仓库",
                "3"
        };
        Object[] o2 = {
                "计算机",
                "计算机组成原理",
                "CPU、内存、主板",
                "4"
        };
        Object[] o3 = {
                "计算机",
                "数据结构",
                "计算机存储、组织数据的方式",
                "5"
        };
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bean.batchUpdate(batchArgs);
    }

    @Test
    public void testBatchDelete() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3"};
        Object[] o2 = {"4"};
        Object[] o3 = {"5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bean.batchDelete(batchArgs);
    }
}
