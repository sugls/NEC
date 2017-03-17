package com.hzgg.nec.employeemanage.action;

import com.hzgg.nec.employeemanage.dao.IEmployeeDAO;
import com.hzgg.nec.employeemanage.po.Employee;
import com.hzgg.nec.employeemanage.po.Emps;
import com.hzgg.nec.employeemanage.po.Userinfo;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by lsc on 2017/3/5.
 */
public class EmployeeAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

    private HttpServletRequest request;
    private HttpServletResponse response;
    private Integer employeeid;
    private String username;
    private String result;
    private HttpSession session;
    private int pages = 1;
	private int pageSize = 5;
	
	private Emps emp;
	private Employee employee;

    public String checkUser() throws Exception{
        IEmployeeDAO employeeDAO = (IEmployeeDAO) request.getAttribute("IEmployeeDAO");
        Userinfo u = employeeDAO.selectUserByEmpId(employeeid);
        Map<String,String> map = new HashMap<>();
        if (u != null){
            map.put("message","该员工编号已注册！");
        } else {
            Employee e = employeeDAO.selectEmployeeById(employeeid);
            if (e == null){
                map.put("message","该员工编号不存在！");
            } else {
                map.put("message","ok");
                map.put("postname",e.getPostname());
            }
        }
        JSONObject jsonData = JSONObject.fromObject(map);
        result = jsonData.toString();
        System.out.println(result);
        return "success";
    }

    public String checkUsername() throws Exception{
        IEmployeeDAO employeeDAO = (IEmployeeDAO) request.getAttribute("IEmployeeDAO");
        Map<String,String> map = new HashMap<>();
        if (employeeDAO.isAvailableUsername(username)){
            map.put("message","ok");
        } else {
            map.put("message","该用户名已被注册！");
        }
        JSONObject jsonData = JSONObject.fromObject(map);
        result = jsonData.toString();
        return "success";
    }
    
    public String showUser() throws Exception{
        IEmployeeDAO employeeDAO = (IEmployeeDAO) request.getAttribute("IEmployeeDAO");
        Integer totalPages = (Integer) session.getAttribute("totalpages");
        if (totalPages == null){
			totalPages = employeeDAO.getTotalPages(pageSize);
			session.setAttribute("totalpages",totalPages);
		}
		if (pages < 1){
			pages = 1;
		}
		if (pages > totalPages){
			pages = totalPages;
		}
        List<Emps> list = employeeDAO.selectEmployees(pages,pageSize);
		request.setAttribute("emplist", list);
        return "success";
    }
    
    /**
     * 璺宠浆鑷充慨鏀逛釜浜轰俊鎭〉闈�
     * @return
     * @throws Exception
     */
    public String updateUser() throws Exception{
    	IEmployeeDAO employeeDAO = (IEmployeeDAO) request.getAttribute("IEmployeeDAO"); 
        Emps employee = employeeDAO.selectUserInfo(employeeid);
		request.setAttribute("employee", employee);
    	return "success";
    }
    
    public String getGenerateEmpId() throws Exception{
    	IEmployeeDAO employeeDAO = (IEmployeeDAO) request.getAttribute("IEmployeeDAO");
    	Integer id = employeeDAO.getGenerateEmpId();
		PrintWriter out = response.getWriter();
		out.println(id);
		out.close();
    	return null;
    }
    
    /**
     * 淇敼鐢ㄦ埛鍜屽憳宸ヤ俊鎭�
     * @return
     * @throws Exception
     */
    public String updateEmps() throws Exception{
    	IEmployeeDAO employeeDAO = (IEmployeeDAO) request.getAttribute("IEmployeeDAO");

    	Map<String,String> map = new HashMap<>();
        if (employeeDAO.updateEmps(emp)){
            map.put("message","修改成功！");
        } else {
            map.put("message","修改失败！");
        }
        JSONObject jsonData = JSONObject.fromObject(map);
        result = jsonData.toString();
      
        return "success";
    }
    
    
    public String deleteEmps() throws Exception{
    	IEmployeeDAO employeeDAO = (IEmployeeDAO) request.getAttribute("IEmployeeDAO");
    	Map<String,String> map = new HashMap<>();
        if (employeeDAO.deleteEmps(employeeid)){
        	int totalpages = employeeDAO.getTotalPages(pageSize);
        	session.setAttribute("totalpages", totalpages);
        	map.put("pages", String.valueOf(pages));
        	map.put("totalpages", String.valueOf(totalpages));
            map.put("message","删除成功！");
        } else {
            map.put("message","删除失败！");
        }
        JSONObject jsonData = JSONObject.fromObject(map);
        result = jsonData.toString();    	
    	return "success";
    	
    }
    
    public String addEmployee() throws Exception{
    	IEmployeeDAO employeeDAO = (IEmployeeDAO) request.getAttribute("IEmployeeDAO");
    	boolean result = employeeDAO.addEmployee(employee);
    	if (result){
    		request.setAttribute("message", "添加成功！");
    	} else {
    		request.setAttribute("message", "添加失败！");
    	}
    	return "success";
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        response = httpServletResponse;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
        session = request.getSession();
    }

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Emps getEmp() {
		return emp;
	}

	public void setEmp(Emps emp) {
		this.emp = emp;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
    
}
