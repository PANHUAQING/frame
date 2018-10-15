package com.phq.frame.service.master.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phq.frame.domain.master.TbMenu;
import com.phq.frame.domain.master.vo.TbMenuVo;
import com.phq.frame.mapper.master.TbMenuMapper;
import com.phq.frame.service.master.MenuSevice;
/**
 * 
* @ClassName: MenuSeviceImpl
* @Description: 
*    菜单业务类
* @author panhuaqing
* @date 2018年10月11日
*
 */
@Service
public class MenuSeviceImpl implements MenuSevice {
   
	@Autowired
	private TbMenuMapper tbMenuMapper;
	
    /**
     * 
    * @Title: getTbMenuVoList
    * @Description: 
    *     获取菜单列表
    * @param @return   
    * @return List<TbMenuVo>    
    * @throws
     */
	public List<TbMenuVo> getTbMenuVoList(){
		//获取第一级菜单
		TbMenuVo menuVo = new TbMenuVo();
		menuVo.setMenuLevel(1);
		menuVo.setMenuPid("0");
		List<TbMenuVo> menuList =  tbMenuMapper.selectMenuList(menuVo);
		//获取第二级菜单
		Iterator<TbMenuVo> it =  menuList.iterator();
		  while(it.hasNext()) {
			  menuVo = new TbMenuVo();
			  menuVo.setMenuLevel(2);
			  
			  TbMenuVo menuOne = it.next();
			  menuVo.setMenuPid(menuOne.getMenuId());
			  
			  List<TbMenuVo> menuListChild =  tbMenuMapper.selectMenuList(menuVo);
			  menuOne.setTbMenuChild(menuListChild);
		}
		return menuList;
	}
}
