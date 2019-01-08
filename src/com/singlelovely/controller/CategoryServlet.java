package com.singlelovely.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.singlelovely.dao.CategoryDao;
import com.singlelovely.dao.impl.CategoryDaoImpl;
import com.singlelovely.entity.Category;


public class CategoryServlet extends HttpServlet {
	
	private CategoryDao dao = new CategoryDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//查询商品的分类信息
		List<Category> categoryList = dao.findCategoryList();
		//将商品分类信息的集合存放到session中
		request.getSession().setAttribute("categoryList", categoryList);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
