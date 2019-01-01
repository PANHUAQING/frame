package com.phq.frame.service.secrity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.pagehelper.StringUtil;
import com.phq.frame.common.framework.secrity.BCryptPasswordUtil;
import com.phq.frame.domain.master.SysRole;
import com.phq.frame.domain.master.SysUser;
import com.phq.frame.service.master.UserService;

public class SysUserAuthenticationProvider implements AuthenticationProvider {
    private static final Logger logger = LoggerFactory.getLogger(SysUserAuthenticationProvider.class);

    @Autowired
	private UserService userService;
    
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String loginName = authentication.getName();
        String password  = authentication.getCredentials().toString();
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        if (vaildateUser(loginName, password, grantedAuths)) {
            Authentication auth = new UsernamePasswordAuthenticationToken(loginName, password, grantedAuths);
            return auth;
        } else {
            return null;
        }
	}
	  /**
	   * 
	  * @Title: vaildateUser
	  * @Description: 
	  *    用户校验
	  * @param @param loginName
	  * @param @param password
	  * @param @param grantedAuths
	  * @param @return    
	  * @return boolean    
	  * @throws
	   */
	  public boolean vaildateUser(String loginName, String password, List<GrantedAuthority> grantedAuths) {
		   SysUser user = userService.findByLoginName(loginName);
	        if (user==null || StringUtil.isEmpty(loginName) || StringUtil.isEmpty(password)) {
	            return false;
	        }
	        //进行密码对比 密码正确给予权限 否则不允许登录
	        if (BCryptPasswordUtil.passwordEncodeequals(password, user.getPassword())) {
	            List<SysRole> roles = user.getRoles();
	            //角色为空的情况写
	            if (roles.isEmpty()) {
	                grantedAuths.add(new SimpleGrantedAuthority("ROLE_NOTAUTH"));
	            }
	            //遍历角色放入 secrity  GrantedAuthority集合
	            for (SysRole role : roles) {
	                grantedAuths.add(new SimpleGrantedAuthority(role.getRoleType()));
	                logger.debug("username is " + loginName + ", " + role.getRoleType());
	            }
	            return true;
	        }
	        return false;
	    }

	  
	@Override
	public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
