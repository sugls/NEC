/**
 * 
 */
package com.hzgg.nec.checkoutmanage.po;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author LJJ
 *
 * 2017年3月6日下午3:35:29
 */
public class CheckinMessage implements Serializable {
	
	private String checkinid;
	private String roomid;
	private String customername;
	private String customerid;
	private Date checkindate;
	private Date checkoutdate;
	private Double pledge;
	private Date ondate;
	private Date offdate;
	private String network;
	private String neton;
	private Double price;
	
	private String strcheckindate;
	private String strcheckoutdate;
	private String strondate;
	private String stroffdate;
	
	private Double netprice;
	private Double hotelprice;
	private String typename;

	/**
	 * 
	 */
	public CheckinMessage() {
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
		return "CheckinMessage [checkinid=" + checkinid + ", roomid=" + roomid + ", customername=" + customername
				+ ", checkindate=" + checkindate + ", checkoutdate=" + checkoutdate + ", pledge=" + pledge + ", ondate="
				+ ondate + ", offdate=" + offdate + ", network=" + network + ", neton=" + neton + "]";
	}

	/**
	 * @return the strcheckindate
	 */
	public String getStrcheckindate() {
		return strcheckindate;
	}

	/**
	 * @param strcheckindate the strcheckindate to set
	 */
	public void setStrcheckindate(String strcheckindate) {
		this.strcheckindate = strcheckindate;
	}

	/**
	 * @return the strcheckoutdate
	 */
	public String getStrcheckoutdate() {
		return strcheckoutdate;
	}

	/**
	 * @param strcheckoutdate the strcheckoutdate to set
	 */
	public void setStrcheckoutdate(String strcheckoutdate) {
		this.strcheckoutdate = strcheckoutdate;
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

	/**
	 * @return the netprice
	 */
	public Double getNetprice() {
		return netprice;
	}

	/**
	 * @param netprice the netprice to set
	 */
	public void setNetprice(Double netprice) {
		this.netprice = netprice;
	}

	/**
	 * @return the hotelprice
	 */
	public Double getHotelprice() {
		return hotelprice;
	}

	/**
	 * @param hotelprice the hotelprice to set
	 */
	public void setHotelprice(Double hotelprice) {
		this.hotelprice = hotelprice;
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

}
