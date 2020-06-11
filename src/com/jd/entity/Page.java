package com.jd.entity;

public class Page {
	private int totalPage;//总页
	private int totalCount;//总条数
	private int currPage;//当前页面
	private int pageSize;//一个页面几个
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "Page [totalPage=" + totalPage + ", totalCount=" + totalCount + ", currPage=" + currPage + ", pageSize="
				+ pageSize + "]";
	}
	
	
}
