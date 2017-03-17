/**
 * 
 */
package com.hzgg.nec.checkoutmanage.po;

import java.io.Serializable;
import java.sql.Date;

import com.hzgg.nec.checkinmanage.po.Customer;

/**
 * @author LJJ
 *
 * 2017年3月6日上午9:17:09
 */
public class CoNetWork implements Serializable {
	
	private Integer networkid;
	private String roomid;
	private String customername;
	private Date ondate;
	private Date offdate;
	
	private Double netmoney;
	private String strondate;
	private String stroffdate;
	

	/**
	 * 
	 */
	public CoNetWork() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the networkid
	 */
	public Integer getNetworkid() {
		return networkid;
	}


	/**
	 * @param networkid the networkid to set
	 */
	public void setNetworkid(Integer networkid) {
		this.networkid = networkid;
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


	/**
	 * @return the ondate
	 */
	public Date getOndate() {
		return ondate;
	}


	/**
	 * @param ondate the ondate to set
	 */
	public void setOndate(Date ondate) {
		this.ondate = ondate;
	}


	/**
	 * @return the offdate
	 */
	public Date getOffdate() {
		return offdate;
	}


	/**
	 * @param offdate the offdate to set
	 */
	public void setOffdate(Date offdate) {
		this.offdate = offdate;
	}


	/**
	 * @return the netmoney
	 */
	public Double getNetmoney() {
		return netmoney;
	}


	/**
	 * @param netmoney the netmoney to set
	 */
	public void setNetmoney(Double netmoney) {
		this.netmoney = netmoney;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CoNetWork [networkid=" + networkid + ", roomid=" + roomid + ", customername=" + customername
				+ ", ondate=" + ondate + ", offdate=" + offdate + ", netmoney=" + netmoney + "]";
	}


	/**
	 * @return the strondate
	 */
	public String getStrondate() {
		return strondate;
	}


	/**
	 * @param strondate the strondate to set
	 */
	public void setStrondate(String strondate) {
		this.strondate = strondate;
	}


	/**
	 * @return the stroffdate
	 */
	public String getStroffdate() {
		return stroffdate;
	}


	/**
	 * @param stroffdate the stroffdate to set
	 */
	public void setStroffdate(String stroffdate) {
		this.stroffdate = stroffdate;
	}

}
