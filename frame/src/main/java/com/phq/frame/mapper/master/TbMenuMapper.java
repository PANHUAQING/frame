package com.phq.frame.mapper.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.phq.frame.domain.master.TbMenu;
import com.phq.frame.domain.master.vo.TbMenuVo;

@Mapper
public interface TbMenuMapper {
   //查询菜单集合列表
	public List<TbMenuVo> selectMenuList(TbMenuVo tbMenuVo);
}