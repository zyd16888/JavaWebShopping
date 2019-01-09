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
	//��Ʒdao
	private ProductDao dao = new ProductDaoImpl();
	//��Ʒ����dao
	private CategoryDao cdao = new CategoryDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		//��ѯindexҳ������Ҫ������  jstl standard
		List<Product> list = dao.findNewProduct();
		request.setAttribute("list", list);
		
		//��session�л�ȡ���е���Ʒ������Ϣ�б�
		List<Category> categoryList = (List<Category>) session.getAttribute("categoryList");
		//�ж��Ƿ������Ʒ��Ϣ
		
		if (categoryList == null) {
			//��ѯ������Ʒ������Ϣ
			categoryList = cdao.findCategoryList();
			//����Ʒ����ŵ�session��   categoryList
			session.setAttribute("categoryList", categoryList);
		}
		
		
		//��ת��index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
