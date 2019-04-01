package com.phq.frame.service.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;
import com.phq.frame.domain.master.TbLog;
/**
 * 
 * @ClassName:  ESLogRepository   
 * @Description: log日志es接口
 * @author: panhuaqing
 * @date:   2019年3月29日 下午4:05:42     
 * @Copyright:
 */
@Service
public interface ESLogRepository extends ElasticsearchRepository<TbLog,String>{

}
