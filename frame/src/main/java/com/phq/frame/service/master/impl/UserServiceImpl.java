package com.phq.frame.service.master.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.SysRole;
import com.phq.frame.domain.master.SysUser;
import com.phq.frame.service.master.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public SysUser findByLoginName(String userName) {
		SysUser  sysUser = new SysUser();
		sysUser.setLoginName("admin");
		sysUser.setPassword("$2a$10$v6vOJ6YpYZ8RWR6ZmKlRJONUjBkvLe1nx.mRmXe9o6Px2xKjSY/Ry");
		
		Set<SysRole> roles = new HashSet<SysRole>();
		SysRole role = new SysRole();
		role.setRoleType("ROLE_ADMIN");
		roles.add(role);
		sysUser.setRoles(roles);
		return sysUser;
	}

}
