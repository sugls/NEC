 /**
 * 
 */
package com.hzgg.nec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author MR.H
 *
 */
public class LoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	public LoginInterceptor() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		 HttpServletRequest request = (HttpServletRequest) arg0.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		 HttpSession session = request.getSession();
		if("register-link".equals(arg0.getInvocationContext().getName()) | "checklogin".equals(arg0.getInvocationContext().getName()) | session.getAttribute("employee") != null){
			return arg0.invoke();
		 }else {
			 return "returnlogin";
		}
	}

}
