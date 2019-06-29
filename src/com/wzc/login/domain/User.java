package com.wzc.login.domain;

/**
 * @author WANGZIC
 */
public class User {
	private Integer userid;
	
	private String username;

	private String nickname;

	private String password;

	private String phone;

	private String gender;

	private String email;

	private String address;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "查询结果：User{" +
				"userid=" + userid +
				", username='" + username + '\'' +
				", nickname='" + nickname + '\'' +
				", password='" + password + '\'' +
				", phone='" + phone + '\'' +
				", gender='" + gender + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
