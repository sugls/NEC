/**
 * 
 */
package com.hzgg.nec.roommanage.po;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  下午12:59:29
 */
public class Network implements Serializable {

	private Integer networkid;
 	private String checkinid;
 	private Date ondate; 
 	private Date offdate;
	
	/**
	 * 
	 */
	public Network() {
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



}
