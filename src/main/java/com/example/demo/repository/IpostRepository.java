package com.example.demo.repository;

import com.example.demo.model.post;

import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpostRepository extends JpaRepository<post, Integer> {
    
}
