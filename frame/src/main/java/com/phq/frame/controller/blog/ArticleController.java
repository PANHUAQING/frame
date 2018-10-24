package com.phq.frame.controller.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phq.frame.common.constant.Contants;
import com.phq.frame.common.domain.ResultModel;
import com.phq.frame.common.properties.PropertiesUtil;
import com.phq.frame.domain.master.TbArticle;
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
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	private ArticleService articleService;
	
	//文章点击跳转到内容模块
	@RequestMapping(value = "/jumpInfo/{articleId}")
	public ModelAndView jumpInfo(ModelAndView mv, @PathVariable(name = "articleId")String  articleId) throws Exception {
		logger.info(articleId+".....");
		//通过文章主键获取文章的详情信息
		TbArticle  tbArticle = articleService.selectTbArticleById(articleId);
		mv.setViewName("blog/info");
		mv.addObject("article", tbArticle);
		return mv;
	} 
    //更改阅读次数
	@RequestMapping(value = "/doChangeReadNum")
	public ResultModel  doChangeReadNum(@RequestParam(name = "articleId")String  articleId) throws Exception {
		TbArticle  tbArticle  = new TbArticle();
		tbArticle.setArticleId(articleId);
		articleService.updateReadNum(tbArticle);
		TbArticle  tbArticleUpdate = articleService.selectTbArticleById(articleId);
		return new ResultModel(Contants.WEB_SUCCESS_CODE,tbArticleUpdate.getArticleReadNum()+"");
	}
	//更改阅喜欢的次数
	@RequestMapping(value = "/doChangeReadLike")
	@ResponseBody
	public ResultModel  doChangeReadLike(@RequestParam(name = "articleId")String  articleId) throws Exception {
		TbArticle  tbArticle  = new TbArticle();
		tbArticle.setArticleId(articleId);
		articleService.doChangeReadLike(tbArticle);
		TbArticle  tbArticleUpdate = articleService.selectTbArticleById(articleId);
	
		return new ResultModel(Contants.WEB_SUCCESS_CODE,tbArticleUpdate.getArticleReadLike()+"");
	}
}
