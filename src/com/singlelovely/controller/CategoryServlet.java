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

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends HttpServlet {
	private CategoryDao dao = new CategoryDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询商品分类信息
		List<Category> categoryList = dao.findCategoryList();
		//将商品分类信息的集合对象存放到session域
		request.getSession().setAttribute("categoryList", categoryList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
