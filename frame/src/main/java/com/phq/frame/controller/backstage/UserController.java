package com.phq.frame.controller.backstage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phq.frame.common.domain.PageModel;
import com.phq.frame.common.domain.ResultModel;
import com.phq.frame.domain.master.SysUser;
import com.phq.frame.service.master.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: UserController
 * @Description: 用户控制类
 * @author panhuaqing
 * @date 2018年10月11日
 *
 */
@Api(value = "/backstage/userController", description = "用户操作", tags = { "用户操作接口" })
@RestController
@RequestMapping(value = "/backstage/userController")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "/showUserListPage", notes = "跳转用户管理页面")
	@ApiImplicitParam(name = "mv", value = "视图对象", required = true)
	@RequestMapping("/showUserListPage")
	public ModelAndView showUserListPage(ModelAndView mv) {
		mv.setViewName("/backstage/admin/sysusers");
		return mv;
	}

	@ApiOperation(value = "/indexHead", notes = "跳转页面")
	@ApiImplicitParam(name = "mv", value = "视图对象", required = true)
	@RequestMapping("/indexHead")
	public ModelAndView indexHead(ModelAndView mv) {
		mv.setViewName("/backstage/admin/indexHead");
		return mv;
	}

	@ApiOperation(value = "/getUserList", notes = "用户管理下获取用户列表的方法默认跳转页面进行显示")
	@ApiImplicitParam(name = "mv", value = "视图对象", required = true)
	@RequestMapping("/getUserList")
	public ResultModel getUserList(ModelAndView mv, HttpServletRequest request, SysUser sysUser) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageIndex", sysUser.getPageStartIndex());
		map.put("pageSize", sysUser.getPageSize());
		ResultModel result = userService.getUserList(map);
		return result;
	}

	@ApiOperation(value = "/deleteUserById", notes = "批量删除用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "mv",      value = "视图对象", required = true),
		@ApiImplicitParam(name = "request", value = "request对象", required = true)
	})
	@ApiImplicitParam(name = "mv", value = "视图对象", required = true)
	@RequestMapping("/deleteUserById")
	public ResultModel deleteUserById(ModelAndView mv, HttpServletRequest request) throws Exception {
		String ids = request.getParameter("ids");
		// 获取参数
		ResultModel result = userService.deleteUserByIds(ids);
		return result;
	}
	
	@ApiOperation(value = "/saveUser", notes = "保存用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "request", value = "request对象", required = true),
		@ApiImplicitParam(name = "sysUser", value = "sysUser", required = true)
	})
	@RequestMapping("/saveUser")
	public ResultModel saveUser( HttpServletRequest request,SysUser sysUser) throws Exception {
		// 获取参数
		ResultModel result = userService.saveUser(sysUser);
		return result;
	}
}
