package com.phq.frame.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * @ClassName: AsyncConfig
 * @Description: 多任务执行器配置
 * @author panhuaqing
 * @date 2018年10月24日
 *
 */
@SpringBootConfiguration
@EnableAsync
@PropertySource("classpath:config/executor.properties")
public class AsyncConfig {

	@Value("${executor.corePoolSize}")
	private int corePoolSize;

	@Value("${executor.maxPoolSize}")
	private int maxPoolSize;

	@Value("${executor.queueCapacity}")
	private int queueCapacity;

	@Value("${executor.keepAliveSeconds}")
	private int keepAliveSeconds;

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.setKeepAliveSeconds(keepAliveSeconds);
		executor.initialize();
		return executor;
	}

}
