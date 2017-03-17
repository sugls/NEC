/**
 * 
 */
package com.hzgg.nec.checkinmanage.po;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  下午12:51:43
 */
public class Checkin implements Serializable {
	
	private String checkinid;
	private String roomid;
	private String customerid;
	private Date checkindate;
	private Date checkoutdate;
	private Double pledge;
	private String network;
	private String neton;

	/**
	 * 
	 */
	public Checkin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the checkinid
	 */
	public String getCheckinid() {
		return checkinid;
	}

	/**
	 * @param checkinid the checkinid to set
	 */
	public void setCheckinid(String checkinid) {
		this.checkinid = checkinid;
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
	 * @return the customerid
	 */
	public String getCustomerid() {
		return customerid;
	}

	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	/**
	 * @return the checkindate
	 */
	public Date getCheckindate() {
		return checkindate;
	}

	/**
	 * @param checkindate the checkindate to set
	 */
	public void setCheckindate(Date checkindate) {
		this.checkindate = checkindate;
	}

	/**
	 * @return the checkoutdate
	 */
	public Date getCheckoutdate() {
		return checkoutdate;
	}

	/**
	 * @param checkoutdate the checkoutdate to set
	 */
	public void setCheckoutdate(Date checkoutdate) {
		this.checkoutdate = checkoutdate;
	}

	/**
	 * @return the pledge
	 */
	public Double getPledge() {
		return pledge;
	}

	/**
	 * @param pledge the pledge to set
	 */
	public void setPledge(Double pledge) {
		this.pledge = pledge;
	}

	/**
	 * @return the network
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * @param network the network to set
	 */
	public void setNetwork(String network) {
		this.network = network;
	}

	/**
	 * @return the neton
	 */
	public String getNeton() {
		return neton;
	}

	/**
	 * @param neton the neton to set
	 */
	public void setNeton(String neton) {
		this.neton = neton;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Checkin [checkinid=" + checkinid + ", roomid=" + roomid + ", customerid=" + customerid
				+ ", checkindate=" + checkindate + ", checkoutdate=" + checkoutdate + ", pledge=" + pledge
				+ ", network=" + network + ", neton=" + neton + "]";
	}

	
}
