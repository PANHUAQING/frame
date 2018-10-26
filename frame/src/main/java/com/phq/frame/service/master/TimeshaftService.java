package com.phq.frame.service.master;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.TbTimeshaft;

@Service("timeshaftService")
public interface TimeshaftService {
	//保存时间轴数据
	public void saveTimeShaftData(TbTimeshaft tbTimeshaft) throws Exception;
	//获取时间轴集合
	public List<TbTimeshaft>  getTbTimeshaftList(TbTimeshaft tbTimeshaft) throws Exception ;
	//获取时间轴集合总记录数
	public int  getTbTimeshaftCount(TbTimeshaft tbTimeshaft) throws Exception ;
}
