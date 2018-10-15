package com.phq.frame.controller.backstage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
* @ClassName: UserController
* @Description: 
*    用户控制类
* @author panhuaqing
* @date 2018年10月11日
*
 */
@RestController
@RequestMapping(value ="/backstage/userController")
public class UserController {

	@RequestMapping(value ="/getUserList")
	public String getUserList() {
		
		return "测试拦截";
	}
}
