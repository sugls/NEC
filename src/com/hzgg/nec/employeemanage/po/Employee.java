/**
 * 
 */
package com.hzgg.nec.employeemanage.po;

import java.io.Serializable;

/**
 * @author Mr.H
 *
 * create date  2017��3��1��  ����10:23:10
 */
public class Employee implements Serializable {
	
	private Integer employeeid;
	private String postname;
	private String realname;
	private String sex;
	private String phone;

	private String logindate;
	
	private Userinfo user;
	
	/**
	 * 
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
	}


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


	public String getLogindate() {
		return logindate;
	}

	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}
	
	

	public Userinfo getUser() {
		return user;
	}


	public void setUser(Userinfo user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Employee{" +
				"employeeid=" + employeeid +
				", postname='" + postname + '\'' +
				", realname='" + realname + '\'' +
				", sex='" + sex + '\'' +
				", phone='" + phone + '\'' +
				", logindate=" + logindate +
				'}';
	}
}
