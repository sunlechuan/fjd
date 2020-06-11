package com.jd.entity;

public class OrderItem {
	private int pid;
	private int cid;
	private String pname;
	private double pprice;
	private String pspec;
	private int bid;
	private int count;
	private int user_id;
	private String address;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public String getPspec() {
		return pspec;
	}
	public void setPspec(String pspec) {
		this.pspec = pspec;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "OrderItem [pid=" + pid + ", cid=" + cid + ", pname=" + pname + ", pprice=" + pprice + ", pspec=" + pspec
				+ ", bid=" + bid + ", count=" + count + ", user_id=" + user_id + ", address=" + address + "]";
	}
	 
	
	
	
	
}
