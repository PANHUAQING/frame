package com.phq.frame.service.master;

import com.phq.frame.domain.master.SysUser;

public interface UserService {

	 SysUser findByLoginName(String userName);
}
