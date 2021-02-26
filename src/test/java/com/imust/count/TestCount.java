package com.imust.count;

import com.imust.service.count.CountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCount {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    CountService bean = ac.getBean("countService", CountService.class);

    @Test
    public void testAccountMoney() {
        bean.accountMoney();
    }
}
