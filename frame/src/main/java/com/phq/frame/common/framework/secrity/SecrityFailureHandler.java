package com.phq.frame.common.framework.secrity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phq.frame.common.constant.Contants;
import com.phq.frame.common.domain.ResultModel;
/**
 * 
* @ClassName: SecrityFailureHandler
* @Description: 
*    SecrityFailureHandler
*    登录失败返回json格式字符串 前端处理
* @author panhuaqing
* @date 2018年12月30日 下午5:38:42
*
 */
@Component
public class SecrityFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	 @Autowired
     private ObjectMapper objectMapper;
	 


    
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		ResultModel result = new ResultModel();
		result.setResult_code(Contants.WEB_ERROR_CODE);
		result.setResult_msg(Contants.WEB_ERROR_LOGIN);
		//设置字符集和转成json
		response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(result));
		//super.onAuthenticationFailure(request, response, exception);
        
       new DefaultRedirectStrategy().sendRedirect(request, response, "/login?error=true");
	}

	
	
}
