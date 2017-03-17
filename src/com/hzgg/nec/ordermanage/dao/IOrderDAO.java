/**
 * 
 */
package com.hzgg.nec.ordermanage.dao;

import java.util.List;

import com.hzgg.nec.ordermanage.po.Order;
import com.hzgg.nec.roommanage.po.Room;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  上午11:18:08
 */
public interface IOrderDAO {
	
	/**
	 * 添加订单
	 * @param o
	 * @return
	 */
	public boolean addOrder(Order o);
	
	
	/**
	 * 根据客房id删除order
	 * @param r
	 * @return
	 */
	public boolean deleteOrder(Room r);
	
	
	/** 根据订单id删除order
	 * @param orderid
	 * @return
	 */
	public boolean deleteOrder(String orderid);
	
	/**
	 * 查询页数
	 * @param o
	 * @return
	 */
	public int getPagesC(Order o);
	
	/**
	 * 条件查询所有订单
	 * @param pages
	 * @param pagesize
	 * @param o
	 * @return
	 */
	public List<Order> getOrdersConditon(int pages, int pagesize, Order o);
	
	
	public Order getOrderById(String id);
	
	public boolean updateOrder(Order o);
	
	/**
	 * 根据idcard查询用户姓名
	 * @param id
	 * @return
	 */
	public String getCustomerByIdcard(String id);
	
	public String getCustomerIdByIdcard(String id);

}
