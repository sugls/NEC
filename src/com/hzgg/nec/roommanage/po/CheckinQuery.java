/**
 * 
 */
package com.hzgg.nec.roommanage.po;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Mr.H
 *
 * create date  2017年3月6日  上午10:53:10
 */
public class CheckinQuery implements Serializable {

	private String checkinid;
	private String roomid;
	private String customerid;
	private String customername;
	private Date checkindate;
	private Double pledge;
	private String network;
	private String neton;
	private String checkoutdate;
	
	/**
	 * 
	 */
	public CheckinQuery() {
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
	 * @return the net_work
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * @param net_work the net_work to set
	 */
	public void setNet_work(String network) {
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

	/**
	 * @return the checkoutdate
	 */
	public String getCheckoutdate() {
		return checkoutdate;
	}

	/**
	 * @param checkoutdate the checkoutdate to set
	 */
	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	
	

}
