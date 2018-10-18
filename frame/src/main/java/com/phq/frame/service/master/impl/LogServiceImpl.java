package com.phq.frame.service.master.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.TbLog;
import com.phq.frame.mapper.master.TbLogMapper;
import com.phq.frame.service.master.LogService;
/**
 * 
* @ClassName: LogServiceImpl
* @Description: 
*    日志业务操作类
* @author panhuaqing
* @date 2018年10月11日
*
 */
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private TbLogMapper tbLogMapper;
	/**
	 * 
	* @Title: saveLogData
	* @Description: 
	*    保存日志数据
	* @param @param log
	* @param @throws Exception   
	* @return void    
	* @throws
	 */
	public void saveLogData(TbLog log) throws Exception {
		tbLogMapper.insertLogData(log);
	}
	/**
	 * @throws Exception 
	 * 
	* @Title: updateEndTime
	* @Description:  
	*     更新日志请求结束时间
	* @param @param log   
	* @return void    
	* @throws
	 */
	public void updateEndTime(TbLog log) throws Exception {
		tbLogMapper.updateEndTimeByPrimaryKey(log);
	}
}
