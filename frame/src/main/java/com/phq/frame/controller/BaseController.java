package com.phq.frame.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phq.frame.common.framework.redis.RedisUtil;
import com.phq.frame.domain.master.SysResource;
import com.phq.frame.domain.master.SysUser;
import com.phq.frame.domain.master.TbArticle;
import com.phq.frame.service.master.ArticleService;
import com.phq.frame.service.master.SysResourceService;
import com.phq.frame.service.master.UserService;

/**
 * 
 * @ClassName: BaseController
 * @Description: 基础控制类
 * @author panhuaqing
 * @date 2018年10月11日
 *
 */
@RestController
public class BaseController {


	@Autowired(required=true)
	private RedisUtil redisUtil;
	
	@Autowired
	private SysResourceService sysResourceService;

	@Autowired
	private UserService userService;
	
	// 博客首页跳转
	@RequestMapping(value = "/")
	public ModelAndView indexShow(ModelAndView mv) throws Exception {
		// 获取文章
		mv.setViewName("backstage/login");
		return mv;
	}

	// 博首页跳转
	@RequestMapping(value = "/index")
	public ModelAndView index(ModelAndView mv) throws Exception {
		// 首页跳转时获取当前登录用户
		User user = getLoginUser();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("loginname", user.getUsername() == null ? "" : user.getUsername() );
		List<SysResource> reourceList = sysResourceService.getSysResourceNavData(param);
		SysUser sysUser= userService.findByLoginName(user.getUsername() == null ? "" : user.getUsername());
		mv.setViewName("backstage/index");
		mv.addObject("reourceList", reourceList);
		mv.addObject("sysUser", sysUser);
		return mv;
	}

	// 后台登录 结合  secrity
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView mv) {
		return mv;
	}
	
	// 获取当前登录用户
   public User getLoginUser() {
			SecurityContext context = SecurityContextHolder.getContext();
			Authentication auth = context.getAuthentication();
			// 登入用户信息
			User  user =  (User) auth.getPrincipal();
			return user;
		}

}
