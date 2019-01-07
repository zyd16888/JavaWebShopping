package com.singlelovely.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.singlelovely.dao.ProductDao;
import com.singlelovely.entity.Product;
import com.singlelovely.utils.DBUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findNewProduct() {
		List<Product> list = new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	 	try {
	 		conn = DBUtils.getConnection();
			String sql = "select * from product order by pdate desc limit 0,9";
			pst = (PreparedStatement) DBUtils.getPst(conn, sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				String pid = rs.getString(1);
				String pname = rs.getString(2);
				double marketPrice = rs.getDouble(3);
				double shopPrice = rs.getDouble(4);
				String pimage = rs.getString(5);
				String pdate = rs.getString(6);
				int isHot = rs.getInt(7);
				String pdesc = rs.getString(8);
				int pflag = rs.getInt(9);
				String cid = rs.getString(10);
				
				Product p = new Product();
				
				//set ·½·¨
				
				p.setPid(pid);
				p.setPname(pname);
				p.setMarketPrice(marketPrice);
				p.setShopPrice(shopPrice);
				p.setPimage(pimage);
				p.setPdate(pdate);
				p.setIsHot(isHot);
				p.setPdesc(pdesc);
				p.setPflag(pflag);
				p.setCid(cid);
				
				list.add(p);
			}
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, pst, conn);
		}		
		
		return list;
	}

}
