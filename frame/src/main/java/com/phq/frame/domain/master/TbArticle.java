package com.phq.frame.domain.master;

import java.io.Serializable;
import java.util.Date;

public class TbArticle  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String articleId;

    private String articleHead;

    private String articleAuthor;

    private String articleType;

    private Date articleTime;

    private Integer articleReadNum;

    private Integer articleReadLike;

    private String articleImgName;

    private String articleImgUrl;

    private String articleImgData;

    private Integer articleIsuse;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private String articleContent;
    
    private String strArticleTime;

    public String getStrArticleTime() {
		return strArticleTime;
	}

	public void setStrArticleTime(String strArticleTime) {
		this.strArticleTime = strArticleTime;
	}

	public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleHead() {
        return articleHead;
    }

    public void setArticleHead(String articleHead) {
        this.articleHead = articleHead == null ? null : articleHead.trim();
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor == null ? null : articleAuthor.trim();
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType == null ? null : articleType.trim();
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public Integer getArticleReadNum() {
        return articleReadNum;
    }

    public void setArticleReadNum(Integer articleReadNum) {
        this.articleReadNum = articleReadNum;
    }

    public Integer getArticleReadLike() {
        return articleReadLike;
    }

    public void setArticleReadLike(Integer articleReadLike) {
        this.articleReadLike = articleReadLike;
    }

    public String getArticleImgName() {
        return articleImgName;
    }

    public void setArticleImgName(String articleImgName) {
        this.articleImgName = articleImgName == null ? null : articleImgName.trim();
    }

    public String getArticleImgUrl() {
        return articleImgUrl;
    }

    public void setArticleImgUrl(String articleImgUrl) {
        this.articleImgUrl = articleImgUrl == null ? null : articleImgUrl.trim();
    }

    public String getArticleImgData() {
        return articleImgData;
    }

    public void setArticleImgData(String articleImgData) {
        this.articleImgData = articleImgData == null ? null : articleImgData.trim();
    }

    public Integer getArticleIsuse() {
        return articleIsuse;
    }

    public void setArticleIsuse(Integer articleIsuse) {
        this.articleIsuse = articleIsuse;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}