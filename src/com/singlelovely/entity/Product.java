package com.singlelovely.entity;

/**
 * CREATE TABLE `product` (
  `pid` VARCHAR(32) NOT NULL,
  `pname` VARCHAR(50) DEFAULT NULL,
  `market_price` DOUBLE DEFAULT NULL,
  `shop_price` DOUBLE DEFAULT NULL,
  `pimage` VARCHAR(200) DEFAULT NULL,
  `pdate` DATETIME DEFAULT NULL,
  `is_hot` INT(11) DEFAULT NULL,
  `pdesc` VARCHAR(255) DEFAULT NULL,
  `pflag` INT(11) DEFAULT NULL,
  `cid` VARCHAR(32) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `sfk_0001` (`cid`),
  CONSTRAINT `sfk_0001` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
 * @author dong
 *
 */

public class Product {
	
	private String pid;
	private String pname;
	private double marketPrice;
	private double shopPrice;
	private String pimage;
	private String pdate;
	private int isHot;
	private String pdesc;
	private int pflag;
	private String cid;
	
	public String getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public double getMarketPrice() {
		return marketPrice;
	}
	public double getShopPrice() {
		return shopPrice;
	}
	public String getPimage() {
		return pimage;
	}
	public String getPdate() {
		return pdate;
	}
	public int getIsHot() {
		return isHot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public int getPflag() {
		return pflag;
	}
	public String getCid() {
		return cid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	
	
}
