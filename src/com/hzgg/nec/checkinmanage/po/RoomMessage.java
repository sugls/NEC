/**
 * 
 */
package com.hzgg.nec.checkinmanage.po;

import java.io.Serializable;
import java.util.List;

/**
 * @author LJJ
 *
 * 2017年3月2日下午2:36:20
 */
public class RoomMessage implements Serializable {
	
	private String roomid;
	private String typeid;
	private String locations;
	private String remark;
	private String status;
	private String typename;
	private Double price;
	
	private String strid;
	

	/**
	 * 
	 */
	public RoomMessage() {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoomMessage [roomid=" + roomid + ", typeid=" + typeid + ", locations=" + locations + ", remark="
				+ remark + ", status=" + status + ", typename=" + typename + ", price=" + price + "]";
	}

	/**
	 * @return the strid
	 */
	public String getStrid() {
		return strid;
	}

	/**
	 * @param strid the strid to set
	 */
	public void setStrid(String strid) {
		this.strid = strid;
	}

}
