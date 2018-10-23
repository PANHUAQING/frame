package com.phq.frame.common.domain;
/**
 * 
* @ClassName: PageModel
* @Description: 
*    分页实体类
* @author panhuaqing
* @date 2018年10月22日
*
 */
public class PageModel {
    private Integer pageIndex;
    private Integer pageSize;
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
