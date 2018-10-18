package com.phq.frame.controller.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phq.frame.domain.master.TbArticle;
import com.phq.frame.service.master.ArticleService;
/**
 * 
* @ClassName: BlogController
* @Description: 
*     个人博客 页面跳转控制类
* @author panhuaqing
* @date 2018年10月11日
*
 */
@RestController
@RequestMapping(value ="/blog/blogController")
public class BlogController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	private ArticleService articleService;
	//关于自己
	@RequestMapping(value = "/about")
	public ModelAndView about(ModelAndView mv) {
	    mv.setViewName("blog/about");
	    return mv;
	}
	//慢生活
	@RequestMapping(value = "/life")
	public ModelAndView life(ModelAndView mv) {
		mv.setViewName("blog/life");
		return mv;
	}
	
	//时间轴
	@RequestMapping(value = "/timeLine")
	public ModelAndView timeLine(ModelAndView mv) {
		mv.setViewName("blog/time");
		return mv;
	}
	
	//留言模块
	@RequestMapping(value = "/gbook")
	public ModelAndView gbook(ModelAndView mv) {
		mv.setViewName("blog/gbook");
		return mv;
	}
	
	//内容模块
	@RequestMapping(value = "/info")
	public ModelAndView info(ModelAndView mv) throws Exception {
		TbArticle tbArticle = articleService.selectTbArticleFirst();
		if(tbArticle==null) {
			tbArticle = new TbArticle(); 
		}
		mv.addObject("article", tbArticle);
		mv.setViewName("blog/info");
		return mv;
	}

}
