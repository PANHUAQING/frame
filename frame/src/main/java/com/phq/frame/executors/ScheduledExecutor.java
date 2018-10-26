package com.phq.frame.executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.phq.frame.domain.master.TbLog;
import com.phq.frame.service.master.LogService;

/**
 * 
 * @ClassName: ScheduledExecutor
 * @Description: 定时任务清理日志信息
 * @author panhuaqing
 * @date 2018年10月24日
 *
 */
@Component
public class ScheduledExecutor {

	@Autowired
	private LogService logService;
	
	//日志处理
	private static final Logger logger = LoggerFactory.getLogger(ScheduledExecutor.class);

	// 清理日志信息 每一周凌晨一点清理一次
	// @Async("taskExecutor")
	@Scheduled(cron = "0 0 1 ? * 1")
	public void scheduled() {
		logger.info("=====>>>>> 清理日志信息 每一周清理一次 定时任务开始 ", System.currentTimeMillis());
		try {
			logService.deleteLogData(new TbLog());
		} catch (Exception e) {
			logger.info("=====>>>>> 清理日志信息 每一周清理一次 定时任务出错 ", System.currentTimeMillis());
			e.printStackTrace();
		}
		logger.info("=====>>>>> 清理日志信息 每一周清理一次 定时任务结束 ", System.currentTimeMillis());
	}

	/*
	 * @Scheduled(fixedRate = 5000) public void scheduled1() {
	 * System.out.println("----------------------111");
	 * logger.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis()); }
	 * 
	 * @Scheduled(fixedDelay = 5000) public void scheduled2() {
	 * logger.info("=====>>>>>fixedDelay{}",System.currentTimeMillis()); }
	 */
}
