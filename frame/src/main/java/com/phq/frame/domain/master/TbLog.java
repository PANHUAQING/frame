package com.phq.frame.domain.master;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName="frame_tbLog",type="tbLog",shards = 5,replicas = 1)
public class TbLog {
	@Id
    private String id;
	
	
    private String logId;

    @Field(type = FieldType.Text)
    private String logRequestUrl;

    @Field(type = FieldType.Text)
    private String logRequestAttributes;

    @Field(type = FieldType.Text)
    private String logRequestSessionid;

    @Field(type = FieldType.Text)
    private String logRequestClientip;

    @Field(type = FieldType.Date)
    private Date logRequestStarttime;

    @Field(type = FieldType.Date)
    private Date logRequestEndtime;

    @Field(type = FieldType.Text)
    private String logLoginUserid;

    @Field(type = FieldType.Text)
    private String logLoginName;

    @Field(type = FieldType.Date)
    private Date logCreateTime;

    @Field(type = FieldType.Text)
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