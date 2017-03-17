/**
 * 
 */
package com.hzgg.nec.ordermanage.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.hzgg.nec.ordermanage.po.Order;
import com.hzgg.nec.roommanage.po.CheckinQuery;
import com.hzgg.nec.roommanage.po.Room;
import com.hzgg.nec.util.MybatisSqlSessionFactory;

/**
 * @author Mr.H
 *
 * create date  2017年3月1日  上午11:18:37
 */
public class OrderDAOImpl implements IOrderDAO {

	private static int pagesize = 4;
	/**
	 * 
	 */
	public OrderDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addOrder(Order o) {
		// TODO Auto-generated method stub
		boolean result=false;
		SqlSession session=MybatisSqlSessionFactory.getSqlSession();
		int i=session.insert("addOrder",o);
		if(i!=0){
			result=true;
			session.commit();
		}else{
			session.rollback();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}




	@Override
	public boolean deleteOrder(Room r) {
		// TODO Auto-generated method stub
		boolean result=true;
		SqlSession session=MybatisSqlSessionFactory.getSqlSession();
		int i=session.delete("deleteOrderByRoomId",r);
		if(i!=0){
			result=true;
			session.commit();
		}else{
			session.rollback();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public int getPagesC(Order o) {
		// TODO Auto-generated method stub
		int result = 0;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		result = sqlSession.selectOne("getPagesOC",o);
		result = result/pagesize + (result % pagesize == 0 ? 0 : 1); 
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public List<Order> getOrdersConditon(int pages, int pagesize, Order o) {
		// TODO Auto-generated method stub
		List<Order> orders = null;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		orders = sqlSession.selectList("getOrders", o, new RowBounds((pages-1)*pagesize, pagesize));
		MybatisSqlSessionFactory.closeSqlSession();
		return orders;
	}

	@Override
	public Order getOrderById(String id) {
		// TODO Auto-generated method stub
		Order order = new Order();
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		order = sqlSession.selectOne("getOrderById", id);
		MybatisSqlSessionFactory.closeSqlSession();
		return order;
	}

	public boolean updateOrder(Order o) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		int i = sqlSession.update("orderModify", o);
		if(i != 0){
			sqlSession.commit();
			result = true;
		}else{
			result = false;
		}
		return result;
	}

	@Override
	public boolean deleteOrder(String orderid) {
		// TODO Auto-generated method stub
		boolean result=true;
		SqlSession session=MybatisSqlSessionFactory.getSqlSession();
		int i=session.delete("deleteOrder",orderid);
		if(i!=0){
			result=true;
			session.commit();
		}else{
			session.rollback();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	
	@Override
	public String getCustomerByIdcard(String id) {
		// TODO Auto-generated method stub
		String name = null;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		name = sqlSession.selectOne("ifhasname", id);
		return name;
	}

	@Override
	public String getCustomerIdByIdcard(String id) {
		// TODO Auto-generated method stub
		String name = null;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		name = sqlSession.selectOne("ifhasid", id);
		return name;
	}

}
