package com.phq.frame.controller.blog;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phq.frame.common.constant.Contants;
import com.phq.frame.common.domain.ResultModel;
import com.phq.frame.domain.master.TbTimeshaft;
import com.phq.frame.service.es.ESTimeShaftRepository;
import com.phq.frame.service.master.TimeshaftService;
/**
 * 
* @ClassName: TimeshaftController
* @Description: 
*    时间轴操作类
* @author panhuaqing
* @date 2018年10月23日
*
 */
@RestController
@RequestMapping(value ="/blog/timeshaftController")
public class TimeshaftController {
	private static final Logger logger = LoggerFactory.getLogger(TimeshaftController.class);

	@Autowired
	private TimeshaftService timeshaftService;
	
	@Autowired
	private ESTimeShaftRepository eSTimeShaftRepository;
	
	
	/**
	 * @throws Exception 
	 * 
	* @Title: showTimeshaftJson
	* @Description: 
	*     获取时间轴数据
	* @param @param request
	* @param @return   
	* @return ResultModel    
	* @throws
	 */
	@RequestMapping("/showTimeshaftJson")
	public ResultModel  showTimeshaftJson(HttpServletRequest request) throws Exception {
	    String pageIndex = request.getParameter("pageIndex");
	    String pageSize = request.getParameter("pageSize");
	    //查询数据，然后处理
	    TbTimeshaft tbTimeshaft = new TbTimeshaft();
	    tbTimeshaft.setPageIndex(Integer.valueOf(pageIndex));
	    tbTimeshaft.setPageSize(Integer.valueOf(pageSize));
	    List<TbTimeshaft> timeShaftList =  timeshaftService.getTbTimeshaftList(tbTimeshaft);
	    int total =timeshaftService.getTbTimeshaftCount(tbTimeshaft);
	    
		return new ResultModel(Contants.WEB_SUCCESS_CODE,"数据获取成功!",timeShaftList,total);
	}
	/**
	 * 
	* @Title: saveTimeshaftObj
	* @Description: 
	*     时间轴数据保存
	* @param @param request
	* @param @param tbTimeshaft
	* @param @return
	* @param @throws Exception   
	* @return ResultModel    
	* @throws
	 */
	public ResultModel  saveTimeshaftObj(HttpServletRequest request,TbTimeshaft tbTimeshaft) throws Exception{
		timeshaftService.saveTimeShaftData(tbTimeshaft);
		return new ResultModel(Contants.WEB_SUCCESS_CODE,"数据保存成功!");
	}
	
	@RequestMapping("/test")
	public  void  test() {
		
	  TbTimeshaft tbTimeshaft = new TbTimeshaft();
	  tbTimeshaft.setId("111");
	  tbTimeshaft.setTimeContent("wewe");
	  tbTimeshaft.setTimeUrl("43434");
		eSTimeShaftRepository.save(tbTimeshaft);
	}
	

	@RequestMapping("/query")
	public  Optional<TbTimeshaft>   query() {
		
	  Optional<TbTimeshaft> tbTimeshaft =  eSTimeShaftRepository.findById("111");
	
	 return tbTimeshaft;
	}
	
	
}
