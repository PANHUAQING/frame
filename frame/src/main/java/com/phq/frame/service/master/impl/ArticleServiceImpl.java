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
	public  List<TbArticle> selectArticleList(TbArticle tbArticle){
		return tbArticleMapper.selectArticleList(tbArticle);
	}
}
