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

@RestController  // return restapi
@Controller   // return data in view page
public class userController {
   
    @Autowired
    private IuserService userService;

    @GetMapping("/show_users")
    public String findUsers(Model model) {

        List<user> users = (List<user>) userService.findAll();

        model.addAttribute("users", users);

        return "users";
    }


  

}
