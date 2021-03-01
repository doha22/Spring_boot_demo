package com.example.demo.repository;
import com.example.demo.model.user;
// import org.springframework.data.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
// @Repository
// public class userRepository {

    // public interface IuserRepository {
  public interface IuserRepository {

    void create_user(user u);

    user findUserByEmail(String email);

    // return all users 
    List<user> findAll();
    }
    

