package com.singlelovely.entity;
/**
 * 	���ﳵ��
 * @author dong
 *
 */
public class CartItem {
	private Product product; 	//��Ʒ
	private int number;			//����
	private double price;		//С��
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
	//��������������
	public void setNumber(int number) {
		this.number = number;
		this.price = product.getShopPrice() * number;
		
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
