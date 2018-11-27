package com.phq.frame.service.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;
import com.phq.frame.domain.master.TbLog;

@Service
public interface ESLogRepository extends ElasticsearchRepository<TbLog,String>{

}
