package com.phq.frame.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
* @ClassName: BaseController
* @Description: 
*    基础控制类 
* @author panhuaqing
* @date 2018年10月11日
*
 */
@RestController
public class BaseController {
	
	//博客首页跳转
	@RequestMapping(value = "/")
	public ModelAndView indexShow(ModelAndView mv) {
	    mv.setViewName("blog/index");
	    return mv;
	}
		
	//博客首页跳转
	@RequestMapping(value = "/index")
	public ModelAndView index(ModelAndView mv) {
	    mv.setViewName("blog/index");
	    return mv;
	}
	
	//博客后台登录
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView mv) {
	    mv.setViewName("backstage/login");
	    return mv;
	}
	
}
