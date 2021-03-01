package com.example.demo.repository;
import com.example.demo.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
// @Repository

public class userRepository implements IuserRepository{

 @Autowired
    private JdbcTemplate jdbcTemplate;

    // create and save user
    @Override
    public void create_user(user u) {

        String sql = "INSERT INTO users(name, email,age) VALUES (?, ?,?)";
        Object[] params = new Object[] {u.getName(),u.getEmail(),u.getAge()};

        jdbcTemplate.update(sql, params);
    }

    @Override
    public user findUserByEmail(String email) {

        String sql = "SELECT * FROM users WHERE email = ?";
        Object[] param = new Object[] {email};

        return jdbcTemplate.queryForObject(sql, param,BeanPropertyRowMapper.newInstance(user.class));
    }

    @Override
    public List<user> findAll() {

        String sql = "SELECT * FROM users";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(user.class));
    }







}