package com.usermanagement.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UERINFO")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="USER_NAME")
	private String name;
	
	@Column(name="USER_EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	
	@Column(name="PHONE_NO")
	private String phoneno;
	
	
	@Column(name="ADDRESS")
	private String address;
	
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Post> posts=new ArrayList<>();


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	


	public List<Post> getPosts() {
		return posts;
	}


	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}







	public User(Integer id, String name, String email, String password, String phoneno, String address,
			List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
		this.address = address;
		this.posts = posts;
	}



	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phoneno="
				+ phoneno + ", address=" + address + ", posts=" + posts + "]";
	}


	public User() {
		super();
		
	}


	public User(String name2, String address2, String email2, String phoneno2, String password2) {
		// TODO Auto-generated constructor stub
	}


	
	

}
