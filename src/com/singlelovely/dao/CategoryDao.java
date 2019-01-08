package com.singlelovely.dao;

import java.util.List;

import com.singlelovely.entity.Category;

public interface CategoryDao {
	/**
	 *  	查询所有的商品分类
	 * 
	 * @return 	所有的商品分类列表
	 */
	
	public List<Category> findCategoryList() ;
}
