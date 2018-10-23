package com.phq.frame.service.master.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.TbTimeshaft;
import com.phq.frame.mapper.master.TbTimeshaftMapper;
import com.phq.frame.service.master.TimeshaftService;
import com.phq.frame.util.UUIDUtils;
/**
 * 
* @ClassName: TimeshaftServiceImpl
* @Description: 
*    时间轴操作业务类
* @author panhuaqing
* @date 2018年10月22日
*
 */
@Service
public class TimeshaftServiceImpl implements TimeshaftService{
    
	@Autowired
	private TbTimeshaftMapper tbTimeshaftMapper;
	
	
	public void saveTimeShaftData(TbTimeshaft tbTimeshaft) throws Exception {
		tbTimeshaft.setTmieId(UUIDUtils.getUUID());
		tbTimeshaftMapper.insertTimeShaftData(tbTimeshaft);
	}
	
	public List<TbTimeshaft>  getTbTimeshaftList(TbTimeshaft tbTimeshaft) throws Exception {
		Integer pageStart = (tbTimeshaft.getPageIndex()-1)*tbTimeshaft.getPageSize();
		tbTimeshaft.setPageIndex(pageStart);
		return tbTimeshaftMapper.selectTimeShaftDataList(tbTimeshaft);
	}


	@Override
	public int getTbTimeshaftCount(TbTimeshaft tbTimeshaft) throws Exception {
		return tbTimeshaftMapper.selectTimeShaftDataCount(tbTimeshaft);
	}
	
}
