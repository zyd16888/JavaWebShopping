package com.singlelovely.dao;

import java.util.List;

import com.singlelovely.entity.Product;

public interface ProductDao {
	
	public List<Product> findNewProduct();

	/**
	 * 根据cid查询商品信息
	 * @param cid
	 * @return list商品信息
	 */
	public List<Product> findProductListByCid(String cid);
	
}
