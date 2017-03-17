/**
 * 
 */
package com.hzgg.nec.checkinmanage.dao;

import java.util.List;

import com.hzgg.nec.checkinmanage.po.Checkin;
import com.hzgg.nec.checkinmanage.po.Customer;
import com.hzgg.nec.checkinmanage.po.RoomMessage;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  上午11:29:24
 */
public interface ICheckinDAO {
	
	/**
	 * 登记客户信息
	 * @param customer 客户的基本信息
	 * @return 是否登记成功
	 */
	public boolean insertCustomer(Customer customer);
	
	/**
	 * 分页显示客户信息
	 * @param pages 当前页
	 * @param pagesize 每页信息数
	 * @return Customer集合
	 */
	public List<Customer> showAllCustomers(int pages,int pagesize);
	
	/**
	 * 根据客户编号查询客户信息
	 * @param customerid 客户编号
	 * @return 客户的详细信息
	 */
	public Customer selectCustomerById(String customerid);
	
	/**
	 * 修改客户信息
	 * @param customer 客户的基本信息
	 * @return 是否修改成功
	 */
	public boolean modifyCustomer(Customer customer);
	
	/**
	 * 获取总页数
	 * @param pagesize 每页信息行数
	 * @return 总页数
	 */
	public int getTotalPages(int pagesize); 
	
	/**
	 * 根据客户编号删除客户信息
	 * @param customerid 客户编号
	 * @return 是否删除成功
	 */
	public boolean deleteCustomer(String customerid);
	
	/**
	 * 根据条件查找客户信息
	 * @param customer 客户的详细信息
	 * @return Customer集合
	 */
	public List<Customer> selectCustomerByCondition(Customer customer,int pages,int pagesize);
	
	/**
	 * 检测身份证号是否可用
	 * @param idcard 身份证号
	 * @return 是否合法
	 */
	public boolean isAvailiableIDcard(String idcard);
	
	/**
	 * 根据房间类型查找该类型的所有空房信息
	 * @param roomtype 房间类型
	 * @return RoomMessage集合
	 */
	public List<RoomMessage> selectRoomByStatusAndType(String roomtype);
	
	/**
	 * 查询未入住的客户信息
	 * @return Customer集合
	 */
	public List<Customer> selectCustomerByIscheckin();
	
	/**
	 * 客户入住办理
	 * @param checkin 客户入住信息
	 * @return 是否办理入住成功
	 */
	public boolean insertCheckin(Checkin checkin);
	
	/**
	 * 浏览楼层信息
	 * @return 楼层号集合
	 */
	public List<String> selectFloorMessage();
	
	/**
	 * 按照楼层编号返回对应楼层的所有房间信息
	 * @return 楼层中房间的信息集合
	 */
	public List<List<RoomMessage>> selectRoomMessageByFloor();

}
