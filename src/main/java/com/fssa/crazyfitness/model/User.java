package com.fssa.crazyfitness.model;



public class User {
	
	private String fname;
	private String lname;
	public int age;
	public String email;
	public String password;
	private String phone;
	private String address;
	 
	
	
	
	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", age=" + age + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", address=" + address + "]";
	}
	
	public User() {
		
	}
	
	
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User(String fname, String lname, int age, String email, String password, String phone, String address) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
		
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
 