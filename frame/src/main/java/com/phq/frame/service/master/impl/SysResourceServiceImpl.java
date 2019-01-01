package com.phq.frame.service.master.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.SysResource;
import com.phq.frame.mapper.master.SysResourceMapper;
import com.phq.frame.service.master.SysResourceService;

/**
 * 
 * @ClassName: SysResourceServiceImpl
 * @Description: 资源业务操作类
 * @author panhuaqing
 * @date 2018年12月31日 下午3:40:06
 *
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {

	@Autowired
	private SysResourceMapper sysResourceMapper;

	@Override
	public List<SysResource> getSysResourceNavData(Map map) {
		// 本系统只做两级菜单
		// 获取第一级菜单
		map.put("resPid", "0");
		List<SysResource> listResource = sysResourceMapper.selectResourseListByUserId(map);

		// 获取第二级菜单
		
		// jdk 1.8 后遍历集合方式
		listResource.forEach(item -> {
			map.put("resPid", item.getResId());
			List<SysResource> nextListResource = sysResourceMapper.selectResourseListByUserId(map);
			item.setNextListResource(nextListResource);
		});
		return listResource;
	}
}
