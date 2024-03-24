package com.entities.Mulya;

import javax.persistence.*;
@Entity
@Table(name = "usersDetails")
public class UserDetails {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String  UserId;
	private String username;
	private String email;
	private String mob_no;
	
	//Getter and Setter
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		this.UserId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMob_no() {
		return mob_no;
	}
	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	//Constructor
	public UserDetails(String userId, String username, String mob_no, String email ) {
		super();
		this.UserId = userId;
		this.username = username;
		this.mob_no = mob_no;
		this.email = email;
	}
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
