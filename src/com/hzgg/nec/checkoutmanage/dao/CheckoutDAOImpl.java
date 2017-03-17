/**
 * 
 */
package com.hzgg.nec.checkoutmanage.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.hzgg.nec.checkinmanage.po.Checkin;
import com.hzgg.nec.checkoutmanage.po.CheckinMessage;
import com.hzgg.nec.checkoutmanage.po.CoNetWork;
import com.hzgg.nec.util.MybatisSqlSessionFactory;

/**
 * @author Mr.H
 *
 *         create date 2017年3月1日 下午1:12:32
 */
public class CheckoutDAOImpl implements ICheckoutDAO {

	/**
	 * 
	 */
	public CheckoutDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CoNetWork> getAllNetwork(CoNetWork conetwork,int pages,int pagesize) {
		// TODO Auto-generated method stub
		List<CoNetWork> list = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		list = session.selectList("selectallnetwork", conetwork,new RowBounds((pages-1)*pagesize,pagesize));
		MybatisSqlSessionFactory.closeSqlSession();
		return list;
	}

	@Override
	public CoNetWork getNetCost(CoNetWork conetwork) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int i = session.update("modifynetwork", conetwork);
		int j = session.update("modifycheckinneton", conetwork);
		if (i != 0 && j != 0) {
			session.commit();
			conetwork = session.selectOne("selectnetworkbyid", conetwork.getNetworkid());
	
			long daybetween = getDaybetween(conetwork.getStrondate(), conetwork.getStroffdate());
			double netmoney = daybetween * 15;

			conetwork.setNetmoney(netmoney);
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return conetwork;
	}
	
	//计算日期差值
	private long getDaybetween(String s1,String s2){
		long daybetween = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(s1 == null || s2 == null){
			return 0;
		}
		java.util.Date d1 = null;
		java.util.Date d2 = null;
		try {
			d1 = sdf.parse(s1);
			d2 = sdf.parse(s2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return 0;
		}
		daybetween = ((d2.getTime() - d1.getTime()) / 86400000) + ((d2.getTime() - d1.getTime()) % 86400000 == 0 ? 0 : 1);
		return daybetween;
	}

	@Override
	public List<CheckinMessage> selectAllCheckinByName(CheckinMessage checkinmessage,int pages,int pagesize) {
		// TODO Auto-generated method stub
		List<CheckinMessage> list = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		list = session.selectList("selectallcheckinbyname", checkinmessage,new RowBounds((pages-1)*pagesize,pagesize));
		MybatisSqlSessionFactory.closeSqlSession();
		MybatisSqlSessionFactory.closeSqlSession();
		return list;
	}

	@Override
	public CheckinMessage checkoutAndCost(CheckinMessage cm) {
		// TODO Auto-generated method stub
		CheckinMessage checkinmessage = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int i = session.update("modifycheckoutdate", cm.getCheckinid());
		int j = session.update("modifycheckoutstatus", cm.getRoomid());
		//System.out.println(cm.getCustomerid());
		int z = session.update("modifycheckoutcustomerstatus", cm.getCustomerid());
		if(i != 0 && j != 0 && z != 0){
			session.commit();
			
			Checkin checkin = session.selectOne("checkoutnetworkon", cm.getCheckinid());
			if("1".equals(checkin.getNeton())){
				int ii = session.update("checkoutclosenetwork", cm.getCheckinid());
				int jj = session.update("checkoutmodifyneton", cm.getCheckinid());
				
				if(ii != 0 && jj != 0){
					session.commit();	
				}
			}
			
			checkinmessage = session.selectOne("selectcheckoutallbyid", cm.getCheckinid());
			
			double hotelprice = checkinmessage.getPrice() * getDaybetween(checkinmessage.getStrcheckindate(),checkinmessage.getStrcheckoutdate());
			double netprice = 15 * getDaybetween(checkinmessage.getStrondate(), checkinmessage.getStroffdate());
			
			checkinmessage.setHotelprice(hotelprice);
			checkinmessage.setNetprice(netprice);
			
		}
		
		MybatisSqlSessionFactory.closeSqlSession();
		return checkinmessage;
	}

	@Override
	public CheckinMessage checkoutMessageById(String checkinid) {
		// TODO Auto-generated method stub
		CheckinMessage cm = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		cm = session.selectOne("selectcheckoutallbyid", checkinid);
		MybatisSqlSessionFactory.closeSqlSession();
		return cm;
	}

	@Override
	public int getCheckinTotalpages(int pagesize) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int checkins = session.selectOne("checkincount");
		MybatisSqlSessionFactory.closeSqlSession();
		if(checkins <= pagesize){
			return 1;
		}
		return checkins / pagesize + (checkins % pagesize == 0 ? 0 : 1);
	}

	@Override
	public int getNetworkTotalpages(int pagesize) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int networks = session.selectOne("networkcount");
		MybatisSqlSessionFactory.closeSqlSession();
		if(networks <= pagesize){
			return 1;
		}
		return networks / pagesize + (networks % pagesize == 0 ? 0 : 1);
	}

}
