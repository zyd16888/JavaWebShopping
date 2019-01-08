package com.singlelovely.dao;

import java.util.List;

import com.singlelovely.entity.Product;

public interface ProductDao {
	/**
	 *	 获取前9个商品
	 * 
	 * @return		获取到的商品对象
	 */
	public List<Product> findNewProduct();
	/**
	 * 	根据cid查询商品信息
	 * 
	 * @param cid
	 * @return
	 */
	public List<Product> findProductListByCid(String cid);
}
