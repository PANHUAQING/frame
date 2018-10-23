package com.phq.frame.exception;
/**
 * 
* @ClassName: UserDefinedException
* @Description: 
*    用户自定义异常
* @author panhuaqing
* @date 2018年8月9日 上午10:06:41
*
 */
public class UserDefinedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String  resultCode; //返回编码
	private String  resultMsg;  //返回信息
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	
}
