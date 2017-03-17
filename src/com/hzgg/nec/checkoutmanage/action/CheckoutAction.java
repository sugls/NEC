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
 * 2017��3��6������9:28:38
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
	 * �������������Ϣ
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
	 * �ر����粢��������
	 * @return
	 * @throws Exception
	 */
	public String closeNetWork() throws Exception{
		ICheckoutDAO icd = (ICheckoutDAO) request.getAttribute("ICheckoutDAO");
		request.setAttribute("networkcostmsg", icd.getNetCost(network));
		return "success";
	}
	
	/**
	 * ��������������ס��Ϣ
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
	 * ���ݴ������ס��Ϣ��ʾ�˵���Ϣ
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
	 * ������excel�ļ�
	 * @return
	 * @throws Exception
	 */
	public String exportExcel() throws Exception{
		ICheckoutDAO icd = (ICheckoutDAO) request.getAttribute("ICheckoutDAO");
		CheckinMessage ck = icd.checkoutMessageById(checkinid);
		Map<String,Object> map = new HashMap<String,Object>();
		WritableWorkbook wwb= null;  
		try{    
            File file=new File("D:/����.xls");  
            if(!file.exists()){  
                //file.createNewFile();  
                //�ж��Ƿ����xls�ļ�����û�����½���������һ��Ĭ�ϱ�sheet1����Ҫ�������creatNewFile()  
                wwb=Workbook.createWorkbook(new FileOutputStream(file));  
                wwb.createSheet("sheet", 0);  
                wwb.write();  
                wwb.close();  
            }  
              
            //Ϊ��ʵ�ָ���д�룬��������ԭ�������ϵ��ӣ���Ҫ�õ����·���ʵ����WritableWorkbook  
            wwb=Workbook.createWorkbook(file, Workbook.getWorkbook(file));             
              
            if(wwb==null){
            	return "error";  
            }
            
            //��ȡ���������
            Class c = ck.getClass();
            //��ȡ��Ϊ��data" �ı�  
            WritableSheet sheet=wwb.getSheet("data");  
            //���ǵ�һ�����У����Ϊnull����Ҫ��ʼ�������ڱ���һ�����ú�����data�ı���  
            if(sheet==null){  
                //���������ڣ����½�����Ϊ��data���ı���������0������������ʾ��һ��  
                sheet=wwb.createSheet("data", 0);  
                for(int i = 0; i < c.getDeclaredFields().length; i++){
                	//����Label��һ��Label�൱��һ����Ԫ�񣬲���1���������� ����2���������� ����3�����ݡ�
                	String name = c.getDeclaredFields()[i].getName();
                	Label lName = new Label(i, 0, name);
                	sheet.addCell(lName);
                }
            }  
  
            //��ȡ��ǰ�ı�����������Ȼ������һ�н���д���ݣ����⸲��  
            int currentRow=sheet.getRows();
            
            //д�����ݶ���
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

            //����write������������д��workbook��  
            wwb.write();
            map.put("message", "���˳ɹ�");
            JSONObject json = JSONObject.fromObject(map);//��map����ת����json��������
            ajaxField = json.toString();
            return "success";
        }catch(Exception e){  
            e.printStackTrace();
            map.put("message","����ʧ��");
            JSONObject json = JSONObject.fromObject(map);//��map����ת����json��������
            ajaxField = json.toString();
            return "error";
        }finally {  
            try {      	
                //�����Ҫ��workbook�ص��������˷���Դ  
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
