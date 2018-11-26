package com.phq.frame.service.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.TbTimeshaft;
//es远程调用索引库
@Service
public interface  ESTimeShaftRepository extends ElasticsearchRepository<TbTimeshaft,String>{

}
