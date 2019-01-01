package com.phq.frame.controller.backstage;

import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phq.frame.controller.BaseController;

@RestController
@RequestMapping(value = "/backstage/menuController")
public class ResourceController extends BaseController {

	public ModelAndView showResourcePage(ModelAndView mv) {
		String user = this.getLoginUser();
		                            
		mv.setViewName("blog/info");
		mv.addObject("article", "");
		return mv;
	}
}
