package com.phq.frame.service.master;

import java.util.Map;

import com.phq.frame.common.domain.ResultModel;
import com.phq.frame.domain.master.SysUser;

public interface UserService {

	 SysUser findByLoginName(String userName);
	 
	 public ResultModel getUserList(Map map) throws Exception;
}
