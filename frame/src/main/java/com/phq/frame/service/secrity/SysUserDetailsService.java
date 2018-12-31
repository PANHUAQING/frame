package com.phq.frame.service.secrity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.phq.frame.domain.master.SysRole;
import com.phq.frame.domain.master.SysUser;
import com.phq.frame.service.master.UserService;


public class SysUserDetailsService implements UserDetailsService{

	private static final Logger logger = LoggerFactory.getLogger(SysUserDetailsService.class);

	@Autowired
	private UserService userService;
	/**
	 * 用户登录访问的方法 
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//获取传入的用户名 
		logger.info("当前登录的用户:"+username);
		//1.根据用户从数据库查询用户的信息
		SysUser sysUser = userService.findByLoginName(username);
		//2.判断用户是否存在 不存在不让访问
		if(sysUser==null) {
			 throw new UsernameNotFoundException("not found user");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		 Set<SysRole> roles = sysUser.getRoles();
         //角色为空的情况写
         if (roles.isEmpty()) {
        	 authorities.add(new SimpleGrantedAuthority("ROLE_NOTAUTH"));
         }
         //遍历角色放入 secrity  GrantedAuthority集合
         for (SysRole role : roles) {
        	 authorities.add(new SimpleGrantedAuthority(role.getRoleType()));
         }
		//3.允许的情况下 获取用户的相关权限 对权限进行处理
		
		return new User(sysUser.getUserName(),sysUser.getPassword(), authorities);
	}

}
