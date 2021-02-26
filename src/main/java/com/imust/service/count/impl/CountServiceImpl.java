package com.imust.service.count.impl;

import com.imust.dao.count.CountDao;
import com.imust.service.count.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "countService")
@Transactional(
        timeout = -1,
        propagation = Propagation.REQUIRED,
        isolation = Isolation.REPEATABLE_READ,
        readOnly = false)  // 默认也是这个
public class CountServiceImpl implements CountService {
    @Autowired
    private CountDao countDao;

    // 编程式事务管理
    /*@Override
    public void accountMoney() {
        try {
            // 第一步 开启事务

            // 第二步 进行业务操作
            countDao.reduceMoney();

            countDao.addMoney();

            // 第三步 没有发生异常，提交事务
        } catch (Exception e) {
            // 发生异常，事务回滚
        }
    }*/

    // 声明式事务管理
    @Override
    public void accountMoney() {
        countDao.reduceMoney();

        //int count = 10 / 0;

        countDao.addMoney();
    }
}
