/**
 * 
 */
package com.hzgg.nec.employeemanage.po;

import java.io.Serializable;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  上午10:22:33
 */
public class Userinfo implements Serializable {
	
	private Integer userid;
	private String username;
	private String userpwd;
	private Integer employeeid;
	
	private String postname;
	
	/**
	 * 
	 */
	public Userinfo() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Userinfo [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", employeeid="
				+ employeeid + ", postname=" + postname + "]";
	}
	
	
}
