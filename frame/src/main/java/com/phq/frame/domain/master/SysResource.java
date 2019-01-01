package com.phq.frame.domain.master;

import java.util.Date;
import java.util.List;

public class SysResource {
    private Integer resId;

    private String resName;

    private String resUrl;

    private String resDesc;

    private String resIcon;

    private Integer resPid;

    private Integer resStatus;

    private Integer resType;

    private Integer resSeq;

    private Date resCreatedate;
    
    public List<SysResource>  nextListResource; //二级菜单
    
    
    

    public List<SysResource> getNextListResource() {
		return nextListResource;
	}

	public void setNextListResource(List<SysResource> nextListResource) {
		this.nextListResource = nextListResource;
	}

	public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl == null ? null : resUrl.trim();
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc == null ? null : resDesc.trim();
    }

    public String getResIcon() {
        return resIcon;
    }

    public void setResIcon(String resIcon) {
        this.resIcon = resIcon == null ? null : resIcon.trim();
    }

    public Integer getResPid() {
        return resPid;
    }

    public void setResPid(Integer resPid) {
        this.resPid = resPid;
    }

    public Integer getResStatus() {
        return resStatus;
    }

    public void setResStatus(Integer resStatus) {
        this.resStatus = resStatus;
    }

    public Integer getResType() {
        return resType;
    }

    public void setResType(Integer resType) {
        this.resType = resType;
    }

    public Integer getResSeq() {
        return resSeq;
    }

    public void setResSeq(Integer resSeq) {
        this.resSeq = resSeq;
    }

    public Date getResCreatedate() {
        return resCreatedate;
    }

    public void setResCreatedate(Date resCreatedate) {
        this.resCreatedate = resCreatedate;
    }
}