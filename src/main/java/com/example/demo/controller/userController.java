// package com.example.demo;
package com.example.demo.controller;
import com.example.demo.model.user;
import com.example.demo.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

@RestController  // return restapi
//@Controller   // return data in view page

@RequestMapping("/api")
public class userController {
   
    @Autowired
    private IuserService userService;

    @GetMapping("/show_customers")
    
    // @RequestMapping(path = "/show_users", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<user> findUsers() {

        List<user> users = (List<user>) userService.findAll();

        return users;
    }

// find user by id
// @PostMapping(("/users_id")
// // @RequestMapping(path = "/users/{id}", produces = "application/json; charset=UTF-8")
// @ResponseBody
// public List<user> find_user_id(long id) {

//     List<user> users = (List<user>) userService.findById(id);

//     return users;
// }

   


    @GetMapping("/users/{id}")
	public ResponseEntity<user> findUserById(@PathVariable Integer id){
		return ResponseEntity.ok().body(userService.find_by_Id(id));
	}


    @PutMapping("/users/{id}")
    // @RequestMapping(value = "/users/{id}", produces = "application/json", method=RequestMethod.PUT)
	public ResponseEntity<user> updateUserInfo(@PathVariable Integer id, @RequestBody user u){
		u.setId(id);
		return ResponseEntity.ok().body(this.userService.update_user_info(u));
	}

    @DeleteMapping("/users/{id}")
	public HttpStatus deleteUser(@PathVariable Integer id){
		this.userService.delete_user(id);
		return HttpStatus.OK;
	}

    @PostMapping("/new_customer")
	public HttpStatus createCustomer(@RequestBody user u) {
        try {
            this.userService.create_new_user(u);
            return HttpStatus.OK;
        }
        catch(NoSuchElementException e) {
            System.out.println("*********************************");
            e.printStackTrace();
            System.out.println("*********************************");
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
	}


// @PostMapping("/new_users")
//     user create_new_user(@RequestBody user u) {
//         return muscleRepository.save(u);
//     }

// create new user

    //  @RequestMapping(path = "/new_user", produces = "application/json; charset=UTF-8")
    // user newMuscle(@RequestBody Muscle muscle) {
    //     return muscleRepository.save(muscle);
    // }
    // @RequestMapping(path = "/check_email", produces = "application/json; charset=UTF-8")
    // @ResponseBody
    // public List<user> findEmail() {

    //     List<user> user_email = (List<user>) userService.findByEmail(String email);

    //     return user_email;
    // }


  

}
