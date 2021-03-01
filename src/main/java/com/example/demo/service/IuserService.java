package com.example.demo.service;
import com.example.demo.model.user;
import java.util.List;

public interface IuserService {
    List<user> findAll();

    user findByEmail(String email);

}
