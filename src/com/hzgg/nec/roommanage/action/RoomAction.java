/**
 * 
 */
package com.hzgg.nec.roommanage.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
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
import com.hzgg.nec.roommanage.po.Room;
import com.hzgg.nec.roommanage.po.RoomQuery;
import com.hzgg.nec.roommanage.po.RoomType;
import com.opensymphony.xwork2.ActionSupport;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.sf.json.JSONObject;

/**
 * @author Mr.H
 *
 * create date  2017ï¿½ï¿½3ï¿½ï¿½3ï¿½ï¿½  ï¿½ï¿½ï¿½ï¿½8:39:11
 */
public class RoomAction extends ActionSupport implements ServletResponseAware, ServletRequestAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	
	
	private String roomid;
	private Room room;
	private String conditionid;
	private String condition;
	private String ajaxField;
	/**
	 * 
	 */
	public RoomAction() {
		// TODO Auto-generated constructor stub
		
	}
	
		
	
	/**
	 * @return the roomid
	 */
	public String getRoomid() {
		return roomid;
	}


	/**
	 * @param roomid the roomid to set
	 */
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	
	public Room getRoom() {
		return room;
	}


	public void setRoom(Room Room) {
		room = Room;
	}
	
	


	public HttpServletRequest getRequest() {
		return request;
	}



	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}



	public HttpServletResponse getResponse() {
		return response;
	}



	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}



	public HttpSession getSession() {
		return session;
	}



	public void setSession(HttpSession session) {
		this.session = session;
	}



	public String getConditionid() {
		return conditionid;
	}



	public void setConditionid(String conditionid) {
		this.conditionid = conditionid;
	}



	public String getCondition() {
		return condition;
	}



	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	



	public String getAjaxField() {
		return ajaxField;
	}



	public void setAjaxField(String ajaxField) {
		this.ajaxField = ajaxField;
	}



	public String roomAdd() throws Exception{
		String reqonly = request.getParameter("reqonly");
		if("1".equals(reqonly)){
			IRoomDAO ird = (IRoomDAO) request.getAttribute("IRoomDAO");
			if(session.getAttribute("roomTypes") == null){
				List<RoomType> roomTypes = ird.getRoomTypes();
				session.setAttribute("roomTypes", roomTypes);	
			}
			return "req";
		} else {
			IRoomDAO ird = (IRoomDAO) request.getAttribute("IRoomDAO");
//			Room r = new Room();
//			r.setRoomid((String)request.getAttribute("roomid"));
//			r.setTypeid((String)request.getAttribute("typeid"));
//			r.setStatus((String)request.getAttribute("status"));
//			r.set
			if(ird.addRoom(room)){
				request.setAttribute("info", "Ìí¼Ó³É¹¦");
				return "success";
			} else {
				request.setAttribute("info", "Ìí¼ÓÊ§°Ü");
				return "error";
			}
		}
		
	}
	
	
	/**
	 * ï¿½ï¿½Ê¾ï¿½ï¿½ï¿½Ð¿Õ·ï¿½ï¿½ï¿½Ï¢
	 * @return
	 */
	public String roomsShow(){
		return "success";
	}
	
	/**
	 * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ê¾ï¿½ï¿½ï¿½Ð·ï¿½ï¿½ï¿½ï¿½ï¿½Ï¢Ò³ï¿½ï¿½
	 * @return
	 */
	public String roomsShowStatus(){
		String reqonly = request.getParameter("reqonly");
		IRoomDAO ird = (IRoomDAO) request.getAttribute("IRoomDAO");
		
		int pages = 1;
		
		if(session.getAttribute("roomTypes") == null){
			List<RoomType> roomTypes = ird.getRoomTypes();
			session.setAttribute("roomTypes", roomTypes);	
		}
		
		if("1".equals(reqonly)){
			List<RoomQuery> roomqueries = ird.getRoomQueries(pages, 4);
			//ï¿½ï¿½Ò³ï¿½ï¿½
			int pageSize = ird.getPageSize();
			request.setAttribute("pageSize", pageSize);
			
			request.setAttribute("roomqueries", roomqueries);
			request.setAttribute("pages", pages);
			return "req";
		} else {
			RoomQuery r = new RoomQuery();
			if("1".equals(conditionid)){
				r.setRoomid(condition);
			}else if("2".equals(conditionid)){
				r.setLocations(condition);
			}else if("3".equals(conditionid)){
				r.setTypename(condition);
			}else if("4".equals(conditionid)){
				r.setStatus(condition);
			}
			
//System.out.println(condition+" "+ conditionid );
			
			//ï¿½ï¿½Ò³ï¿½ï¿½
			int pageSize = ird.getPageSizeCondition(r);
			request.setAttribute("pageSize", pageSize);
//System.out.println(pageSize);
			
			String p = request.getParameter("pages");
			//ï¿½ï¿½Ç°Ò³ï¿½ï¿½
			if(p != null){
				pages = Integer.parseInt(p);
			}
			
			if(pages <= 0){
				pages = 1;
			}
			if(pages > pageSize){
				pages = pageSize;
			}
			
			List<RoomQuery> rqs = ird.getRoomQueriesConditon(pages, pageSize, r);
			request.setAttribute("pages", pages);
			request.setAttribute("roomqueries", rqs);
			return "success";
		}
	}
	
	/**
	 * ï¿½Í·ï¿½idï¿½ï¿½Ö¤
	 * @return
	 */
	public String checkRoomId() throws Exception{
		IRoomDAO ird = new RoomDAOImpl();
        Map<String,Object> map = new HashMap<String,Object>();
        //System.out.println(request.get == null);
        if(ird.getRoomQueryById(roomid) == null){
        	map.put("result", "true");
        }else{
        	map.put("result", "false");
        }
        JSONObject json = JSONObject.fromObject(map);//½«map¶ÔÏó×ª»»³ÉjsonÀàÐÍÊý¾Ý
        ajaxField = json.toString();
        return "success";
	}
	
	
	/**
	 *	ï¿½Í·ï¿½É¾ï¿½ï¿½
	 * @return
	 * @throws Exception
	 */
	public String roomDelete() throws Exception{
		IRoomDAO ird = (IRoomDAO) request.getAttribute("IRoomDAO");
		Room dr = new Room();
		//System.out.println(roomid);
		dr.setRoomid(roomid);
		if(ird.deleteRoom(dr)){
			System.out.println(1);
			return "success";
		}else{
			return "error";
		}
	}

	
	/**
	 *	ï¿½Í·ï¿½ï¿½ï¿½Ï¢ï¿½ï¿½ï¿½ï¿½
	 * @return
	 * @throws Exception
	 */
	public String roomModify() throws Exception{
		String reqonly = request.getParameter("reqonly");
		IRoomDAO ird = (IRoomDAO) request.getAttribute("IRoomDAO");

		if("1".equals(reqonly)){
			RoomQuery r = ird.getRoomQueryById(roomid);
			request.setAttribute("roomquery", r);
			return "req";
		}else if(reqonly == null){
			if(ird.updateRoom(room)){
				request.setAttribute("info", "¸üÐÂ³É¹¦");
				return "success";
			} else {
				request.setAttribute("info", "¸üÐÂÊ§°Ü");
				return "error";
			}
		}
		return "success";
	}
	
	
	public String showEmptyRooms() throws Exception {
		String reqonly = request.getParameter("reqonly");
		IRoomDAO ird = (IRoomDAO) request.getAttribute("IRoomDAO");
		List<RoomQuery> roomQueries = ird.getRoomEmptyQueries();
		request.setAttribute("emptyRoomQueries", roomQueries);
		return "success";
	}

	
	/**
	 * 	Ç°Ì¨ajaxÇëÇó»ñÈ¡room
	 * @return
	 * @throws Exception
	 */
	public String getEmptyRoomById() throws Exception {
		IRoomDAO ird = (IRoomDAO) request.getAttribute("IRoomDAO");
		RoomQuery roomQuery = ird.getRoomQueryById(roomid);
		Map<String,Object> map = new HashMap<String,Object>();
        //System.out.println(request.get == null);
        Class c = RoomQuery.class;
        for(int i = 0; i < c.getDeclaredFields().length; i++){
        	String name = c.getDeclaredFields()[i].getName();
        	name ="get" + name.substring(0, 1).toUpperCase() + name.substring(1);
        	Method m = c.getMethod(name);
//System.out.println(m.invoke(roomQuery));
        	map.put(c.getDeclaredFields()[i].getName(), m.invoke(roomQuery));
        }
        JSONObject json = JSONObject.fromObject(map);//½«map¶ÔÏó×ª»»³ÉjsonÀàÐÍÊý¾Ý
        ajaxField = json.toString();
		return "success";
	}
	
	
	
	
	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		// TODO Auto-generated method stub
		request = httpServletRequest;
		session = request.getSession();
		
	}


	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		// TODO Auto-generated method stub
		response = httpServletResponse;
	}
	
	
	

}
