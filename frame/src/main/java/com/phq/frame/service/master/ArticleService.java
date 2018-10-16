package com.phq.frame.service.master;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.TbArticle;

@Service("articleService")
public interface ArticleService {

	public  List<TbArticle> selectArticleList(TbArticle tbArticle);
}
