package com.singlelovely.entity;

/*
 * CREATE TABLE `user` (
  `uid` VARCHAR(32) NOT NULL,
  `username` VARCHAR(20) DEFAULT NULL,
  `password` VARCHAR(20) DEFAULT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `photo` VARCHAR(64) DEFAULT NULL,
  `email` VARCHAR(30) DEFAULT NULL,
  `telephone` VARCHAR(20) DEFAULT NULL,
  `birthday` DATE DEFAULT NULL,
  `sex` VARCHAR(10) DEFAULT NULL,
  `state` INT(11) DEFAULT NULL,
  `code` VARCHAR(64) DEFAULT NULL,
  PRIMARY KEY (`uid`)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8;
 * 
 */


public class User {
	private String uid;
	private String username;
	private String password;
	private String name;
	private String photo;
	private String email;
	private String telephone;
	private String birthday;
	private String sex;
	private String state;
	private String code;
	
	public User() {
		
	}
	
	public String getUid() {
		return uid;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getPhoto() {
		return photo;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getSex() {
		return sex;
	}
	public String getState() {
		return state;
	}
	public String getCode() {
		return code;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
