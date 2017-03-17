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
 * create date  2017年3月1日  下午1:01:47
 */
public interface IRoomDAO {
	
	/**
	 * 添加客房
	 * @param r 客房
	 * @return boolean 是否成功添加
	 */
	public boolean addRoom(Room r);
	
	/**
	 * 更新客房
	 * @param r 客房
	 * @return boolean 是否成功更新
	 */
	public boolean updateRoom(Room r);
	
	/**
	 * 客房状态更新
	 */
	public boolean updateRoomStatus(Room r);
	
	/**
	 * 批量删除客房
	 * @param list 客房列表
	 * @return boolean 是否成功删除
	 */
	public boolean deleteRoomByList(List<Room> list);
	
	/**
	 * 删除客房
	 * @param r 需要删除的客房
	 * @return 
	 */
	public boolean deleteRoom(Room r);
	

	
	/**
	 * 获取所有客房信息
	 * @return list 所有客房列表
	 */
	public List<RoomQuery> getRoomQueries();
	
	
	/**
	 * 获取所有空客房信息
	 * @return
	 */
	public List<RoomQuery> getRoomEmptyQueries();
	
	
	/**
	 * 分页获取客房信息
	 * @param pages
	 * @param pageSize
	 * @return
	 */
	public List<RoomQuery> getRoomQueries(int pages, int pageSize);
	
	/**
	 * 根据条件分页获取客房信息
	 * @param pages
	 * @param pageSize
	 * @return
	 */
	public List<RoomQuery> getRoomQueriesConditon(int pages, int pageSize, RoomQuery r);
	
	/**
	 * 通过条件查询客房信息
	 * @param r 查询条件
	 * @return 符合条件的客房
	 */
	public List<RoomQuery> getRoomQueries(RoomQuery r);
	
	/**
	 * 获取所有类别信息
	 * @return 类别信息列表
	 */
	public List<RoomType> getRoomTypes();
	
	/**
	 * 通过房间号获取roomquery
	 * @return roomquery 对象
	 */
	public RoomQuery getRoomQueryById(String roomid);
	
	
	/**
	 * 查询所有客房时的总页数
	 * @return 总页数
	 */
	public int getPageSize();
	
	
	/**
	 * 条件查询客房时的总页数
	 * @return 总页数
	 */
	public int getPageSizeCondition(RoomQuery r);
	
	
	/**
	 * 根据条件分页获取入住信息
	 * @param pages
	 * @param pageSize
	 * @return
	 */
	public List<CheckinQuery> getCheckinQueriesConditon(int pages, int pageSize, CheckinQuery c);

	/**
	 * 获取入住信息的总页数
	 * @return
	 */
	public int getPageSizeC(CheckinQuery c);
	
	/**
	 * 开通网络
	 */
	public boolean netOn(String checkinid);
	
	
	/**
	 * 添加网络开通记录
	 * @return
	 */
	public boolean addNet(CheckinQuery checkinQuery);
	
	/**
	 * 获取未开通网络数
	 * @return
	 */
	public int getNotOnNetworks();
}
