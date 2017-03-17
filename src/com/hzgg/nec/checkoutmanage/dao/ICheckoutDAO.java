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
 * create date  2017��3��1��  ����1:11:59
 */
public interface ICheckoutDAO {
	
	/**
	 * �������������Ϣ
	 * @return CoNetWork����
	 */
	public List<CoNetWork> getAllNetwork(CoNetWork conetwork,int pages,int pagesize);
	
	/**
	 * ��������
	 * @param conetwork ������Ϣ����
	 * @return ���ѵ���ϸ��Ϣ
	 */
	public CoNetWork getNetCost(CoNetWork conetwork);
	
	/**
	 * ������������������ס��Ϣ
	 * @param checkinmessage ��ס��Ϣ����
	 * @return CheckinMessage����
	 */
	public List<CheckinMessage> selectAllCheckinByName(CheckinMessage checkinmessage,int pages,int pagesize);
	
	/**
	 * �˷����޸ĸ���״̬�����ҽ���
	 * @param cm �˷��û��ĸ�����ϸ��Ϣ
	 * @return �˷�����ϸ��Ϣ
	 */
	public CheckinMessage checkoutAndCost(CheckinMessage cm);
	
	/**
	 * ������ס��Ų�ѯ������Ϣ
	 * @param checkinid ��ס���
	 * @return
	 */
	public CheckinMessage checkoutMessageById(String checkinid);
	
	/**
	 * ��ȡcheckin��Ϣ���ܼ�¼��
	 * @param pagesize ÿҳ��ʾ��Ϣ��
	 * @return ��ҳ��
	 */
	public int getCheckinTotalpages(int pagesize);
	
	/**
	 * ��ȡnetwork��Ϣ���ܼ�¼��
	 * @param pagesize ÿҳ��ʾ��Ϣ��
	 * @return ��ҳ��
	 */
	public int getNetworkTotalpages(int pagesize);
	

}
