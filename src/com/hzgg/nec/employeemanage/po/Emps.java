package com.hzgg.nec.employeemanage.po;

import java.io.Serializable;

public class Emps implements Serializable {

	
	private Integer employeeid;
	private String postname;
	private String realname;
	private String sex;
	private String phone;
	private Integer userid;
	private String username;
	private String userpwd;
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
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
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	@Override
	public String toString() {
		return "Emps [employeeid=" + employeeid + ", postname=" + postname + ", realname=" + realname + ", sex=" + sex
				+ ", phone=" + phone + ", userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + "]";
	}
	
	
	
	
	
	
	
	
}
