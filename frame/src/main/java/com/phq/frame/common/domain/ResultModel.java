package com.phq.frame.common.domain;

import java.io.Serializable;
import java.util.List;
/**
 * 
* @ClassName: ResultModel
* @Description: 
*      结果集返回封装类
* @author panhuaqing
* @date 2018年10月17日
*
 */
public class ResultModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private String result_code; //返回结果编码
	private String result_msg;  //返回结果信息
	private List<?>   reuslt_data;//返回结果集
	private int    result_total; //返回总条数
	
	
	
	public ResultModel() {
		super();
	}

	public ResultModel(String result_code, String result_msg) {
		super();
		this.result_code = result_code;
		this.result_msg = result_msg;
	}
	
	public ResultModel(String result_code, String result_msg, List<?> reuslt_data, int result_total) {
		super();
		this.result_code = result_code;
		this.result_msg = result_msg;
		this.reuslt_data = reuslt_data;
		this.result_total = result_total;
	}
	
	
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getResult_msg() {
		return result_msg;
	}
	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
	}
	public List<?> getReuslt_data() {
		return reuslt_data;
	}
	public void setReuslt_data(List<?> reuslt_data) {
		this.reuslt_data = reuslt_data;
	}
	public int getResult_total() {
		return result_total;
	}
	public void setResult_total(int result_total) {
		this.result_total = result_total;
	}
	
	
}
