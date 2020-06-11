package com.jd.entity;

import java.io.Serializable;

/*
 *  分类的实体
 * */
public class Cate implements Serializable {
  private int cid;
  private String cname;
  private String chref;
  
public String getChref() {
	return chref;
}
public void setChref(String chref) {
	this.chref = chref;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
@Override
public String toString() {
	return "Cate [cid=" + cid + ", cname=" + cname + ", chref=" + chref + "]";
}

  
}
