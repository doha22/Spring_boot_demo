package com.example.demo.repository;
import com.example.demo.model.user;
// import com.example.demo.service.create_new_user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Component;

@Component
// public class userRepository implements IuserRepository {
    public class userRepository {

 @Autowired
    private JdbcTemplate jdbcTemplate;

    // create and save user
    // @Override
    // public create_new_user create_user(user u) {

    //     String sql = "INSERT INTO users(name, email,age) VALUES (?, ?,?)";
    //     Object[] params = new Object[] {u.getName(),u.getEmail(),u.getAge()};

    //     jdbcTemplate.update(sql, params);
    // }

    // @Override
    // public user findUserById(long id) {

    //     String sql = "SELECT * FROM users WHERE id = ?";
    //     Object[] param = new Object[] {id};

    //     return jdbcTemplate.queryForObject(sql, param,BeanPropertyRowMapper.newInstance(user.class));
    // }

    // @Override
    // public List<user> findAll() {

    //     String sql = "SELECT * FROM users";

    //     return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(user.class));
    // }







}