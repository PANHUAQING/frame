package com.phq.frame.mapper.master;

import com.phq.frame.domain.master.TbArticle;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TbArticleMapper {
    //查询文章列表
	public List<TbArticle> selectArticleList(TbArticle tbArticle);
}