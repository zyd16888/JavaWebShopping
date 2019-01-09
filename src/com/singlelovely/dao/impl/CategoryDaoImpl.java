package com.singlelovely.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.singlelovely.dao.CategoryDao;
import com.singlelovely.entity.Category;
import com.singlelovely.utils.DBUtils;

public class CategoryDaoImpl implements CategoryDao{
	@Override
	public List<Category> findCategoryList() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from category";
			pst = (PreparedStatement) DBUtils.getPst(conn, sql);
			rs = pst.executeQuery();
			while(rs.next()){
				String cid = rs.getString(1);
				String cname = rs.getString(2);
				Category c = new Category();
				c.setCid(cid);
				c.setCname(cname);
				list.add(c);
				
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pst, conn);
		}
		return list;
	}
}
