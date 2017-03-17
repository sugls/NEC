package com.hzgg.nec.employeemanage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.hzgg.nec.employeemanage.dao.IEmployeeDAO;
import com.hzgg.nec.employeemanage.po.Employee;
import com.hzgg.nec.employeemanage.po.Userinfo;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	
	
	
	
	private HttpServletRequest request;
	private HttpSession session;

	private Userinfo userinfo;

	/**
	 *
	 */
	public LoginAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ÏµÍ³ï¿½ï¿½Â¼Ö´ï¿½Ð·ï¿½ï¿½ï¿½
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		IEmployeeDAO ied = (IEmployeeDAO) request.getAttribute("IEmployeeDAO");
		System.out.println(ied);
		System.out.println(userinfo);
		Employee emp = ied.checkLogin(userinfo);
		System.out.println(emp);
		if(emp != null){
			session.setAttribute("employee", emp);
			return "success";
		}else{
			request.setAttribute("error", "ÓÃ»§Ãû»òÃÜÂë´íÎó¡£Íü¼ÇÃÜÂëÇëÁªÏµ¹ÜÀíÔ±¡£");
			return "error";
		}
			


	}

	/**
	 * ÏµÍ³ï¿½Ë³ï¿½Ö´ï¿½Ð·ï¿½ï¿½ï¿½
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception{
		session.removeAttribute("employee");
		return "success";
	}

	/**
	 * @return the userinfo
	 */
	public Userinfo getUserinfo() {
		return userinfo;
	}

	/**
	 * @param userinfo the userinfo to set
	 */
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
		session = request.getSession();
	}

}
