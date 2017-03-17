/**
 * 
 */
package com.nec.roommanage.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hzgg.nec.roommanage.dao.IRoomDAO;
import com.hzgg.nec.roommanage.dao.RoomDAOImpl;
import com.hzgg.nec.roommanage.po.Room;
import com.hzgg.nec.roommanage.po.RoomQuery;
import com.hzgg.nec.roommanage.po.RoomType;
import com.hzgg.nec.util.RoomUnit;

/**
 * @author Mr.H
 *
 * create date  2017年3月2日  下午1:19:35
 */
public class RoomDAOImplTest {

	private IRoomDAO ird;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ird = new RoomDAOImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ird = null;
	}

	/**
	 * Test method for {@link com.hzgg.nec.roommanage.dao.RoomDAOImpl#RoomDAOImpl()}.
	 */
	//@Test
	public void testRoomDAOImpl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.hzgg.nec.roommanage.dao.RoomDAOImpl#addRoom(com.hzgg.nec.roommanage.po.Room)}.
	 */
	//@Test
	public void testAddRoom() {
		Room r = new Room();
		r.setRoomid("0402");
		r.setTypeid("3");
		r.setLocations(RoomUnit.getLocationById(r.getRoomid()));
		r.setRemark(RoomUnit.R1);
		r.setStatus("1");
		ird.addRoom(r);
	}

	/**
	 * Test method for {@link com.hzgg.nec.roommanage.dao.RoomDAOImpl#updateRoom(com.hzgg.nec.roommanage.po.Room)}.
	 */
	@Test
	public void testUpdateRoom() {
		Room r = new Room();
		r.setRoomid("0402");
		r.setTypeid("3");
		r.setLocations(RoomUnit.getLocationById(r.getRoomid()));
		r.setRemark(RoomUnit.R2);
		r.setStatus("1");
		ird.updateRoom(r);
	}

	/**
	 * Test method for {@link com.hzgg.nec.roommanage.dao.RoomDAOImpl#deleteRoomByList(com.hzgg.nec.roommanage.po.Room)}.
	 */
	//@Test
	public void testDeleteRoomByList() {
		List<Room> list = new Vector<Room> ();
		Room r1 = new Room();
		r1.setRoomid("0101");
		Room r2 = new Room();
		r2.setRoomid("0202");
		list.add(r1);
		list.add(r2);
		assertEquals(ird.deleteRoomByList(list), true);
	}
	
	//@Test
	public void testDeleteRoom() {
		Room r1 = new Room();
		r1.setRoomid("0201");
		assertEquals(ird.deleteRoom(r1), true);
	}
	
	

	/**
	 * Test method for {@link com.hzgg.nec.roommanage.dao.RoomDAOImpl#getRoomById(java.lang.Integer)}.
	 */
	//@Test
	public void testGetRoomById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.hzgg.nec.roommanage.dao.RoomDAOImpl#getRooms()}.
	 */
	//@Test
	public void testGetRooms() {
		assertEquals(ird.getRoomQueries().get(0).getLocations(), "已预订");
	}
	
	//@Test
	public void testGetRoomQuerys(){
		RoomQuery r = new RoomQuery();
		r.setRoomid("");
		r.setTypename("");
		r.setLocations("1");
		r.setStatus("");
		assertEquals(ird.getRoomQueries(r).get(0).getRoomid(), "0101");
	}
	
	
	//@Test
	public void testGetRoomEmptyQuerys(){
		assertEquals(ird.getRoomEmptyQueries().size(), 0);
	}
	
	//@Test
	public void testGetRoomTypes(){
		List<RoomType> l = ird.getRoomTypes();
		for(RoomType r : l){
			System.out.println(r.getTypename()+r.getTypeid());
		}
	}

}
