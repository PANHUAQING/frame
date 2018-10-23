package com.phq.frame.mapper.master;

import com.phq.frame.domain.master.TbTimeshaft;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * 
* @ClassName: TbTimeshaftMapper
* @Description: 
*    时间轴mapper
* @author panhuaqing
* @date 2018年10月22日
*
 */
@Mapper
public interface TbTimeshaftMapper {
 
	//保存时间轴数据
    public void insertTimeShaftData(TbTimeshaft tbTimeshaft);
	
    //查询时间轴数据
	public List<TbTimeshaft>  selectTimeShaftDataList(TbTimeshaft tbTimeshaft) throws Exception;
	
	//查询实际轴总记录数
	public int  selectTimeShaftDataCount(TbTimeshaft tbTimeshaft) throws Exception;
	
	
}