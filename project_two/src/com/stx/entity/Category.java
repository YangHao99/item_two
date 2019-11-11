package com.stx.entity;

public class Category {
	private Integer cid;
	private String cname;
	private String ctime;
	
	public Category() {}

	public Category(Integer cid, String cname, String ctime) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.ctime = ctime;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
}
