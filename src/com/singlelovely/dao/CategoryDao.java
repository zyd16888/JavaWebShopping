package com.singlelovely.dao;

import java.util.List;

import com.singlelovely.entity.Category;

public interface CategoryDao {
	/**
	 *  	��ѯ���е���Ʒ����
	 * 
	 * @return 	���е���Ʒ�����б�
	 */
	
	public List<Category> findCategoryList() ;
}
