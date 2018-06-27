package com.yang.mybatis.po;

import java.io.Serializable;

public class User implements Serializable {

	private Integer user_id;
	private String user_name;
	private String user_passwd;
	private Integer user_privilege;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public Integer getUser_privilege() {
		return user_privilege;
	}
	public void setUser_privilege(Integer user_privilege) {
		this.user_privilege = user_privilege;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_passwd=" + user_passwd
				+ ", user_privilege=" + user_privilege + "]";
	}
	
	
	
	
}
