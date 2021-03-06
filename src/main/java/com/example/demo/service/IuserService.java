package com.example.demo.service;
import com.example.demo.model.user;
import java.util.List;

public interface IuserService {
    List<user> findAll();

    user find_by_Id(Integer id);

   void create_new_user(user u) ;

   user update_user_info(user u);


   void delete_user(Integer id);

}
