/**
 * 
 */
package com.hzgg.nec.roommanage.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.hzgg.nec.roommanage.dao.IRoomDAO;
import com.hzgg.nec.roommanage.dao.RoomDAOImpl;
import com.hzgg.nec.roommanage.po.CheckinQuery;
import com.hzgg.nec.roommanage.po.RoomQuery;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

/**
 * @author Mr.H
 *
 * create date  2017年3月6日  上午10:29:24
 */
public class NetworkAction extends ActionSupport implements ServletResponseAware, ServletRequestAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	
	private CheckinQuery checkinQuery;
	private Integer  pages;
	private String ajaxField;
	/**
	 * 
	 */
	public NetworkAction() {
		// TODO Auto-generated constructor stub
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
	 * @return the checkinQuery
	 */
	public CheckinQuery getCheckinQuery() {
		return checkinQuery;
	}




	/**
	 * @param checkinQuery the checkinQuery to set
	 */
	public void setCheckinQuery(CheckinQuery checkinQuery) {
		this.checkinQuery = checkinQuery;
	}

	



	/**
	 * @return the pages
	 */
	public Integer getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	

	/**
	 * @return the ajaxField
	 */
	public String getAjaxField() {
		return ajaxField;
	}


	/**
	 * @param ajaxField the ajaxField to set
	 */
	public void setAjaxField(String ajaxField) {
		this.ajaxField = ajaxField;
	}


	/**
	 * 分页获取所有入住信息
	 * @return
	 */
	public String getCheckins(){
		IRoomDAO ird = (IRoomDAO) request.getAttribute("IRoomDAO");

		
//System.out.println(checkinQuery.getCustomername());
		int pageSize = ird.getPageSizeC(checkinQuery);
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
		
		List<CheckinQuery> rqs = ird.getCheckinQueriesConditon(pages, pageSize, checkinQuery);
		request.setAttribute("pages", pages);
		request.setAttribute("checkinqueries", rqs);
		return "success";
	}
	
	
	/**
	 * 网络开通方法
	 * @return
	 */
	public String netOn() throws Exception{
		IRoomDAO ird = (IRoomDAO) request.getAttribute("IRoomDAO");
        Map<String,Object> map = new HashMap<String,Object>();
//System.out.println(request.get == null);
//System.out.println(checkinQuery.getCheckinid());
        if(ird.netOn(checkinQuery.getCheckinid())){
        	if(ird.addNet(checkinQuery)){
        		map.put("result", "true");
        	} else {
        		System.out.println("adasdasd");
        		map.put("result", "false");
        	}     	
        }else{
        	map.put("result", "false");
        }
        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
        ajaxField = json.toString();
        return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = request.getSession();
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

}
