package com.phq.frame.mapper.master;

import org.apache.ibatis.annotations.Mapper;

import com.phq.frame.domain.master.TbLog;
/**
 * 
* @ClassName: TbLogMapper
* @Description: 
*     日志mapper对象
* @author panhuaqing
* @date 2018年10月17日
*
 */
@Mapper
public interface TbLogMapper {
	//日志保存到数据库
    public void insertLogData(TbLog log) throws Exception;
    //跟新日志请求结束时间
    public void updateEndTimeByPrimaryKey(TbLog log) throws Exception;
}
