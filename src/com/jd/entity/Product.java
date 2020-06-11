package com.jd.entity;

public class Product {
	private int pid;
	private int cid;
	private String pname;
	private double pprice;
	private String pspec;
	private String pdate;
	private String pshop;
	
	
	
	public String getPshop() {
		return pshop;
	}
	public void setPshop(String pshop) {
		this.pshop = pshop;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
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
	 
//	@Override
//	public String toString() {
//		return "Product [pid=" + pid + ", cid=" + cid + ", pname=" + pname + ", pprice=" + pprice + ", pspec=" + pspec
//				+ "]";
//	}
	
	@Override
	public String toString() {
		return "{pid:\"" + pid + "\",cid:\"" + cid + "\",pname:\"" + pname + "\",pprice:\"" + pprice + "\",pspec:\"" + pspec + "\",pdate:\"" + pdate + "\",pshop:\"" + pshop + "\"}";
	}
	
	
	
	public Product(int pid, int cid, String pname, double pprice, String pspec, String pdate, String pshop) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.pname = pname;
		this.pprice = pprice;
		this.pspec = pspec;
		this.pdate = pdate;
		this.pshop = pshop;
	}
	public Product() {
		
	}
	
	
	
}
