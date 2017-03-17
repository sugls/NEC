/**
 * 
 */
package com.hzgg.nec.checkoutmanage.dao;

import java.util.List;

import com.hzgg.nec.checkoutmanage.po.CheckinMessage;
import com.hzgg.nec.checkoutmanage.po.CoNetWork;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  下午1:11:59
 */
public interface ICheckoutDAO {
	
	/**
	 * 所有网络管理信息
	 * @return CoNetWork集合
	 */
	public List<CoNetWork> getAllNetwork(CoNetWork conetwork,int pages,int pagesize);
	
	/**
	 * 结算网费
	 * @param conetwork 网络信息对象
	 * @return 网费的详细信息
	 */
	public CoNetWork getNetCost(CoNetWork conetwork);
	
	/**
	 * 按照姓名查找所有入住信息
	 * @param checkinmessage 入住信息对象
	 * @return CheckinMessage集合
	 */
	public List<CheckinMessage> selectAllCheckinByName(CheckinMessage checkinmessage,int pages,int pagesize);
	
	/**
	 * 退房，修改各种状态，并且结算
	 * @param cm 退房用户的各种详细信息
	 * @return 退房的详细信息
	 */
	public CheckinMessage checkoutAndCost(CheckinMessage cm);
	
	/**
	 * 根据入住编号查询结账信息
	 * @param checkinid 入住编号
	 * @return
	 */
	public CheckinMessage checkoutMessageById(String checkinid);
	
	/**
	 * 获取checkin信息的总记录数
	 * @param pagesize 每页显示信息数
	 * @return 总页数
	 */
	public int getCheckinTotalpages(int pagesize);
	
	/**
	 * 获取network信息的总记录数
	 * @param pagesize 每页显示信息数
	 * @return 总页数
	 */
	public int getNetworkTotalpages(int pagesize);
	

}
