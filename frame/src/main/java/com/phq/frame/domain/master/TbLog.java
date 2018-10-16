package com.phq.frame.domain.master;

import java.util.Date;

public class TbLog {
    private String logId;

    private String logRequestUrl;

    private String logRequestAttributes;

    private String logRequestSessionid;

    private String logRequestClientip;

    private Date logRequestStarttime;

    private Date logRequestEndtime;

    private String logLoginUserid;

    private String logLoginName;

    private Date logCreateTime;

    private String logException;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getLogRequestUrl() {
        return logRequestUrl;
    }

    public void setLogRequestUrl(String logRequestUrl) {
        this.logRequestUrl = logRequestUrl == null ? null : logRequestUrl.trim();
    }

    public String getLogRequestAttributes() {
        return logRequestAttributes;
    }

    public void setLogRequestAttributes(String logRequestAttributes) {
        this.logRequestAttributes = logRequestAttributes == null ? null : logRequestAttributes.trim();
    }

    public String getLogRequestSessionid() {
        return logRequestSessionid;
    }

    public void setLogRequestSessionid(String logRequestSessionid) {
        this.logRequestSessionid = logRequestSessionid == null ? null : logRequestSessionid.trim();
    }

    public String getLogRequestClientip() {
        return logRequestClientip;
    }

    public void setLogRequestClientip(String logRequestClientip) {
        this.logRequestClientip = logRequestClientip == null ? null : logRequestClientip.trim();
    }

    public Date getLogRequestStarttime() {
        return logRequestStarttime;
    }

    public void setLogRequestStarttime(Date logRequestStarttime) {
        this.logRequestStarttime = logRequestStarttime;
    }

    public Date getLogRequestEndtime() {
        return logRequestEndtime;
    }

    public void setLogRequestEndtime(Date logRequestEndtime) {
        this.logRequestEndtime = logRequestEndtime;
    }

    public String getLogLoginUserid() {
        return logLoginUserid;
    }

    public void setLogLoginUserid(String logLoginUserid) {
        this.logLoginUserid = logLoginUserid == null ? null : logLoginUserid.trim();
    }

    public String getLogLoginName() {
        return logLoginName;
    }

    public void setLogLoginName(String logLoginName) {
        this.logLoginName = logLoginName == null ? null : logLoginName.trim();
    }

    public Date getLogCreateTime() {
        return logCreateTime;
    }

    public void setLogCreateTime(Date logCreateTime) {
        this.logCreateTime = logCreateTime;
    }

    public String getLogException() {
        return logException;
    }

    public void setLogException(String logException) {
        this.logException = logException == null ? null : logException.trim();
    }
}