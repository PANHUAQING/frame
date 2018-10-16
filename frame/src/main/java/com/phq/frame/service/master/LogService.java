package com.phq.frame.service.master;

import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.TbLog;

@Service("logService")
public interface LogService {

	//日志保存
	public void saveLogData(TbLog log) throws Exception;
}
