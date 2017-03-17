/**
 * 
 */
package com.hzgg.nec.ordermanage.action;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.hzgg.nec.checkinmanage.dao.ICheckinDAO;
import com.hzgg.nec.checkinmanage.po.Checkin;
import com.hzgg.nec.checkinmanage.po.Customer;
import com.hzgg.nec.ordermanage.dao.IOrderDAO;
import com.hzgg.nec.ordermanage.po.Order;
import com.hzgg.nec.roommanage.dao.IRoomDAO;
import com.hzgg.nec.roommanage.po.Room;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

/**
 * @author Administrator
 *
 */
public class OrderAction extends ActionSupport implements  ServletRequestAware,ServletResponseAware {
	private HttpServletResponse response;
	private HttpServletRequest request;
	private HttpSession session;
	
	private Order order;
	private String roomid;
	private String customername;
	private int pages;
	private String info;
	private String ajaxField;
	private Customer customer;
	/**
	 * 
	 */
	public OrderAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 添加订单并修改客房状态
	 * @return
	 * @throws Exception
	 */
	public String addOrder() throws Exception{
	 IOrderDAO iod=(IOrderDAO)request.getAttribute("IOrderDAO");
	 IRoomDAO ird=(IRoomDAO)request.getAttribute("IRoomDAO");
	 Order order = new Order();
	 Room room = new Room();
	 order.setCustomername(customername);
	 order.setRoomid(roomid);
	 room.setRoomid(roomid);
	 room.setStatus("1");
	 
	 if(iod.addOrder(order)){
		 if(ird.updateRoomStatus(room)){
			 info="添加成功";
		 }else{
			 if(iod.deleteOrder(room)){
				 info="添加失败";
			 }else{
				 info="系统出错， 完蛋了";
			 }
		 }
	 }else {
		info = "添加失败";
	 }
	 roomid = null;
	 return "success";
	}
	
	public String showOrders() throws Exception{
		IOrderDAO iod = (IOrderDAO) request.getAttribute("IOrderDAO");
//System.out.println(checkinQuery.getCustomername());
		if(order != null){
			System.out.println(order.getCustomername());
		}
		int pageSize = iod.getPagesC(order);
		request.setAttribute("pageSize", pageSize);
//System.out.println(pageSize);
		
		String p = request.getParameter("pages");

		if(p != null){
			pages = Integer.parseInt(p);
		}else {
			pages = 1;
		}
		
		if(pages <= 0){
			pages = 1;
		}
		if(pages > pageSize){
			pages = pageSize;
		}
		int ps = 4;
		//System.out.println(order);
		List<Order> orders = iod.getOrdersConditon(pages, ps, order);
		request.setAttribute("pages", pages);
		request.setAttribute("orders", orders);
		//System.out.println(orders.size());
		return "success";
	}
	
	
	public String gotoModifyOrder() throws Exception{
		String orderid = request.getParameter("orderid");
		IOrderDAO iod = (IOrderDAO) request.getAttribute("IOrderDAO");
		order = iod.getOrderById(orderid);
		return "success";
	}
	
	public String orderModify() throws Exception{
		//修改前订单房间号
		String oldRoomId = request.getParameter("oldRoomId");
		IOrderDAO iod = (IOrderDAO) request.getAttribute("IOrderDAO");
		IRoomDAO ird=(IRoomDAO)request.getAttribute("IRoomDAO");
		Room oldRoom = new Room();
		oldRoom.setRoomid(oldRoomId);
		oldRoom.setStatus("0");
		Room newRoom = new Room();
		newRoom.setRoomid(order.getRoomid());
		newRoom.setStatus("1");
//System.out.println(order.getCustomername());
		if(iod.updateOrder(order) & ird.updateRoomStatus(newRoom) & ird.updateRoomStatus(oldRoom)){
			info = "更新成功";
		}else{
			info = "更新失败";
		}
		
		return "success";
	}
	
