package com.phq.frame.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.phq.frame.common.framework.redis.RedisUtil;
import com.phq.frame.interceptor.LogInterceptor;
import com.phq.frame.interceptor.MenuInterceptor;
import com.phq.frame.interceptor.SessionInterceptor;
import com.phq.frame.service.master.LogService;
import com.phq.frame.service.master.MenuSevice;
/**
 * 
* @ClassName: WebAppAdapter
* @Description: 
*     添加各类 拦截器
* @author panhuaqing
* @date 2018年10月11日
*
 */
@Configuration
@SuppressWarnings("deprecation")
public class WebAppAdapter  extends WebMvcConfigurerAdapter{
	//注入资源service
	@Autowired(required=true)
    private MenuSevice menuSevice;
	
	@Autowired(required=true)
	private RedisUtil redisUtil;
	
	@Autowired(required=true)
	private LogService logService;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		//1.添加拦截器对菜单进行拦截
        registry.addInterceptor(new MenuInterceptor(menuSevice,redisUtil))
        //针对以下的请求头进行拦截
        .addPathPatterns("/blog/**")
        .addPathPatterns("/index/**")
        .addPathPatterns("/");
        
        //2.添加session登录判断拦截器
       /* registry.addInterceptor(new SessionInterceptor())
         //不拦截登录
        .excludePathPatterns("/login/**")
        //拦截后台页面 不登陆不让操作
        .addPathPatterns("/backstage/**")
        //不拦截静态文件
        .excludePathPatterns("/backstage/images/**")
        .excludePathPatterns("/blog/**");
        */
        
        //3.添加日志拦截器 记录操作日志
        registry.addInterceptor(new LogInterceptor(logService))
        //拦截请求页面进行记录
        .addPathPatterns("/backstage/**")
        .addPathPatterns("/login/**")
        .addPathPatterns("/blog/blogController/**")
        .addPathPatterns("/index/**")
        //排除不进行拦截的
        .excludePathPatterns("/blog/**/images/**")
        .excludePathPatterns("/blog/**/js/**")
        .excludePathPatterns("/backstage/images/**")
        .excludePathPatterns("/backstage/js/**");

	}

}
