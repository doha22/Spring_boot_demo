package com.example.demo.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.util.Objects;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ForeignKey;

@Entity
@Table(name = "posts")
public class post {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="title",unique = true, nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
   
    private Date created_at;
   
    // add forign key to posts table
    
    // @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    // @JoinColumn(name = "user_id",nullable = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"),name = "user_id")
    @JsonIgnore
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    private user users;

    public post() {
    }

    public post(Integer id, String title, String description, Date created_at) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created_at = created_at;
    }

    public post(String title, String description, Date created_at) {
        this.title = title;
        this.description = description;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    // review static method here is right !!!
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public  user getUsers() {
        return users;
    }

    public  void setUsers(user users) {
        this.users = users;
    }

    
    
    @Override
    public String toString() {
        return "post{" + "id=" + id + ", title=" + title + ", description=" + description + ", createdAt=" + created_at + ", users=" + users + '}';
    }

 

   

    
    
    
}
