package com.phq.frame.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
* @ClassName: UUIDUtils
* @Description: 
*    uuid
* @author panhuaqing
* @date 2018年10月12日
*
 */
public class UUIDUtils {
	public static String getUUID(){ 
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 32); 
		//去掉“-”符号 
		return uuid;
		}
	
	public static String getUUIDCode(){
		String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
		String prefix = "MS-";
		return prefix+dateStr+"-"+uuid;
	}
	
	public static String getPhoneCode(int len){
		
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		
		String code = "";
		
		for (int i=0; i<len; i++) {
			int j = (int)(Math.random()*10);
			code += arr[j];
		}
		return code;
	}
	
/*	public static void main(String[] args) {
		String string = UUIDUtils.getUUIDCode();
		System.out.println(string);
	}*/

}
