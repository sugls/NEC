/**
 * 
 */
package com.hzgg.nec.roommanage.po;

import java.io.Serializable;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  下午12:57:19
 */
public class Room implements Serializable {

	private String roomid;
	private String typeid;
	private String locations;
	private String remark;
	private String status;
	
	/**
	 * 
	 */
	public Room() {
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
	 * @return the typeid
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
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
	
	

}
