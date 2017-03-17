/**
 * 
 */
package com.hzgg.nec.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mr.H
 *
 * create date  2017��3��2��  ����9:45:06
 */
public class RoomUnit {
	
	public final static String R1 = "����ˮ�е�������";
	public final static String R2 = "����ˮ�޵�������";
	
	/**
	 * 
	 */
	public RoomUnit() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getLocationById(String id){
		String location = null;
		String pattern = "^\\d{4}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(id);
		if(id == null){
			location = "�˷�������";
		} else if(!m.matches()){
			location = "�ͷ���Ÿ�ʽ����";
		}else{
			String floor = id.substring(0, 2);
			String detail = id.substring(2);
			location = floor + "��¥" + detail + "�ŷ�";
		}
		return location;
	}
}
