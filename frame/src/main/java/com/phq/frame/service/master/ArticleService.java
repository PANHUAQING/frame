package com.phq.frame.service.master;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.TbArticle;

@Service("articleService")
public interface ArticleService {

	//查询文章列表
	public  List<TbArticle> selectArticleList(TbArticle tbArticle)  throws Exception;
	
	//通过文章主键获取文章信息
	public TbArticle selectTbArticleById(String articleId)  throws Exception;
	//获取第一条
	public TbArticle selectTbArticleFirst() throws Exception;
	//更新阅读量
	public void updateReadNum(TbArticle tbArticle) throws Exception;
	//更新喜欢度
	public void doChangeReadLike(TbArticle tbArticle) throws Exception;
}
