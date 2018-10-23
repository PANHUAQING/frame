package com.phq.frame.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
* @ClassName: GlobalExceptionHandler
* @Description: 
*    全局异常处理器 针对controller
* @author panhuaqing
* @date 2018年10月22日
*
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	//日志处理
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class); 

	//异常页面
    public static final String DEFAULT_ERROR_VIEW = "error";
    
    /**
     * 
    * @Title: businessExceptionHandler
    * @Description: 
    *     controller发生的异常进行处理
    * @param @param req
    * @param @param e
    * @param @return
    * @param @throws Exception   
    * @return ModelAndView    
    * @throws
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView businessExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
    	logger.info("发生异常(controller)。。。。。。。。。。。。。。。。。。。。。。。。。。"+e.getMessage());
    	//异常信息入库
    	
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "服务器异常！");
        mv.setViewName(DEFAULT_ERROR_VIEW);
        return mv;
    }
    /**
     * 
    * @Title: jsonExceptionHandler
    * @Description: 
    *     自定义异常处理
    * @param @param req
    * @param @param e
    * @param @return   
    * @return Map<String,String>    
    * @throws
     */
    @ExceptionHandler(value = UserDefinedException.class)
    @ResponseBody
    public Map<String, String> jsonExceptionHandler(HttpServletRequest req, UserDefinedException e) {
    	logger.info("发生异常（  自定义异常）。。。。。。。。。。。。。。。。。。。。。。。。。。"+e.getResultMsg());
    	//异常信息入库
    	
        Map<String, String> re = new HashMap<String, String>();
        re.put("error", e.getResultCode());
        re.put("msg", e.getResultMsg());
        return re;
    }

}
