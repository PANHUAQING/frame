package com.phq.frame.domain.master.vo;

import java.io.Serializable;
import java.util.List;

import com.phq.frame.domain.master.TbMenu;

public class TbMenuVo  extends TbMenu implements Serializable {
	
	private List<TbMenuVo> tbMenuChild;

	public List<TbMenuVo> getTbMenuChild() {
		return tbMenuChild;
	}

	public void setTbMenuChild(List<TbMenuVo> tbMenuChild) {
		this.tbMenuChild = tbMenuChild;
	}
	
	

}
