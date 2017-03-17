/**
 * 
 */
package com.hzgg.nec.roommanage.po;

import java.io.Serializable;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  下午12:59:07
 */
public class RoomType implements Serializable {
	
	private String typeid;
	private String typename;
	private Double price;
	
	/**
	 * 
	 */
	public RoomType() {
		// TODO Auto-generated constructor stub
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
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	
	
}
