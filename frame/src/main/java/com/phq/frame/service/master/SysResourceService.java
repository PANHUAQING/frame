package com.phq.frame.service.master;

import java.util.List;
import java.util.Map;

import com.phq.frame.domain.master.SysResource;

public interface SysResourceService {
    //获取当前用户菜单导航数据
	public  List<SysResource>   getSysResourceNavData(Map map);
}
