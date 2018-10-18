package com.phq.frame.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private ArticleService articleService;
	//博客首页跳转
	@RequestMapping(value = "/")
	public ModelAndView indexShow(ModelAndView mv) throws Exception {
		//获取文章
	    List<TbArticle>  articleList  = articleService.selectArticleList(new TbArticle());
	    mv.setViewName("blog/index");
	    mv.addObject("articleList", articleList);
	    return mv;
	}
		
	//博客首页跳转
	@RequestMapping(value = "/index")
	public ModelAndView index(ModelAndView mv) throws Exception {
	    mv.setViewName("blog/index");
	    List<TbArticle>  articleList  = articleService.selectArticleList(new TbArticle());
	    mv.addObject("articleList", articleList);
	    return mv;
	}
	
	//博客后台登录
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView mv) {
	    mv.setViewName("backstage/login");
	    return mv;
	}
	
}
