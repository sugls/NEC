/**
 * 
 */
package com.hzgg.nec.checkinmanage.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.components.ActionMessage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.hzgg.nec.checkinmanage.dao.ICheckinDAO;
import com.hzgg.nec.checkinmanage.po.Checkin;
import com.hzgg.nec.checkinmanage.po.Customer;
import com.hzgg.nec.checkinmanage.po.RoomMessage;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author LJJ
 *
 * 2017��3��2������6:38:46
 */
public class CheckinAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private HttpServletRequest request;
	private HttpSession session;
	private HttpServletResponse response;
	
	private Customer customer;
	private String idcard;
	private String id;
	
	private int pagesize = 5;
	private int pages = 1;
	
	private String roomtype;
	
	private Checkin checkin;
	private String rid;
	private String ic;
	
	private String condition;
	private String keyword;

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * 
	 */
	public CheckinAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the rid
	 */
	public String getRid() {
		return rid;
	}

	/**
	 * @return the ic
	 */
	public String getIc() {
		return ic;
	}

	/**
	 * @param ic the ic to set
	 */
	public void setIc(String ic) {
		this.ic = ic;
	}

	/**
	 * @param rid the rid to set
	 */
	public void setRid(String rid) {
		this.rid = rid;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
		session = request.getSession();	
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * @return the idcard
	 */
	public String getIdcard() {
		return idcard;
	}

	/**
	 * @param idcard the idcard to set
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	/**
	 * @return the pagesize
	 */
	public int getPagesize() {
		return pagesize;
	}

	/**
	 * @param pagesize the pagesize to set
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the roomtype
	 */
	public String getRoomtype() {
		return roomtype;
	}

	/**
	 * @param roomtype the roomtype to set
	 */
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	/**
	 * @return the checkin
	 */
	public Checkin getCheckin() {
		return checkin;
	}

	/**
	 * @param checkin the checkin to set
	 */
	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}

	/**
	 * ������֤�����Ƿ����
	 * @return
	 * @throws Exception
	 */
	public String checkIdcard() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		String info = null;
		if(icd.isAvailiableIDcard(getIdcard())){
			info = "<img src='img/ok.png'/>";
		}else{
			info = "<img src='img/no.jpg'/>";
		}
		PrintWriter out = response.getWriter();
		out.println(info);
		out.close();
		return null;
	}
	
	/**
	 * ��ӿͻ���Ϣ
	 * @return
	 * @throws Exception
	 */
	public String addCustomer() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		addActionMessage(icd.insertCustomer(customer)?"��ӿͻ���Ϣ�ɹ�":"��ӿͻ���Ϣʧ��");
		session.removeAttribute("totalpages");
		return "success";
	}
	
	/**
	 * ǰ̨�Ӵ���Ա�鿴���пͻ�
	 * @return
	 * @throws Exception
	 */
	public String rpShowCustomers() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		Integer totalpages = (Integer) session.getAttribute("totalpages");
		if(totalpages == null){
			totalpages = icd.getTotalPages(pagesize);
			session.setAttribute("totalpages", totalpages);
		}
		if(pages < 1){
			pages = 1;
		}
		if(pages > totalpages){
			pages = totalpages;
		}
		
		List<Customer> list = icd.showAllCustomers(pages, pagesize);
		request.setAttribute("RPcustomers", list);
		return "success";
	}
	
	/**
	 * ǰ̨���ݿͻ���Ų鿴�ͻ���ϸ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public String rpShowOneCustomer() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		Customer customer = icd.selectCustomerById(getId());
		request.setAttribute("oneCustomer", customer);
		return "success";
	}
	
	/**
	 * ǰ̨�޸Ŀͻ���Ϣ
	 * @return
	 * @throws Exception
	 */
	public String rpModifyOneCustomer() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		addActionMessage(icd.modifyCustomer(customer)?"�޸���Ϣ�ɹ�":"�޸���Ϣʧ��");
		return "success";
	}
	
	/**
	 * ǰ̨ɾ���ͻ���Ϣ
	 * @return
	 * @throws Exception
	 */
	public String rpDeleteOneCustomer() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		//addActionMessage(icd.deleteCustomer(id)?"ɾ����Ϣ�ɹ�":"ɾ����Ϣʧ��");
		request.setAttribute("message", icd.deleteCustomer(id)?"ɾ����Ϣ�ɹ�":"ɾ����Ϣʧ��");
		session.removeAttribute("totalpages");
		return "success";
	}
	
	/**
	 * ����������ѯ�����û���Ϣ
	 * @return
	 * @throws Exception
	 */
	public String showCustomers() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		Integer totalpages = (Integer) session.getAttribute("totalpages");
		System.out.println(totalpages);
		customer = new Customer();
		totalpages = icd.getTotalPages(pagesize);
		session.setAttribute("totalpages", totalpages);
		if(pages < 1){
			pages = 1;
		}
		if(pages > totalpages){
			pages = totalpages;
		}

		if("1".equals(condition)){
			customer.setCustomerid(keyword);
		}else if("2".equals(condition)){
			customer.setCustomername(keyword);
		}else if("3".equals(condition)){
			customer.setIdcard(keyword);
		}
		
		List<Customer> list = icd.selectCustomerByCondition(customer, pages, pagesize);
		request.setAttribute("allShowCustomer", list);
		return "success";
	}
	
	/**
	 * ���ݷ������ͺ�״̬��ʾ������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String showRoomByTypeAndStatus() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		List<RoomMessage> list = icd.selectRoomByStatusAndType(getRoomtype());
		request.setAttribute("showroombytype", list);
		return "success";
	}
	
	/**
	 * δ��ס�Ŀͻ�����ϸ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public String showCustomerByIscheckin() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		List<Customer> list = icd.selectCustomerByIscheckin();
		request.setAttribute("showcustomerbyischeckin", list);
		return "success";
	}
	
	/**
	 * �ͻ���ס����
	 * @return
	 * @throws Exception
	 */
	public String addCheckin() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		addActionMessage(icd.insertCheckin(checkin)?"��ס����ɹ�":"��ס����ʧ��");
		return "success";
	}
	
	/**
	 * ����¥������ʾ���з�����Ϣ
	 * @return
	 * @throws Exception
	 */
	public String selectRoomsByFloors() throws Exception{
		ICheckinDAO icd = (ICheckinDAO) request.getAttribute("ICheckinDAO");
		List<List<RoomMessage>> list = icd.selectRoomMessageByFloor();
		request.setAttribute("roomsbyfloors", list);
		return "success";
	}

}
