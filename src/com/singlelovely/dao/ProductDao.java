package com.singlelovely.dao;

import java.util.List;

import com.singlelovely.entity.Product;

public interface ProductDao {
	/**
	 *	 ��ȡǰ9����Ʒ
	 * 
	 * @return		��ȡ������Ʒ����
	 */
	public List<Product> findNewProduct();
	/**
	 * 	����cid��ѯ��Ʒ��Ϣ
	 * 
	 * @param cid
	 * @return
	 */
	public List<Product> findProductListByCid(String cid);
}
