package com.fssa.crazyfitness.model;



public class User {
	
	private int userId;
	private String fname;
	private String lname;
	private int age;
	private String email;
	private String password;
	private String phone; 
	private String address;
	private String gender; 
	
	
	
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

	


	
	/**
	 * @param userId
	 * @param fname
	 * @param lname
	 * @param age
	 * @param email
	 * @param phone
	 * @param address
	 * constructor which is used for list users(Read) without password 
	 */
	public User(int userId, String fname, String lname, int age, String email, String phone,
			String address) {

		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	/**
	 * @param fname
	 * @param lname
	 * @param age
	 * @param email
	 * @param password
	 * @param phone
	 * @param address
	 * constructor which is used for register user (Create) without id because id is auto increment in database
	 */
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
	
	public User(String fname, String lname, int age, String email, String password, String phone) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	public User(String fname, String lname, int age, String email, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.email = email;
		this.password = password;
	
	}
	public int getUserId() {
		return userId;
	} 

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
 