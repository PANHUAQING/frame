package com.phq.frame.mapper.master;

import com.phq.frame.domain.master.TbArticle;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TbArticleMapper {
    //查询文章列表
	public List<TbArticle> selectArticleList(TbArticle tbArticle) throws Exception;
	//保存信息
	public void insertArticleData(TbArticle tbArticle) throws Exception;
	//更新阅读次数
	public void updateReadNumByPrimaryKey(TbArticle tbArticle) throws Exception;
	public void updateReadLikeByPrimaryKey(TbArticle tbArticle) throws Exception;
	//根据主键删除
	public void deleteByPrimaryKey(String  articleId) throws Exception;
	
	public TbArticle selectByPrimaryKey(String  articleId) throws Exception;
	
	public TbArticle selectArticleFirst() throws Exception;
	
}