/**
 * 
 */
package com.hzgg.nec.ordermanage.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  上午11:17:40
 */
public class Order implements Serializable {
	   private String orderid;
	   private Date orderdate;
	   private String roomid;
	   private String customername;
	/**
	 * 
	 */
	public Order() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the orderid
	 */
	
	/**
	 * @return the orderdate
	 */
	public Date getOrderdate() {
		return orderdate;
	}
	/**
	 * @return the orderid
	 */
	public String getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	/**
	 * @param orderdate the orderdate to set
	 */
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
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

}
