package com.example.demo.service;
import com.example.demo.model.user;
import com.example.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class userService implements IuserService {

 // used to retrieve data from db 
 
    @Autowired
    private userRepository repository;


    @Override
    public List<user> findAll() {

        return (List<user>) repository.findAll();
    }

    public user findByEmail(String email) {

        return repository.findUserByEmail(email);
    }


}    