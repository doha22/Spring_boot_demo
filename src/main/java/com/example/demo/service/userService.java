package com.example.demo.service;
import com.example.demo.model.user;

import com.example.demo.repository.IuserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Optional;
// import net.javaguides.springboot2.exception.ResourceNotFoundException;

import com.example.demo.exception.ResourceNotFoundException;

@Service
public class userService implements IuserService {

 // used to retrieve data from db 
 
    @Autowired
     IuserRepository repository;


    @Override
    public List<user> findAll() {

        return (List<user>) repository.findAll();
    }

   
    @Override
    public user find_by_Id(Integer id) {

        Optional < user > user_id = this.repository.findById(id);

        if (user_id.isPresent()) {
            return user_id.get();
        } 
        else {
             throw new ResourceNotFoundException("Record not found with id : " + user_id);
        }
    }
    
 
    @Override
    public void  create_new_user(user u) {
       repository.save(u);
    }


@Override
    public user update_user_info(user u){
        Optional < user > user_id = this.repository.findById(u.getId());

        if(user_id.isPresent()) {
			user update_user = user_id.get();
			update_user.setId(u.getId());
			update_user.setName(u.getName());
            update_user.setEmail(u.getEmail());
			update_user.setAge(u.getAge());
			repository.save(update_user);
			return update_user;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + u.getId());
		}

    }

    @Override
    public void delete_user(Integer id){
        Optional < user > user_id = this.repository.findById(id);
 
        if (user_id.isPresent()) {
            this.repository.delete(user_id.get());
        } 
        else {
             throw new ResourceNotFoundException("Record not found with id : " + user_id);
        }

    }

}    