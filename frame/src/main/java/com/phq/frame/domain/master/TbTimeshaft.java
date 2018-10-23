package com.phq.frame.domain.master;

import java.util.Date;

import com.phq.frame.common.domain.PageModel;
/**
 * 
* @ClassName: TbTimeshaft
* @Description: 
*     时间轴实体类
* @author panhuaqing
* @date 2018年10月22日
*
 */
public class TbTimeshaft extends PageModel {
	
    private String tmieId;

    private String timeTitle;

    private String timeContent;

    private Date timeIssueTime;

    private String timeUrl;

    private String timeIssueTag;

    private Integer timeIsuse;

    private Date timeCreateTime;

    private String timeCreateUser;
    
    private String strTimeIssueTime;

    
    public String getStrTimeIssueTime() {
		return strTimeIssueTime;
	}

	public void setStrTimeIssueTime(String strTimeIssueTime) {
		this.strTimeIssueTime = strTimeIssueTime;
	}

	public String getTmieId() {
        return tmieId;
    }

    public void setTmieId(String tmieId) {
        this.tmieId = tmieId == null ? null : tmieId.trim();
    }

    public String getTimeTitle() {
        return timeTitle;
    }

    public void setTimeTitle(String timeTitle) {
        this.timeTitle = timeTitle == null ? null : timeTitle.trim();
    }

    public String getTimeContent() {
        return timeContent;
    }

    public void setTimeContent(String timeContent) {
        this.timeContent = timeContent == null ? null : timeContent.trim();
    }

    public Date getTimeIssueTime() {
        return timeIssueTime;
    }

    public void setTimeIssueTime(Date timeIssueTime) {
        this.timeIssueTime = timeIssueTime;
    }

    public String getTimeUrl() {
        return timeUrl;
    }

    public void setTimeUrl(String timeUrl) {
        this.timeUrl = timeUrl == null ? null : timeUrl.trim();
    }

    public String getTimeIssueTag() {
        return timeIssueTag;
    }

    public void setTimeIssueTag(String timeIssueTag) {
        this.timeIssueTag = timeIssueTag == null ? null : timeIssueTag.trim();
    }

    public Integer getTimeIsuse() {
        return timeIsuse;
    }

    public void setTimeIsuse(Integer timeIsuse) {
        this.timeIsuse = timeIsuse;
    }

    public Date getTimeCreateTime() {
        return timeCreateTime;
    }

    public void setTimeCreateTime(Date timeCreateTime) {
        this.timeCreateTime = timeCreateTime;
    }

    public String getTimeCreateUser() {
        return timeCreateUser;
    }

    public void setTimeCreateUser(String timeCreateUser) {
        this.timeCreateUser = timeCreateUser == null ? null : timeCreateUser.trim();
    }
}