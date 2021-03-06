
package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Objects;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Entity

@Table(name = "users")
public class user {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
	private Integer id;

	@Column(name = "name")
	private String  name ;
	@Column(name = "email",unique = true, nullable = false)
	private String email ;
	@Column(name = "age")
	private Integer age ;
        
        // @OneToMany(cascade = CascadeType.ALL,
        //     fetch = FetchType.LAZY)
	@OneToMany(mappedBy="users", cascade={CascadeType.ALL})  	
    // private Set<post> posts = new HashSet<>();
	private List<post> posts;  
	
	public user() {
    } 
	public user(Integer id, String name, Integer age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public user(String name, Integer age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public List<post> getPosts() {
        return posts;
    }

    public void setPosts(List<post> posts) {
        this.posts = posts;
    }

	

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}

	
	 
	
	
	
}


