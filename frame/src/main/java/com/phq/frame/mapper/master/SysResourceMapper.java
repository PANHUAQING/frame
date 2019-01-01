package com.phq.frame.mapper.master;

import com.phq.frame.domain.master.SysResource;

import java.util.List;
import java.util.Map;

public interface SysResourceMapper {

	// 保存资源
	public void saveResource(Map map);

	// 更新资源
	public void updateResourceByPrimaryKey(Map map);

	// 删除资源
	public void deleteByPrimaryKey(String resId);

	// 获取资源
	public SysResource selectByPrimaryKey(String resId);

	// 获取当前用户资源数据通
	public List<SysResource> selectResourseListByUserId(Map map);

	// 获取资源数据
	public List<SysResource> selectResourseListData(Map map);

	// 获取当前用户资源总记录数
	public int selectResourseListTotalByUserId(Map map);

	// 获取资源记录数
	public int selectResourseListTotal(Map map);
}