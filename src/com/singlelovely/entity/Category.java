package com.singlelovely.entity;

/**
 * `cid` VARCHAR(32) NOT NULL,
 *	`cname` VARCHAR(20) DEFAULT NULL,
 * 
 * @author dong
 *
 */

public class Category {

	private String cid;
	private String cname;
	
	public String getCid() {
		return cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
