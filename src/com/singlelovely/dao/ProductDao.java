package com.singlelovely.dao;

import java.util.List;

import com.singlelovely.entity.Product;

public interface ProductDao {
	
	public List<Product> findNewProduct();

	/**
	 * ����cid��ѯ��Ʒ��Ϣ
	 * @param cid
	 * @return list��Ʒ��Ϣ
	 */
	public List<Product> findProductListByCid(String cid);
	
}
