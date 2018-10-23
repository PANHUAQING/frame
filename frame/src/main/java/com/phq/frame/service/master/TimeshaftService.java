package com.phq.frame.service.master;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.TbTimeshaft;

@Service("timeshaftService")
public interface TimeshaftService {
	
	public void saveTimeShaftData(TbTimeshaft tbTimeshaft) throws Exception;
	
	public List<TbTimeshaft>  getTbTimeshaftList(TbTimeshaft tbTimeshaft) throws Exception ;
	
	public int  getTbTimeshaftCount(TbTimeshaft tbTimeshaft) throws Exception ;
}
