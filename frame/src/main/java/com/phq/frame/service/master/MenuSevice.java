package com.phq.frame.service.master;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.vo.TbMenuVo;

@Service("menuSevice")
public interface MenuSevice {
	//获取菜单集合数据
	public List<TbMenuVo> getTbMenuVoList();  
}
