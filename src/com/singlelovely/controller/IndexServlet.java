package com.singlelovely.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.singlelovely.dao.CategoryDao;
import com.singlelovely.dao.ProductDao;
import com.singlelovely.dao.impl.CategoryDaoImpl;
import com.singlelovely.dao.impl.ProductDaoImpl;
import com.singlelovely.entity.Category;
import com.singlelovely.entity.Product;


public class IndexServlet extends HttpServlet {
	//商品dao
	private ProductDao dao = new ProductDaoImpl();
	//商品分类dao
	private CategoryDao cdao = new CategoryDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		//查询index页面中需要的数据  jstl standard
		List<Product> list = dao.findNewProduct();
		request.setAttribute("list", list);
		
		//从session中获取所有的商品分类信息列表
		List<Category> categoryList = (List<Category>) session.getAttribute("categoryList");
		//判断是否存在商品信息
		
		if (categoryList == null) {
			//查询所有商品分类信息
			categoryList = cdao.findCategoryList();
			//将商品分类放到session中   categoryList
			session.setAttribute("categoryList", categoryList);
		}
		
		
		//跳转到index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
