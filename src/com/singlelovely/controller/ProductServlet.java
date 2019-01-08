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
		if (method.equals("findProductListByCid")) {
			String cid = request.getParameter("cid");
			findProductListByCid(request,response,cid);
		}else if (method.equals("findProductByPid")) {
			String pid = request.getParameter("pid");
			findProductByPid(request,response,pid);
		}
		
	}

	
	private void findProductByPid(HttpServletRequest request, HttpServletResponse response, String pid) throws ServletException, IOException {
		//����cid��ѯ���ݿ�
		Product product = dao.findProductByPid(pid);
		//����Ʒ��Ϣ��ŵ�request��
		request.setAttribute("productPid", product);
		//��ת��product_infoҳ��
		request.getRequestDispatcher("product_info.jsp").forward(request, response);
		return;
	}


	public void findProductListByCid(HttpServletRequest request, HttpServletResponse response, String cid) throws ServletException, IOException {
		
		//����cid��ѯ���ݿ�
		List<Product> list = dao.findProductListByCid(cid);
		//����Ʒ��Ϣ��ŵ�request��
		request.setAttribute("productList", list);
		
		//��ת��product_listҳ��
		request.getRequestDispatcher("product_list.jsp").forward(request, response);;
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
