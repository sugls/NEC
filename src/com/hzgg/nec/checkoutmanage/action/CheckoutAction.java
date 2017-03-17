/**
 * 
 */
package com.hzgg.nec.checkoutmanage.action;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.hzgg.nec.checkoutmanage.dao.ICheckoutDAO;
import com.hzgg.nec.checkoutmanage.po.CheckinMessage;
import com.hzgg.nec.checkoutmanage.po.CoNetWork;
import com.opensymphony.xwork2.ActionSupport;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.sf.json.JSONObject;



/**
 * @author LJJ
 *
 * 2017年3月6日上午9:28:38
 */
public class CheckoutAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private HttpServletRequest request;
	private HttpSession session;
	private HttpServletResponse response;
	
	private CoNetWork network;
	
	private Integer id;
	private String is;
	
	private CheckinMessage checkinmessage;
	private String checkinid;
	
	private String ajaxField;
	
	private int pagesize = 5;
	private int pages = 1;

	/**
	 * 
	 */
	public CheckoutAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
		session = request.getSession();
	}

	/**
	 * @return the network
	 */
	public CoNetWork getNetwork() {
		return network;
	}

	/**
	 * @param network the network to set
	 */
	public void setNetwork(CoNetWork network) {
		this.network = network;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the is
	 */
	public String getIs() {
		return is;
	}

	/**
	 * @param is the is to set
	 */
	public void setIs(String is) {
		this.is = is;
	}

	/**
	 * @return the checkinmessage
	 */
	public CheckinMessage getCheckinmessage() {
		return checkinmessage;
	}

	/**
	 * @param checkinmessage the checkinmessage to set
	 */
	public void setCheckinmessage(CheckinMessage checkinmessage) {
		this.checkinmessage = checkinmessage;
	}

	/**
	 * @return the checkinid
	 */
	public String getCheckinid() {
		return checkinid;
	}

	/**
	 * @param checkinid the checkinid to set
	 */
	public void setCheckinid(String checkinid) {
		this.checkinid = checkinid;
	}

	/**
	 * @return the ajaxField
	 */
	public String getAjaxField() {
		return ajaxField;
	}

	/**
	 * @param ajaxField the ajaxField to set
	 */
	public void setAjaxField(String ajaxField) {
		this.ajaxField = ajaxField;
	}

	/**
	 * @return the pagesize
	 */
	public int getPagesize() {
		return pagesize;
	}

	/**
	 * @param pagesize the pagesize to set
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	/**
	 * 所有网络管理信息
	 * @return
	 * @throws Exception
	 */
	public String getAllNetWork() throws Exception{
		ICheckoutDAO icd = (ICheckoutDAO) request.getAttribute("ICheckoutDAO");
		Integer totalpages = (Integer) session.getAttribute("networktotalpages");
		
		if(totalpages == null){
			totalpages = icd.getNetworkTotalpages(pagesize);
			session.setAttribute("networktotalpages", totalpages);
		}
		if(pages < 1){
			pages = 1;
		}
		if(pages > totalpages){
			pages = totalpages;
		}	
		
		List<CoNetWork> list = icd.getAllNetwork(network,pages,pagesize);
		request.setAttribute("allnetwork", list);
		return "success";
	}
	
	/**
	 * 关闭网络并结算网费
	 * @return
	 * @throws Exception
	 */
	public String closeNetWork() throws Exception{
		ICheckoutDAO icd = (ICheckoutDAO) request.getAttribute("ICheckoutDAO");
		request.setAttribute("networkcostmsg", icd.getNetCost(network));
		return "success";
	}
	
	/**
	 * 根据条件搜索入住信息
	 * @return
	 */
	public String selectCheckin() throws Exception{
		ICheckoutDAO icd = (ICheckoutDAO) request.getAttribute("ICheckoutDAO");
		Integer totalpages = (Integer) session.getAttribute("checkintotalpages");
		
		if(totalpages == null){
			totalpages = icd.getCheckinTotalpages(pagesize);
			session.setAttribute("checkintotalpages", totalpages);
		}
		if(pages < 1){
			pages = 1;
		}
		if(pages > totalpages){
			pages = totalpages;
		}		
		
		List<CheckinMessage> list = icd.selectAllCheckinByName(checkinmessage,pages,pagesize);
		request.setAttribute("checkinmessages", list);
		return "success";
	}
	
	/**
	 * 根据传入的入住信息显示账单信息
	 * @return
	 * @throws Exception
	 */
	public String showAllCheckinMessage() throws Exception{
		ICheckoutDAO icd = (ICheckoutDAO) request.getAttribute("ICheckoutDAO");
		CheckinMessage cm = icd.checkoutAndCost(checkinmessage);
		request.setAttribute("costcm", cm);
		return "success";
	}
	
	/**
	 * 导出至excel文件
	 * @return
	 * @throws Exception
	 */
	public String exportExcel() throws Exception{
		ICheckoutDAO icd = (ICheckoutDAO) request.getAttribute("ICheckoutDAO");
		CheckinMessage ck = icd.checkoutMessageById(checkinid);
		Map<String,Object> map = new HashMap<String,Object>();
		WritableWorkbook wwb= null;  
		try{    
            File file=new File("D:/结算.xls");  
            if(!file.exists()){  
                //file.createNewFile();  
                //判断是否存在xls文件，若没有则新建，并创建一个默认表单sheet1，不要用上面的creatNewFile()  
                wwb=Workbook.createWorkbook(new FileOutputStream(file));  
                wwb.createSheet("sheet", 0);  
                wwb.write();  
                wwb.close();  
            }  
              
            //为了实现覆盖写入，即可以在原有数据上叠加，需要用到以下方法实例化WritableWorkbook  
            wwb=Workbook.createWorkbook(file, Workbook.getWorkbook(file));             
              
            if(wwb==null){
            	return "error";  
            }
            
            //获取订单类对象
            Class c = ck.getClass();
            //获取名为“data" 的表单  
            WritableSheet sheet=wwb.getSheet("data");  
            //若是第一次运行，则表单为null，需要初始化，即在表格第一行设置好数据data的标题  
            if(sheet==null){  
                //若表单不存在，则新建名字为“data”的表单，参数“0”是索引，表示第一个  
                sheet=wwb.createSheet("data", 0);  
                for(int i = 0; i < c.getDeclaredFields().length; i++){
                	//创建Label，一个Label相当于一个单元格，参数1：列索引； 参数2：行索引； 参数3：内容。
                	String name = c.getDeclaredFields()[i].getName();
                	Label lName = new Label(i, 0, name);
                	sheet.addCell(lName);
                }
            }  
  
            //获取当前的表单已用行数，然后在下一行进行写数据，避免覆盖  
            int currentRow=sheet.getRows();
            
            //写入数据对象
            for(int i = 0; i < c.getDeclaredFields().length; i++){
            	String name = c.getDeclaredFields()[i].getName();
            	name ="get" + name.substring(0, 1).toUpperCase() + name.substring(1);
            	Method m = c.getMethod(name);
//System.out.println(m.invoke(roomQuery));
            	Label ceel = null;
            	if(m.invoke(ck) != null){
            		ceel = new Label(i, currentRow, m.invoke(ck).toString());
            		sheet.addCell(ceel);
            	}
            	
            }

            //调用write函数，将数据写到workbook上  
            wwb.write();
            map.put("message", "结账成功");
            JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
            ajaxField = json.toString();
            return "success";
        }catch(Exception e){  
            e.printStackTrace();
            map.put("message","结账失败");
            JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
            ajaxField = json.toString();
            return "error";
        }finally {  
            try {      	
                //最后需要把workbook关掉，避免浪费资源  
                wwb.close();  
            } catch (WriteException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }
	}
}
