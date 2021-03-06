package com.example.demo.service;

import com.example.demo.model.post;
import com.example.demo.model.user;
import com.example.demo.repository.IpostRepository;
import com.example.demo.repository.IuserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;  
import java.util.Optional;
import java.net.URI;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity; 
import java.util.NoSuchElementException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@Service
public class postService implements IpostService {

    @Autowired
     IpostRepository post_repository;
     IuserRepository user_repository;
    

     // get all posts 
    @Override
    public List<post> findAll() {
          return (List<post>) post_repository.findAll();

    }

// get all posts for specific user 
   @Override
   public List<post> retrive_posts_by_user(int id){
    
    Optional<user> userOptional= user_repository.findById(id);  
    if(userOptional.isPresent())  
    { 
        return userOptional.get().getPosts();  
 
    } else {
        throw new ResourceNotFoundException("Post not found with id : " +id);

    } 

   }

///////////////////////////////////////////////////////

////////////////////////////////////////////////////
    @Override
    public void create_new_post(post pt, int id) {
 
        System.out.println("********************************* id = "+ id);
        Optional <user> optionalPost = user_repository.findById(id);

        // System.out.println(pt.getUsers().getId());
        // Optional<user>  optionalPost = user_repository.findById(id);
        // Optional<user>  optionalPost = this.user_repository.findById(id);
        System.out.println("*********************************");

    //  post_repository.save(pt);
         if (!optionalPost.isPresent()) {
            // return ResponseEntity.unprocessableEntity().build();
          throw new ResourceNotFoundException("error while saving a record");

        }
        user u =optionalPost.get();     
        // pt.setUsers(optionalPost.get());
        pt.setUsers(u);

        // post savedPost = post_repository.save(pt);
        // return savedPost;
       post_repository.save(pt);

       
    }
    
    

}
