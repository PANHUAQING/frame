package com.phq.frame.service.master.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phq.frame.domain.master.TbArticle;
import com.phq.frame.mapper.master.TbArticleMapper;
import com.phq.frame.service.master.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
 
	@Autowired
	private TbArticleMapper tbArticleMapper;
	
	//选择文章列表
	public  List<TbArticle> selectArticleList(TbArticle tbArticle) throws Exception{
		return tbArticleMapper.selectArticleList(tbArticle);
	}

	@Override
	public TbArticle selectTbArticleById(String articleId) throws Exception {
		
		return tbArticleMapper.selectByPrimaryKey(articleId);
	}
	
	@Override
	public TbArticle selectTbArticleFirst() throws Exception {
		
		return tbArticleMapper.selectArticleFirst();
	}
	
	
	public void updateReadNum(TbArticle tbArticle) throws Exception{
		tbArticleMapper.updateReadNumByPrimaryKey(tbArticle);
	}

	@Override
	public void doChangeReadLike(TbArticle tbArticle) throws Exception {
		tbArticleMapper.updateReadLikeByPrimaryKey(tbArticle);
	}
	
}
