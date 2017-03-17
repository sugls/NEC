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
 * create date  2017��3��1��  ����11:29:24
 */
public interface ICheckinDAO {
	
	/**
	 * �Ǽǿͻ���Ϣ
	 * @param customer �ͻ��Ļ�����Ϣ
	 * @return �Ƿ�Ǽǳɹ�
	 */
	public boolean insertCustomer(Customer customer);
	
	/**
	 * ��ҳ��ʾ�ͻ���Ϣ
	 * @param pages ��ǰҳ
	 * @param pagesize ÿҳ��Ϣ��
	 * @return Customer����
	 */
	public List<Customer> showAllCustomers(int pages,int pagesize);
	
	/**
	 * ���ݿͻ���Ų�ѯ�ͻ���Ϣ
	 * @param customerid �ͻ����
	 * @return �ͻ�����ϸ��Ϣ
	 */
	public Customer selectCustomerById(String customerid);
	
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param customer �ͻ��Ļ�����Ϣ
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyCustomer(Customer customer);
	
	/**
	 * ��ȡ��ҳ��
	 * @param pagesize ÿҳ��Ϣ����
	 * @return ��ҳ��
	 */
	public int getTotalPages(int pagesize); 
	
	/**
	 * ���ݿͻ����ɾ���ͻ���Ϣ
	 * @param customerid �ͻ����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteCustomer(String customerid);
	
	/**
	 * �����������ҿͻ���Ϣ
	 * @param customer �ͻ�����ϸ��Ϣ
	 * @return Customer����
	 */
	public List<Customer> selectCustomerByCondition(Customer customer,int pages,int pagesize);
	
	/**
	 * ������֤���Ƿ����
	 * @param idcard ���֤��
	 * @return �Ƿ�Ϸ�
	 */
	public boolean isAvailiableIDcard(String idcard);
	
	/**
	 * ���ݷ������Ͳ��Ҹ����͵����пշ���Ϣ
	 * @param roomtype ��������
	 * @return RoomMessage����
	 */
	public List<RoomMessage> selectRoomByStatusAndType(String roomtype);
	
	/**
	 * ��ѯδ��ס�Ŀͻ���Ϣ
	 * @return Customer����
	 */
	public List<Customer> selectCustomerByIscheckin();
	
	/**
	 * �ͻ���ס����
	 * @param checkin �ͻ���ס��Ϣ
	 * @return �Ƿ������ס�ɹ�
	 */
	public boolean insertCheckin(Checkin checkin);
	
	/**
	 * ���¥����Ϣ
	 * @return ¥��ż���
	 */
	public List<String> selectFloorMessage();
	
	/**
	 * ����¥���ŷ��ض�Ӧ¥������з�����Ϣ
	 * @return ¥���з������Ϣ����
	 */
	public List<List<RoomMessage>> selectRoomMessageByFloor();

}
