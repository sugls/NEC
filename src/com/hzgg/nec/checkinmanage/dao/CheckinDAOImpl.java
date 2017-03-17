/**
 * 
 */
package com.hzgg.nec.checkinmanage.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.hzgg.nec.checkinmanage.po.Checkin;
import com.hzgg.nec.checkinmanage.po.Customer;
import com.hzgg.nec.checkinmanage.po.RoomMessage;
import com.hzgg.nec.util.MybatisSqlSessionFactory;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  上午11:29:53
 */
public class CheckinDAOImpl implements ICheckinDAO {

	/**
	 * 
	 */
	public CheckinDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int i = session.insert("insertcustomer", customer);
		if(i != 0){
			session.commit();
			result = true;
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public List<Customer> showAllCustomers(int pages,int pagesize) {
		// TODO Auto-generated method stub
		List<Customer> list = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		list = session.selectList("showallcustomers",null,new RowBounds((pages-1)*pagesize,pagesize));
		MybatisSqlSessionFactory.closeSqlSession();
		return list;
	}

	@Override
	public Customer selectCustomerById(String customerid) {
		// TODO Auto-generated method stub
		Customer customer = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		customer = session.selectOne("selectcustomerbyid", customerid);
		MybatisSqlSessionFactory.closeSqlSession();
		return customer;
	}

	@Override
	public boolean modifyCustomer(Customer customer) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int i = session.update("modifycustomer", customer);
		if(i != 0){
			session.commit();
			result = true;
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public int getTotalPages(int pagesize) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int customers = session.selectOne("customercount");
		MybatisSqlSessionFactory.closeSqlSession();
		if(customers <= pagesize){
			return 1;
		}
		return customers / pagesize + (customers % pagesize == 0 ? 0 : 1);
	}

	@Override
	public boolean deleteCustomer(String customerid) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int i = session.delete("deletecustomerbyid",customerid);
		if(i != 0){
			session.commit();
			result = true;
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public List<Customer> selectCustomerByCondition(Customer customer,int pages,int pagesize) {
		// TODO Auto-generated method stub
		List<Customer> list = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		list = session.selectList("selectcustomerbycondition", customer,new RowBounds((pages-1)*pagesize,pagesize));
		MybatisSqlSessionFactory.closeSqlSession();
		return list;
	}

	@Override
	public boolean isAvailiableIDcard(String idcard) {
		// TODO Auto-generated method stub
		boolean result = false;
		String regex = "^\\d{15}(\\d{2}[0-9Xx])?$";
		Pattern p = Pattern.compile(regex);
		if(p.matcher(idcard).matches()){
			SqlSession session = MybatisSqlSessionFactory.getSqlSession();
			if(session.selectOne("ifhasidcard", idcard)==null){
				result = true;				
			}
			MybatisSqlSessionFactory.closeSqlSession();
		}
		return result;
	}

	@Override
	public List<RoomMessage> selectRoomByStatusAndType(String roomtype) {
		// TODO Auto-generated method stub
		List<RoomMessage> list = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		list = session.selectList("selectroombystatusandtype", roomtype);
		MybatisSqlSessionFactory.closeSqlSession();
		return list;
	}

	@Override
	public List<Customer> selectCustomerByIscheckin() {
		// TODO Auto-generated method stub
		List<Customer> list = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		list = session.selectList("selectcustomerbyischeckin");
		MybatisSqlSessionFactory.closeSqlSession();
		return list;
	}

	@Override
	public boolean insertCheckin(Checkin checkin) {
		// TODO Auto-generated method stub
		boolean result = false;
		int num = (int) (Math.random()*100);
		String strdate = new SimpleDateFormat("yyMMddHHmmss").format(new java.util.Date());
		String checkinid = null;
		if(num < 10){
			checkinid = strdate + "0" + Integer.toString(num);
		}else{
			checkinid = strdate + Integer.toString(num);
		}
		checkin.setCheckinid(checkinid);
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int i = session.insert("insertcheckin", checkin);
		int j = session.update("modifyroomstatus",checkin);
		int z = session.update("modifycustomerischeckin", checkin);
		System.out.println(i+"" +j+ "" + z);
		if(i != 0 && j != 0 && z != 0){
			session.commit();
			result = true;
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public List<String> selectFloorMessage() {
		// TODO Auto-generated method stub
		List<String> list = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		list = session.selectList("selectfloor");
		MybatisSqlSessionFactory.closeSqlSession();
		return list;
	}

	@Override
	public List<List<RoomMessage>> selectRoomMessageByFloor() {
		// TODO Auto-generated method stub
		List<List<RoomMessage>> list = new ArrayList<List<RoomMessage>>();
		List<String> floors = selectFloorMessage();
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		for(String floor : floors){
			List<RoomMessage> rooms = session.selectList("selectroommessagebyfloor", floor);
			list.add(rooms);
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return list;
	}

}
