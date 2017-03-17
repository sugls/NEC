/**
 * 
 */
package com.hzgg.nec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hzgg.nec.checkinmanage.dao.CheckinDAOImpl;
import com.hzgg.nec.checkinmanage.dao.ICheckinDAO;
import com.hzgg.nec.checkoutmanage.dao.CheckoutDAOImpl;
import com.hzgg.nec.checkoutmanage.dao.ICheckoutDAO;
import com.hzgg.nec.employeemanage.dao.EmployeeDAOImpl;
import com.hzgg.nec.employeemanage.dao.IEmployeeDAO;
import com.hzgg.nec.ordermanage.dao.IOrderDAO;
import com.hzgg.nec.ordermanage.dao.OrderDAOImpl;
import com.hzgg.nec.roommanage.dao.IRoomDAO;
import com.hzgg.nec.roommanage.dao.RoomDAOImpl;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author Mr.H
 *
 * create date  2017��3��2��  ����8:47:07
 */
public class InstanceInterceptor implements Interceptor {

	private IRoomDAO ird;
	private IOrderDAO iod;
	private IEmployeeDAO ied;
	private ICheckinDAO iid;
	private ICheckoutDAO icd;
	
	/**
	 * 
	 */
	public InstanceInterceptor() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		ird = null;
		iod = null;
		ied = null;
		iid = null;
		icd = null;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
		ird = new RoomDAOImpl();
		iod = new OrderDAOImpl();
		ied = new EmployeeDAOImpl();
		iid = new CheckinDAOImpl();
		icd = new CheckoutDAOImpl();
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("IRoomDAO", ird);
		request.setAttribute("IOrderDAO", iod);
		request.setAttribute("IEmployeeDAO", ied);
		request.setAttribute("ICheckinDAO", iid);
		request.setAttribute("ICheckoutDAO", icd);
		HttpSession httpSession = request.getSession();
		int i = ird.getNotOnNetworks();
		httpSession.setAttribute("netCounts", i);
		return arg0.invoke();
	}

}
