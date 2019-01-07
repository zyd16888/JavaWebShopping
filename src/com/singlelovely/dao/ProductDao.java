package com.singlelovely.dao;

import java.util.List;

import com.singlelovely.entity.Product;

public interface ProductDao {
	
	public List<Product> findNewProduct();
}
