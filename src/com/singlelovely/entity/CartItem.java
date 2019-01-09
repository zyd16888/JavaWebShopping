package com.singlelovely.entity;
/**
 * 	购物车项
 * @author dong
 *
 */
public class CartItem {
	private Product product; 	//商品
	private int number;			//数量
	private double price;		//小计
	public Product getProduct() {
		return product;
	}
	public int getNumber() {
		return number;
	}
	public double getPrice() {
		return price;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	//设置数量计算金额
	public void setNumber(int number) {
		this.number = number;
		this.price = product.getShopPrice() * number;
		
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
