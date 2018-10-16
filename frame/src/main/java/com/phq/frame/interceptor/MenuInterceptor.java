package com.phq.frame.interceptor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.phq.frame.domain.master.vo.TbMenuVo;
import com.phq.frame.service.master.MenuSevice;
import com.phq.frame.util.JsonUtil;
import com.phq.frame.util.RedisUtil;
import net.sf.json.JSONArray;

/**
 * 
* @ClassName: MenuInterceptor
* @Description: 
*    拦截所有请求 然后查看是否是跳转页面 是的话存入菜单信息 
* @author panhuaqing
* @date 2018年10月11日
*
 */
public class MenuInterceptor implements HandlerInterceptor {
	private RedisUtil redisUtil;
	private MenuSevice menuSevice;
	
	public MenuInterceptor(MenuSevice menuSevice,RedisUtil redisUtil) {
		this.menuSevice =  menuSevice;
		this.redisUtil =  redisUtil;
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
    /**
     * 请求完成之后对页面跳转的请求实现菜单获取
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		try {
			//redis存在从缓存中取
		    if(redisUtil.hasKey("menuList")) {
		    	Object menu = redisUtil.get("menuList");
				List<TbMenuVo> menuListRedis  =  (List<TbMenuVo>) JsonUtil.strToList(menu.toString(), TbMenuVo.class);
				modelAndView.addObject("menuList",menuListRedis);
		    }else {
				if(menuSevice!=null) {
					List<TbMenuVo> menuList =   menuSevice.getTbMenuVoList();
					JSONArray jsonArray = JSONArray.fromObject(menuList);
					redisUtil.set("menuList", jsonArray.toString());
					Object menu = redisUtil.get("menuList");
					
					List<TbMenuVo> menuListRedis  =  (List<TbMenuVo>) JsonUtil.strToList(menu.toString(), TbMenuVo.class);
					modelAndView.addObject("menuList",menuListRedis);
				}
		    }
		}catch (Exception e) {
			if(menuSevice!=null) {
			List<TbMenuVo> menuList =   menuSevice.getTbMenuVoList();
			modelAndView.addObject("menuList",menuList);
			}
		}
		
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
   
}
