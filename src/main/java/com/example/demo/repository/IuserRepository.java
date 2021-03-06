package com.example.demo.repository;
import com.example.demo.model.user;
// import org.springframework.data.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
// public class userRepository {

    // public interface IuserRepository {
  public interface IuserRepository extends JpaRepository<user, Integer>  {

    // user create_user(user u);

    // user findUserById(long id);

    // // return all users 
    // List<user> findAll();
    }
    

