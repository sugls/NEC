/**
 * 
 */
package com.hzgg.nec.employeemanage.dao;

import java.util.List;

import com.hzgg.nec.employeemanage.po.Employee;
import com.hzgg.nec.employeemanage.po.Emps;
import com.hzgg.nec.employeemanage.po.Userinfo;

/**
 * @author Mr.H
 *
 * create date  2017��3��1��  ����11:04:47
 */
public interface IEmployeeDAO {
	/**

	 * @return Employee
	 */
	Employee checkLogin(Userinfo user);

	Userinfo selectUserByEmpId(int employeeid);

	Employee selectEmployeeById(int employeeid);

	Boolean isAvailableUsername(String username);
	
	Boolean insertUser(Userinfo user);
	
	Emps selectUserInfo(int employeeid);
	
	List<Emps> selectEmployees(int pages,int pageSize);
	
	Integer getGenerateEmpId();	
	
	int getTotalPages(int pageSize);
	
	boolean deleteEmps(int employeeid);
	
	boolean updateEmps(Emps emp);
	
	boolean addEmployee(Employee emp);
}
	