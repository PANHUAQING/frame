package com.phq.frame.service.master.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phq.frame.mapper.master.TbArticleMapper;
import com.phq.frame.service.master.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
 
	@Autowired
	private TbArticleMapper tbArticleMapper;
	
	
}