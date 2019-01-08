package com.phq.frame.service.master.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.phq.frame.common.constant.Contants;
import com.phq.frame.common.domain.ResultModel;
import com.phq.frame.domain.master.SysRole;
import com.phq.frame.domain.master.SysUser;
import com.phq.frame.mapper.master.SysUserMapper;
import com.phq.frame.service.master.UserService;
/**
 * 
* @ClassName: UserServiceImpl
* @Description: 
*    用户管理操作类
* @author panhuaqing
* @date 2019年1月1日 下午8:01:09
*
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser findByLoginName(String userName) {
		SysUser  sysUser = sysUserMapper.findUserByUserName(userName);
		List<SysRole> roles = sysUserMapper.findRoleByUserName(userName);
		sysUser.setRoles(roles);
		return sysUser;
	}
	
	public ResultModel getUserList(Map map) throws Exception {
		 List<SysUser> list = sysUserMapper.selectUserList(map);
		 //遍历用户 获取用户角色信息
		 list.forEach(item ->{
			 if(!StringUtil.isEmpty(item.getLoginname())) {
				 List<SysRole> roles = sysUserMapper.findRoleByUserName(item.getLoginname());
				 StringBuffer roleStr = new StringBuffer();
				 roles.forEach(role->{
					 roleStr.append(role.getRoleName()).append(",");
				 });
				 item.setRoleName(roleStr.toString().substring(0, roleStr.toString().length()-1));
			 }
		 });
		 int  count =  sysUserMapper.selectUserCount(map);
		 return new ResultModel(Contants.WEB_SUCCESS_CODE,list,count);
	}

}
