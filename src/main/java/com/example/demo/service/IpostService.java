package com.example.demo.service;

import com.example.demo.model.post;
import java.util.List;

public interface IpostService {
      List<post> findAll();

      void create_new_post(post pt, int id) ;
   
      List<post> retrive_posts_by_user(int id);
     

}
