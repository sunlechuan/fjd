package com.jd.entity;

public class Page {
	private int totalPage;//��ҳ
	private int totalCount;//������
	private int currPage;//��ǰҳ��
	private int pageSize;//һ��ҳ�漸��
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
