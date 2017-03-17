/**
 * 
 */
package com.hzgg.nec.roommanage.po;

import java.io.Serializable;

/**
 * roomquery 视图持久化类
 * @author Mr.H
 *
 * create date  2017年3月2日  下午3:03:27
 */
public class RoomQuery implements Serializable {
	
	private String roomid;
	private String typename;
	private String locations;
	private String remark;
	private String status;
	private Double price;
	
	
	/**
	 * 
	 */
	public RoomQuery() {
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


	/**
	 * @return the typename
	 */
	public String getTypename() {
		return typename;
	}


	/**
	 * @param typename the typename to set
	 */
	public void setTypename(String typename) {
		this.typename = typename;
	}


	/**
	 * @return the locations
	 */
	public String getLocations() {
		return locations;
	}


	/**
	 * @param locations the locations to set
	 */
	public void setLocations(String locations) {
		this.locations = locations;
	}


	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}


	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	

}
