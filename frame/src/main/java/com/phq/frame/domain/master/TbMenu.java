package com.phq.frame.domain.master;

import java.io.Serializable;

public class TbMenu implements Serializable  {
    private String menuId;

    private String menuName;

    private String menuUrl;

    private String menuPid;

    private Integer menuLevel;

    private Integer menuIsuse;
    
    private Integer menuOrder;
    
    

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid == null ? null : menuPid.trim();
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuIsuse() {
        return menuIsuse;
    }

    public void setMenuIsuse(Integer menuIsuse) {
        this.menuIsuse = menuIsuse;
    }

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}
    
    
}