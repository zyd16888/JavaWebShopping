package com.singlelovely.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.singlelovely.dao.ProductDao;
import com.singlelovely.dao.impl.ProductDaoImpl;
import com.singlelovely.entity.Product;

public class ProductServlet extends HttpServlet {
	private ProductDao dao = new ProductDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method.equals("findProductListByCid")){
			String cid = request.getParameter("cid");
			findProductListByCid(request,response,cid);
			
		}
	}

	public void findProductListByCid(HttpServletRequest request, HttpServletResponse response, String cid) throws ServletException, IOException {
		//通过传入的cid查询数据库
		List<Product> list = dao.findProductListByCid(cid);
		//将list商品信息存放入request中跳转出去
		request.setAttribute("productList", list);
		
		//go to product_list
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
