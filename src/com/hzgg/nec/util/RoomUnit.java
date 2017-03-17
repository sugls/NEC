/**
 * 
 */
package com.hzgg.nec.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mr.H
 *
 * create date  2017年3月2日  上午9:45:06
 */
public class RoomUnit {
	
	public final static String R1 = "有热水有电视有网";
	public final static String R2 = "有热水无电视有网";
	
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
			location = "此房不存在";
		} else if(!m.matches()){
			location = "客房编号格式有误";
		}else{
			String floor = id.substring(0, 2);
			String detail = id.substring(2);
			location = floor + "层楼" + detail + "号房";
		}
		return location;
	}
}
