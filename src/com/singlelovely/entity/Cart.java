package com.singlelovely.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
//���ﳵʵ��
public class Cart {
	//���ﳵ����б�
	//���ϵķ��ͣ�Լ�������ܹ���ŵ�Ԫ������
	private Map<String,CartItem> cart = new LinkedHashMap<String,CartItem>();
	private double price;//�ܼ�
	public Map<String, CartItem> getCart() {
		return cart;
	}
	public double getPrice() {
		//�����ܽ��
		//����cart�е�ÿһ��ȡ��ÿһ�����ﳵ���ÿһ�����ﳵ���С�����
		Set<Entry<String, CartItem>> entrySet = cart.entrySet();//��ȡ���������еļ�ֵ�����set����
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
	
	//��ӵ����ﳵ�ķ���
	public void add(CartItem item){
		//����pid��ȡ���ﳵ�����еĹ��ﳵ��
		CartItem cartItem = cart.get(item.getProduct().getPid());
		//�жϼ������Ƿ����Ҫ�������Ʒ
		//cartItemΪnullʱ��˵����Ʒ�ڹ��ﳵ�в�����
		if (cartItem == null) {
			//�����ﳵ����빺�ﳵ��
			cart.put(item.getProduct().getPid(), item);
		}else {
			//���ﳵ����ڣ��ı�����
			cartItem.setNumber(cartItem.getNumber() + item.getNumber());
			cart.put(item.getProduct().getPid(), cartItem);
		}
		
	}
	
	
}
