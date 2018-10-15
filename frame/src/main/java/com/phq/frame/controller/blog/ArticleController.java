package com.phq.frame.controller.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phq.frame.service.master.ArticleService;
/**
 * 
* @ClassName: ArticleController
* @Description: 
*    文章控制类
* @author panhuaqing
* @date 2018年10月12日
*
 */
@RestController
@RequestMapping(value ="/blog/articleController")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

}
