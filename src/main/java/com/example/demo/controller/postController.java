package com.example.demo.controller;

import com.example.demo.model.post;
import com.example.demo.model.user;
import com.example.demo.service.IpostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.RequestBody;



@RestController  // return restapi
//@Controller   // return data in view page

@RequestMapping("/api")
public class postController {
    
     @Autowired
     private IpostService postService ;
     
      @GetMapping("/posts")
    
    // @RequestMapping(path = "/show_users", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<post> getAllPosts() {

        List<post> posts = (List<post>) postService.findAll();

        return posts;
    }



    @GetMapping("/posts/user/{id}")
    public HttpStatus retrivePostsByUser(@PathVariable int id){
        try {
            this.postService.retrive_posts_by_user(id);
            return HttpStatus.OK;
        }
        catch(NoSuchElementException e) {
            return HttpStatus.BAD_REQUEST;
        }
    }



    // create new post
   @PostMapping("/new_post/{id}")
    public  HttpStatus  createPost(@RequestBody post pt, @PathVariable int id){
     
        try {
            this.postService.create_new_post(pt, id);
            return HttpStatus.OK;
        }
        catch(NoSuchElementException e) {
            System.out.println("*********************************");
            e.printStackTrace();
            System.out.println("*********************************");
            return HttpStatus.BAD_REQUEST;
        }
    }

    
}
