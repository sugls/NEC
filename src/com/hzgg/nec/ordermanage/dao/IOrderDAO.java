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
 * create date  2017��3��1��  ����11:18:08
 */
public interface IOrderDAO {
	
	/**
	 * ��Ӷ���
	 * @param o
	 * @return
	 */
	public boolean addOrder(Order o);
	
	
	/**
	 * ���ݿͷ�idɾ��order
	 * @param r
	 * @return
	 */
	public boolean deleteOrder(Room r);
	
	
	/** ���ݶ���idɾ��order
	 * @param orderid
	 * @return
	 */
	public boolean deleteOrder(String orderid);
	
	/**
	 * ��ѯҳ��
	 * @param o
	 * @return
	 */
	public int getPagesC(Order o);
	
	/**
	 * ������ѯ���ж���
	 * @param pages
	 * @param pagesize
	 * @param o
	 * @return
	 */
	public List<Order> getOrdersConditon(int pages, int pagesize, Order o);
	
	
	public Order getOrderById(String id);
	
	public boolean updateOrder(Order o);
	
	/**
	 * ����idcard��ѯ�û�����
	 * @param id
	 * @return
	 */
	public String getCustomerByIdcard(String id);
	
	public String getCustomerIdByIdcard(String id);

}
