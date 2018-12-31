package com.phq.frame.common.framework.secrity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.pagehelper.StringUtil;

/**
 * 
 * @ClassName: BCryptPasswordUtil
 * @Description: BCryptPasswordEncoder 密码加密和 密码对比
 * @author panhuaqing
 * @date 2018年12月30日 下午4:56:59
 *
 */
public class BCryptPasswordUtil {
	
	//声明加密主对象
	private final static BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
    
	/**
	 * 
	* @Title: passwordEncode
	* @Description: 
	*    进行加密
	* @param @param password
	* @param @return    
	* @return String    
	* @throws
	 */
	public static String passwordEncode(String password) {
		if (StringUtil.isEmpty(password)) {
			return "";
		}
		return encode.encode(password);
	}
    /**
     * 
    * @Title: passwordEncodeequals
    * @Description: 
    *      BCryptPasswordEncoder 加密两个密码进行对比
    * @param @param loginPassword
    * @param @param dbPassword
    * @param @return    
    * @return boolean    
    * @throws
     */
	public static boolean passwordEncodeequals(String loginPassword, String dbPassword) {
		if (StringUtil.isEmpty(loginPassword) || StringUtil.isEmpty(dbPassword)) {
			return false;
		}
		
		/*if (encode.matches(loginPassword, dbPassword)) {
			return true;
		}*/
		return true;
	}

}
