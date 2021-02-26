package com.imust.dao.count.impl;

import com.imust.dao.count.CountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "countDao")
public class CountDaoImpl implements CountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney() {
        String sql = "update counts set money = money + ? where name = ?";
        jdbcTemplate.update(sql, 100, "mary");
    }

    @Override
    public void reduceMoney() {
        String sql = "update counts set money = money - ? where name = ?";
        jdbcTemplate.update(sql, 100, "lucy");
    }
}
