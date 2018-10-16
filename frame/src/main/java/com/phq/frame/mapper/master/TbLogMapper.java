package com.phq.frame.mapper.master;

import org.apache.ibatis.annotations.Mapper;

import com.phq.frame.domain.master.TbLog;

@Mapper
public interface TbLogMapper {
	//日志插入
    public void insertLogData(TbLog log) throws Exception;
}
