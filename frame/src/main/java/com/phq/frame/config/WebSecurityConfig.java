package com.phq.frame.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.phq.frame.common.framework.secrity.SecrityFailureHandler;
import com.phq.frame.filter.UserDefinedSecrityFilter;
import com.phq.frame.service.secrity.SysUserAuthenticationProvider;
import com.phq.frame.service.secrity.SysUserDetailsService;
/**
 * 
* @ClassName: WebSecurityConfig
* @Description: 
*   Security 主配置文件
* @author panhuaqing
* @date 2018年12月30日 下午2:24:38
*
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http
          //.addFilterBefore(UserDefinedSecrityFilter, FilterSecurityInterceptor.class)//在正确的位置添加我们自定义的过滤器
          .csrf().disable()
          .authorizeRequests()
          .antMatchers("/", "/error").permitAll()//访问：/ /error 无需登录认证权限
          //其他地址的访问均需验证权限
          .anyRequest().authenticated()//其他所有资源都需要认证，登陆后访问
          
          .and()
              .formLogin()
              //指定登录页是"/login"
              .loginPage("/")
              .loginProcessingUrl("/login") //自定义默认登录接口
              //.defaultSuccessUrl("/index")//登录成功后默认跳转到"/index"
              //.successHandler(loginSuccessHandler())
              .successForwardUrl("/index") //登录成功跳转首页
              .failureHandler(secrityFailureHandler()) //定义失败的handler 用于返回数据到页面
              //.failureUrl("/error")
              .permitAll()
             
              
          .and()
              .logout()
              .logoutSuccessUrl("/")//退出登录后的默认url是"/" 登录页面
              .permitAll()
              
          .and()
              .rememberMe()//登录后记住用户，下次自动登录,数据库中必须存在名为persistent_logins的表
              .tokenValiditySeconds(1209600);  ;
	}

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 auth.authenticationProvider(sysUserAuthenticationProvider());
		//auth.userDetailsService(sysUserDetailsService()).passwordEncoder(passwordEncoder());
       // auth.eraseCredentials(false);
    }

	 @Override
	public void configure(WebSecurity web) throws Exception {
	       //解决静态资源被拦截的问题
	        web.ignoring().antMatchers("/backstage/**");
	  }
    /**
     * 
    * @Title: passwordEncoder
    * @Description: 
    *    BCryptPasswordEncoder 进行加密
    * @param @return    
    * @return BCryptPasswordEncoder    
    * @throws
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(4);
    }
    
    /**
     * 设置用户密码的加密方式为MD5加密
     * @return
     */
 /*   @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();

    }*/
    
    /**
     * 自定义SysUserDetailsService，从数据库中读取用户信息
     * @return
     */
    @Bean
    public SysUserDetailsService sysUserDetailsService(){
        return new SysUserDetailsService();
    }
    
    
    @Bean
    public SysUserAuthenticationProvider sysUserAuthenticationProvider(){
    	return new SysUserAuthenticationProvider();
    }
    @Bean
    public SecrityFailureHandler secrityFailureHandler(){
    	return new SecrityFailureHandler();
    }

    


	
}