	public String gotoOrderToCheckin() throws Exception{
		String orderid = request.getParameter("orderid");
		IOrderDAO iod = (IOrderDAO) request.getAttribute("IOrderDAO");
		order = iod.getOrderById(orderid);
		return "success";
	}
	
	
	public String checkIdCard() throws Exception {
		String idcard = request.getParameter("idcard");
		IOrderDAO iod = (IOrderDAO) request.getAttribute("IOrderDAO");
		Map<String,Object> map = new HashMap<String,Object>();
		String name = iod.getCustomerByIdcard(idcard);
		if(name == null){
			map.put("result", "true");
			map.put("id", "0");
		}else{
			if(customername.equals(name)){
				map.put("result", "true");
				map.put("id", "1");
			}else{
				map.put("result", "false");
			}
		}
		JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
	    ajaxField = json.toString();
		return "success";
	}
	
	public String orderToCheckin() throws Exception {
		String repeat = request.getParameter("repeat");
		String orderid = request.getParameter("orderid");
		String network = request.getParameter("network");
		IOrderDAO iod = (IOrderDAO) request.getAttribute("IOrderDAO");
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		IRoomDAO ird = (IRoomDAO) request.getAttribute("IRoomDAO");
		if("0".equals(repeat)){
			icd.insertCustomer(customer);
		}
		
		String cid = iod.getCustomerIdByIdcard(customer.getIdcard());
		System.out.println(cid);
		Checkin c = new Checkin();
		c.setCheckindate(new Date(new java.util.Date().getTime()));
		c.setCustomerid(cid);
		c.setNetwork(network);
		System.out.println(roomid);
		c.setRoomid(roomid);
		c.setPledge(0.0);
		iod.deleteOrder(orderid);
		Room r = new Room();
		r.setRoomid(cid);
		r.setStatus("2");
		ird.updateRoomStatus(r);
		if(icd.insertCheckin(c)){
			info = "入住成功";
		}
		return "success";
	}
	
	
	/**
	 * 订单修改时验证roomid是否可用
	 * @return
	 */
	public String checkRoomId() throws Exception{
		IRoomDAO ird=(IRoomDAO)request.getAttribute("IRoomDAO");
		String roomid = request.getParameter("roomid"); 
		Map<String,Object> map = new HashMap<String,Object>();
        //System.out.println(request.get == null);
        if(ird.getRoomQueryById(roomid) == null || !("空".equals(ird.getRoomQueryById(roomid).getStatus()))  ){
        	map.put("result", "false");
        }else{
        	map.put("result", "true");
        }
        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
        setAjaxField(json.toString());
        return "success";
	}
	
	public String deleteOrder() throws Exception{
		IOrderDAO iod = (IOrderDAO) request.getAttribute("IOrderDAO");
		IRoomDAO ird=(IRoomDAO)request.getAttribute("IRoomDAO");
		String orderid = request.getParameter("orderid");
		iod.deleteOrder(orderid);
		Room r = new Room();
		r.setRoomid(roomid);
		r.setStatus("0");
		ird.updateRoomStatus(r);
		return "success";
	}
	
	/**
	 * 检测身份证号是否可用
	 * @return
	 * @throws Exception
	 */

	
//	public void updateOrder() throws Exception{
//		 IOrderDAO iod=(IOrderDAO)request.getAttribute("IOrderDAO");
//		 String info=null;
//		 boolean result=iod.updateOrder(o);
//		 if(result){
//			 info="更新成功";
//		 }else{
//			 info="更新失败";
//		 }
//		  response.setContentType("text/html;charset=GB18030");
//		  PrintWriter out=response.getWriter();
//		  out.println(info);
//		  out.close();
//		  
//		}
	
//	public void deleteOrder() throws Exception{
//		 IOrderDAO iod=(IOrderDAO)request.getAttribute("IOrderDAO");
//		 String info=null;
//		 boolean result=iod.deleteOrder(o);
//		 if(result){
//			 info="删除成功";
//		 }else{
//			 info="删除失败";
//		 }
//		  response.setContentType("text/html;charset=GB18030");
//		  PrintWriter out=response.getWriter();
//		  out.println(info);
//		  out.close();
//		}
	
	

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}
	/**
	 * @param response the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response=arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request=arg0;
		session=request.getSession();
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}


	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}


	/**
	 * @return the customername
	 */
	public String getCustomername() {
		return customername;
	}


	/**
	 * @param customername the customername to set
	 */
	public void setCustomername(String customername) {
		this.customername = customername;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}


	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}


	public String getAjaxField() {
		return ajaxField;
	}


	public void setAjaxField(String ajaxField) {
		this.ajaxField = ajaxField;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
