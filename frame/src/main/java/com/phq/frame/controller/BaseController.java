package com.phq.frame.controller;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phq.frame.domain.master.TbArticle;
import com.phq.frame.service.master.ArticleService;
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
	public ModelAndView indexShow(ModelAndView mv) throws Exception {
		//获取文章
		mv.setViewName("backstage/login");
	    return mv;
	}
		
	//博首页跳转
	@RequestMapping(value = "/index")
	public ModelAndView index(ModelAndView mv) throws Exception {
	    mv.setViewName("backstage/index");
	    return mv;
	}
	
	//后台登录
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView mv) {
	    return mv;
	}
	

}
