/**
 * 
 */
package com.hzgg.nec.employeemanage.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.hzgg.nec.employeemanage.po.Employee;
import com.hzgg.nec.employeemanage.po.Emps;
import com.hzgg.nec.employeemanage.po.Userinfo;
import com.hzgg.nec.util.MybatisSqlSessionFactory;

/**
 * @author Mr.H
 *
 * create date  2017??3??1??  ????11:05:28
 */
public class EmployeeDAOImpl implements IEmployeeDAO {

	/**
	 * 
	 */
	public EmployeeDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee checkLogin(Userinfo user) {
		// TODO Auto-generated method stub
		Employee emp = null;	
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		Userinfo u = session.selectOne("checklogin",user);
		if (u != null){
			emp = session.selectOne("getEmployeeById",u.getEmployeeid());
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return emp;
	}

	@Override
	public Userinfo selectUserByEmpId(int employeeid) {
		Userinfo user = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		user = session.selectOne("selectUserByEmployeeId",employeeid);
		MybatisSqlSessionFactory.closeSqlSession();
		return user;
	}

	public Employee selectEmployeeById(int employeeid){
		Employee emp = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		emp = session.selectOne("getEmployeeById",employeeid);
		MybatisSqlSessionFactory.closeSqlSession();
		return emp;
	}

	@Override
	public Boolean isAvailableUsername(String username) {
		boolean result = true;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		Integer i = session.selectOne("isAvailableUsername",username);
		if (i != null){
			result = false;
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public Boolean insertUser(Userinfo user) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int i = session.insert("addUser",user);
		if (i != 0){
			result = true;
			session.commit();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}


	@Override
	public Emps selectUserInfo(int employeeid) {
		// TODO Auto-generated method stub
		Emps emp = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		emp = session.selectOne("selectEmpUserinfoByEmpId",employeeid);
		MybatisSqlSessionFactory.closeSqlSession();
		return emp;
	}

	@Override
	public List<Emps> selectEmployees(int pages,int pageSize) {
		// TODO Auto-generated method stub
		List<Emps> list = new ArrayList<>();
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		list = session.selectList("selectEmployees",null, new RowBounds((pages-1)*pageSize, pageSize));
		MybatisSqlSessionFactory.closeSqlSession();
		return list;
	}

	@Override
	public Integer getGenerateEmpId() {
		// TODO Auto-generated method stub
		Integer result = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		result = session.selectOne("getGenerateEmpId");
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public int getTotalPages(int pageSize) {
		// TODO Auto-generated method stub
		int totalPages = 1;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		Integer totalRecords = sqlSession.selectOne("getTotalRecords");
		MybatisSqlSessionFactory.closeSqlSession();
		if (totalRecords <= pageSize){
			return totalPages;
		}
		totalPages = (totalRecords % pageSize == 0 ? 0 : 1) + totalRecords / pageSize;
		return totalPages;
	}

	@Override
	public boolean deleteEmps(int employeeid) {
		// TODO Auto-generated method stub
		boolean result = true;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		int i = sqlSession.delete("deleteEmp",employeeid);
		if (i != 0){
			result = true;
			sqlSession.commit();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public boolean updateEmps(Emps emp) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		int i = sqlSession.update("updateUser",emp);
		int j = sqlSession.update("updateEmployee",emp);
		if (i != 0 && j != 0){
			result = true;
			sqlSession.commit();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		boolean result = false;
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
		int i = sqlSession.insert("addEmployee",emp);
		if (i != 0){
			result = true;
			sqlSession.commit();
		}
		MybatisSqlSessionFactory.closeSqlSession();
		return result;
	}
	
	
}
