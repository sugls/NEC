package com.hzgg.nec.employeemanage.dao;

import com.hzgg.nec.employeemanage.po.Employee;
import com.hzgg.nec.employeemanage.po.Userinfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lsc on 2017/3/5.
 */
public class EmployeeDAOImplTest {
    @Test
    public void isAvailableUsername() throws Exception {
        System.out.println(employeeDAO.isAvailableUsername("sug"));

        System.out.println(employeeDAO.isAvailableUsername("lily"));
    }

    private IEmployeeDAO employeeDAO;

    @Before
    public void setUp() throws Exception {
        employeeDAO = new EmployeeDAOImpl();

    }

    @After
    public void tearDown() throws Exception {
        employeeDAO = null;

    }

    @Test
    public void checkLogin() throws Exception {

    }

    @Test
    public void selectUserByEmpId() throws Exception {
        Userinfo u = employeeDAO.selectUserByEmpId(123214);
        System.out.println(u);
    }

    @Test
    public void selectEmployeeById() throws Exception {
        Employee e = employeeDAO.selectEmployeeById(1000);
        System.out.println(e);
    }


}