package com.imust.count;

import com.imust.config.TxConfig;
import com.imust.service.count.CountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestCount {
    @Test
    public void testAccountMoney() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        CountService bean = ac.getBean("countService", CountService.class);
        bean.accountMoney();
    }

    @Test
    public void testAccountMoneyByConfig() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TxConfig.class);
        CountService bean = ac.getBean("countService", CountService.class);
        bean.accountMoney();
    }
}
