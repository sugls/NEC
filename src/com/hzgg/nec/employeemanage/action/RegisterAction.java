package com.hzgg.nec.employeemanage.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.hzgg.nec.employeemanage.dao.IEmployeeDAO;
import com.hzgg.nec.employeemanage.po.Userinfo;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport implements ServletRequestAware {
	
	private HttpServletRequest request;
	
	private Userinfo user;
	
	
	
	public String register() throws Exception{
		System.out.println(user);
		IEmployeeDAO ied = (IEmployeeDAO) request.getAttribute("IEmployeeDAO");
		if(ied.insertUser(user)){
			request.setAttribute("message", "注册用户成功！");
		} else{
			request.setAttribute("message", "注册失败！");
		}
		return "success";
	}
	
	
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}


	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}

	
}
