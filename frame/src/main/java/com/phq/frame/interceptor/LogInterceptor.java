package com.phq.frame.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.phq.frame.service.master.LogService;
import com.phq.frame.util.IpUtil;
/**
 * 
* @ClassName: LogInterceptor
* @Description: 
*    日志拦截器 获取用户的操作日志
* @author panhuaqing
* @date 2018年10月11日
*
 */
public class LogInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
	private LogService logService;
	
	public  LogInterceptor(LogService logService) {
		this.logService = logService;
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//日志拦截器 实现对页面请求的控制
		String sessionId = request.getRequestedSessionId(); //请求sessionid
		String uri =  request.getRequestURI();//url
		Enumeration<String> attributeName = request.getAttributeNames();
		StringBuffer sb =  request.getRequestURL();
		System.out.println(sessionId+"--------"+uri+"s "+ sb.toString());
		String clientIp =  IpUtil.getUserIp(request);
		System.out.println(clientIp+"-------------");
		logger.info(clientIp+"----");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
    
}
