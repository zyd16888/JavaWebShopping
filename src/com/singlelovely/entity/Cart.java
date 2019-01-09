package com.singlelovely.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
//购物车实体
public class Cart {
	//购物车项的列表
	//集合的泛型：约束集合能够存放的元素类型
	private Map<String,CartItem> cart = new LinkedHashMap<String,CartItem>();
	private double price;//总计
	public Map<String, CartItem> getCart() {
		return cart;
	}
	public double getPrice() {
		//计算总金额
		//遍历cart中的每一项取出每一个购物车项，将每一个购物车项的小计相加
		Set<Entry<String, CartItem>> entrySet = cart.entrySet();//获取集合中所有的键值对组成set集合
		double money = 0;
		for (Entry<String, CartItem> entry : entrySet) {
			money += entry.getValue().getPrice();
		}
		this.price = money;
		
		return price;
	}
	public void setCart(Map<String, CartItem> cart) {
		this.cart = cart;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	//添加到购物车的方法
	public void add(CartItem item){
		//根据pid获取购物车集合中的购物车项
		CartItem cartItem = cart.get(item.getProduct().getPid());
		//判断集合中是否存在要加入的商品
		//cartItem为null时，说明商品在购物车中不存在
		if (cartItem == null) {
			//将购物车项加入购物车中
			cart.put(item.getProduct().getPid(), item);
		}else {
			//购物车项存在，改变数量
			cartItem.setNumber(cartItem.getNumber() + item.getNumber());
			cart.put(item.getProduct().getPid(), cartItem);
		}
		
	}
	
	
}
