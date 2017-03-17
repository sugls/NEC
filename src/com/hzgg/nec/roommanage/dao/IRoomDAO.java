/**
 * 
 */
package com.hzgg.nec.roommanage.dao;

import java.util.List;

import com.hzgg.nec.checkinmanage.po.Checkin;
import com.hzgg.nec.roommanage.po.CheckinQuery;
import com.hzgg.nec.roommanage.po.Room;
import com.hzgg.nec.roommanage.po.RoomQuery;
import com.hzgg.nec.roommanage.po.RoomType;

/**
 * @author Mr.H
 *
 * create date  2017��3��1��  ����1:01:47
 */
public interface IRoomDAO {
	
	/**
	 * ��ӿͷ�
	 * @param r �ͷ�
	 * @return boolean �Ƿ�ɹ����
	 */
	public boolean addRoom(Room r);
	
	/**
	 * ���¿ͷ�
	 * @param r �ͷ�
	 * @return boolean �Ƿ�ɹ�����
	 */
	public boolean updateRoom(Room r);
	
	/**
	 * �ͷ�״̬����
	 */
	public boolean updateRoomStatus(Room r);
	
	/**
	 * ����ɾ���ͷ�
	 * @param list �ͷ��б�
	 * @return boolean �Ƿ�ɹ�ɾ��
	 */
	public boolean deleteRoomByList(List<Room> list);
	
	/**
	 * ɾ���ͷ�
	 * @param r ��Ҫɾ���Ŀͷ�
	 * @return 
	 */
	public boolean deleteRoom(Room r);
	

	
	/**
	 * ��ȡ���пͷ���Ϣ
	 * @return list ���пͷ��б�
	 */
	public List<RoomQuery> getRoomQueries();
	
	
	/**
	 * ��ȡ���пտͷ���Ϣ
	 * @return
	 */
	public List<RoomQuery> getRoomEmptyQueries();
	
	
	/**
	 * ��ҳ��ȡ�ͷ���Ϣ
	 * @param pages
	 * @param pageSize
	 * @return
	 */
	public List<RoomQuery> getRoomQueries(int pages, int pageSize);
	
	/**
	 * ����������ҳ��ȡ�ͷ���Ϣ
	 * @param pages
	 * @param pageSize
	 * @return
	 */
	public List<RoomQuery> getRoomQueriesConditon(int pages, int pageSize, RoomQuery r);
	
	/**
	 * ͨ��������ѯ�ͷ���Ϣ
	 * @param r ��ѯ����
	 * @return ���������Ŀͷ�
	 */
	public List<RoomQuery> getRoomQueries(RoomQuery r);
	
	/**
	 * ��ȡ���������Ϣ
	 * @return �����Ϣ�б�
	 */
	public List<RoomType> getRoomTypes();
	
	/**
	 * ͨ������Ż�ȡroomquery
	 * @return roomquery ����
	 */
	public RoomQuery getRoomQueryById(String roomid);
	
	
	/**
	 * ��ѯ���пͷ�ʱ����ҳ��
	 * @return ��ҳ��
	 */
	public int getPageSize();
	
	
	/**
	 * ������ѯ�ͷ�ʱ����ҳ��
	 * @return ��ҳ��
	 */
	public int getPageSizeCondition(RoomQuery r);
	
	
	/**
	 * ����������ҳ��ȡ��ס��Ϣ
	 * @param pages
	 * @param pageSize
	 * @return
	 */
	public List<CheckinQuery> getCheckinQueriesConditon(int pages, int pageSize, CheckinQuery c);

	/**
	 * ��ȡ��ס��Ϣ����ҳ��
	 * @return
	 */
	public int getPageSizeC(CheckinQuery c);
	
	/**
	 * ��ͨ����
	 */
	public boolean netOn(String checkinid);
	
	
	/**
	 * ������翪ͨ��¼
	 * @return
	 */
	public boolean addNet(CheckinQuery checkinQuery);
	
	/**
	 * ��ȡδ��ͨ������
	 * @return
	 */
	public int getNotOnNetworks();
}
