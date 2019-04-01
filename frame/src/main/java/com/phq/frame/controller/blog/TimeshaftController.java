package com.phq.frame.controller.blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phq.frame.common.constant.Contants;
import com.phq.frame.common.domain.ResultModel;
import com.phq.frame.domain.master.TbTimeshaft;
import com.phq.frame.service.es.ESTimeShaftRepository;
import com.phq.frame.service.master.TimeshaftService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
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
@EnableSwagger2
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
	
	@RequestMapping("/esAdd")
	public  void  test() {
	  for(int i=0;i<200;i++) {
		  TbTimeshaft tbTimeshaft = new TbTimeshaft();
		  tbTimeshaft.setTmieId("111"+i);
		  tbTimeshaft.setTimeContent("wewe"+i);
		  tbTimeshaft.setTimeUrl("43434"+i);
		  eSTimeShaftRepository.save(tbTimeshaft);
	  }
		
	}
	

	@RequestMapping("/esQueryById")
	public  Optional<TbTimeshaft>   esQueryById() {
	//通过id查询	TbTimeshaft
	Optional<TbTimeshaft> tbTimeshaft =  eSTimeShaftRepository.findById("111");
	
	 return tbTimeshaft;
	}

	@RequestMapping("/esQueryPage")
	public Page<TbTimeshaft>  esQueryPage() {
		
		
		Pageable  pageable= new PageRequest(0,200);
		Page<TbTimeshaft>  tbTimeshaft = eSTimeShaftRepository.findAll(pageable);
	
	 return tbTimeshaft;
	}
	
	
	@RequestMapping("/esQueryPageAndSearch")
	public Page<TbTimeshaft>  esQueryPageAndSearch() {
		
		Pageable  pageable= new PageRequest(0,200);
		
		Page<TbTimeshaft>  tbTimeshaft = eSTimeShaftRepository.findAll(pageable);
	    
		//构造一个查询构造器
		QueryBuilder query =QueryBuilders.matchQuery("timeContent", "wewe25");
		
		QueryBuilders.termQuery("timeContent", "wewe13");
		
		Iterable<TbTimeshaft> it =  eSTimeShaftRepository.search(query);
		it.forEach( tbl ->{
	        System.out.println(tbl.getTimeUrl()); 
		});
	 return tbTimeshaft;
	}
	
}
