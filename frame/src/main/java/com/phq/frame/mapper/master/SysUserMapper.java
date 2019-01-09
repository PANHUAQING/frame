package com.phq.frame.mapper.master;

import com.phq.frame.domain.master.SysRole;
import com.phq.frame.domain.master.SysUser;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    
	//获取用户集合列表
	public List<SysUser>  selectUserList(Map map) throws Exception;
	//获取用户总记录数
	public int selectUserCount(Map map) throws Exception;
	
	//批量删除用户
	public int deleteUserByPrimaryKeyPatch(@Param("ids") String ids) throws Exception;
	
	//通过用户名获取用户对象
	public SysUser  findUserByUserName(String userName); 
	//通过通过用户名获取用户角色
	public List<SysRole> findRoleByUserName(String userName) ;
}