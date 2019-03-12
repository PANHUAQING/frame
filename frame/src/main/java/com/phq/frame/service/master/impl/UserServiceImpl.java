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
import com.phq.frame.common.framework.secrity.BCryptPasswordUtil;
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
				 if(roleStr.toString().length()>0) {
					 item.setRoleName(roleStr.toString().substring(0, roleStr.toString().length()-1)); 
				 }
				 
			 }
		 });
		 int  count =  sysUserMapper.selectUserCount(map);
		 return new ResultModel(Contants.WEB_SUCCESS_CODE,list,count);
	}

	@Override
	public ResultModel deleteUserByIds(String ids) throws Exception {
		ResultModel result = null;
		
		if(StringUtil.isEmpty(ids)) {
			result = new  ResultModel(Contants.WEB_ERROR_CODE, "请选择需要删除的用户！");
			return result;
		}
		sysUserMapper.deleteUserByPrimaryKeyPatch(ids.split(","));
		
		return new  ResultModel(Contants.WEB_SUCCESS_CODE,Contants.WEB_SUCCESS_MSG);
	}
	
	
	@Override
	public ResultModel saveUser(SysUser sysUser) throws Exception {
		ResultModel result = null;
		
		if(StringUtil.isEmpty(sysUser.getLoginname())) {
			result = new  ResultModel(Contants.WEB_ERROR_CODE, "请填写用登录名！");
			return result;
		}
		int userCount =  sysUserMapper.selectCountByUserName(sysUser.getLoginname());
		if(userCount>0) {
			result = new  ResultModel(Contants.WEB_ERROR_CODE, "存在相同登录的用户，请重新填写！");
			return result;
		}
		if(StringUtil.isEmpty(sysUser.getPassword())) {
			result = new  ResultModel(Contants.WEB_ERROR_CODE, "请填写密码！");
			return result;
		}else {
			
			sysUser.setPassword(BCryptPasswordUtil.passwordEncode(sysUser.getPassword()));
		}
		if(StringUtil.isEmpty(sysUser.getName())) {
			result = new  ResultModel(Contants.WEB_ERROR_CODE, "请填写用户名！");
			return result;
		}
		sysUserMapper.saveUser(sysUser);
		
		return new  ResultModel(Contants.WEB_SUCCESS_CODE,Contants.WEB_SUCCESS_MSG);
	}
	
	
	

}
