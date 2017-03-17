/**
 * 
 */
package com.hzgg.nec.roommanage.dao;

import java.util.List;
import java.util.Vector;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.hzgg.nec.roommanage.po.CheckinQuery;
import com.hzgg.nec.roommanage.po.Room;
import com.hzgg.nec.roommanage.po.RoomQuery;
import com.hzgg.nec.roommanage.po.RoomType;
import com.hzgg.nec.util.MybatisSqlSessionFactory;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  下午1:02:01
 */
public class RoomDAOImpl implements IRoomDAO{
	
	private int pagesize = 4;

	/**
	 * 
	 */
	public RoomDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean addRoom(Room r) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		int i = sqlSession.insert("addRoom", r);
		if(i != 0){
			result = true;
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public boolean updateRoom(Room r) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		int i = sqlSession.update("modifyRoom", r);
		if(i != 0){
			result = true;
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	
	@Override
	public boolean deleteRoom(Room r) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		int i = sqlSession.delete("deleteRoom", r);
		if(i != 0){
			result = true;
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	
	
	@Override
	public boolean deleteRoomByList(List<Room> list) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		String[] a = new String[list.size()]; 
		for(int i = 0; i < a.length; i++){
			a[i] = list.get(i).getRoomid();
		}
		int i = sqlSession.delete("deleteRoomByList", a);
		if(i == list.size()){
			result = true;
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}


	@Override
	public List<RoomQuery> getRoomQueries(int pages, int pageSize) {
		// TODO Auto-generated method stub
		List<RoomQuery> rooms = new Vector<RoomQuery>();
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		rooms = sqlSession.selectList("getRoomByIdLocationTypeStatus", null, new RowBounds((pages-1)*pagesize, pagesize));
		MybatisSqlSessionFactory.closeSqlSession();
		return rooms;
	}

	@Override
	public List<RoomQuery> getRoomQueries() {
		// TODO Auto-generated method stub
		List<RoomQuery> rooms = new Vector<RoomQuery>();
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		rooms = sqlSession.selectList("getRoomQueries");
		MybatisSqlSessionFactory.closeSqlSession();
		return rooms;
	}

	@Override
	public List<RoomQuery> getRoomQueries(RoomQuery r) {
		// TODO Auto-generated method stub
		List<RoomQuery> roomQueries = new Vector<>();
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		roomQueries = sqlSession.selectList("getRoomByIdLocationTypeStatus", r);
		MybatisSqlSessionFactory.closeSqlSession();
		return roomQueries;
	}

	@Override
	public List<RoomQuery> getRoomEmptyQueries() {
		// TODO Auto-generated method stub
		List<RoomQuery> roomQueries = new Vector<>();
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		roomQueries = sqlSession.selectList("getRoomEmptyQueries");
		MybatisSqlSessionFactory.closeSqlSession();
		return roomQueries;
	}

	@Override
	public List<RoomType> getRoomTypes() {
		// TODO Auto-generated method stub
		List<RoomType> types = new Vector<>();
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		types = sqlSession.selectList("getRoomTypes");
		MybatisSqlSessionFactory.closeSqlSession();
		return types;
	}

	@Override
	public RoomQuery getRoomQueryById(String roomid) {
		// TODO Auto-generated method stub
		RoomQuery rq = null;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		rq = sqlSession.selectOne("getRoomQueryById", roomid);
		MybatisSqlSessionFactory.closeSqlSession();
		return rq;
	}

	@Override
	public int getPageSize() {
		// TODO Auto-generated method stub
		int result = 0;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		result = sqlSession.selectOne("getPages");
		result = result/pagesize + (result % pagesize == 0 ? 0 : 1); 
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}


	@Override
	public List<RoomQuery> getRoomQueriesConditon(int pages, int pageSize, RoomQuery r) {
		// TODO Auto-generated method stub
		List<RoomQuery> rooms = new Vector<RoomQuery>();
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		rooms = sqlSession.selectList("getRoomByIdLocationTypeStatus", 	r , new RowBounds((pages-1)*pagesize, pagesize));
		MybatisSqlSessionFactory.closeSqlSession();
		return rooms;
	}


	@Override
	public int getPageSizeCondition(RoomQuery r) {
		// TODO Auto-generated method stub
		int result = 0;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		result = sqlSession.selectOne("getPagesCondition", r);
//System.out.println(result);
		result = result/pagesize + (result % pagesize == 0 ? 0 : 1); 
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}


	@Override
	public List<CheckinQuery> getCheckinQueriesConditon(int pages, int pageSize, CheckinQuery c) {
		// TODO Auto-generated method stub
		List<CheckinQuery> checkins = null;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		checkins = sqlSession.selectList("getCheckins", c, new RowBounds((pages-1)*pagesize, pagesize));
		MybatisSqlSessionFactory.closeSqlSession();
		return checkins;
	}


	@Override
	public int getPageSizeC(CheckinQuery c) {
		// TODO Auto-generated method stub
		int result = 0;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		result = sqlSession.selectOne("getPagesC",c);
		result = result/pagesize + (result % pagesize == 0 ? 0 : 1); 
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}


	@Override
	public boolean netOn(String checkinid) {
		boolean result = false;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		int i = sqlSession.update("netOn", checkinid);
		if(i != 0){
			result = true;
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}


	@Override
	public boolean addNet(CheckinQuery checkinQuery) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		int i = sqlSession.insert("addNet", checkinQuery);
		if(i != 0){
			result = true;
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}


	@Override
	public int getNotOnNetworks() {
		// TODO Auto-generated method stub
		int result = 0;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		result = sqlSession.selectOne("getNotOnNetworks");
		return result;
	}


	@Override
	public boolean updateRoomStatus(Room r) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		int i = sqlSession.update("roomEmptyToOrder", r);
		if(i != 0){
			result = true;
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}
	
	
}
