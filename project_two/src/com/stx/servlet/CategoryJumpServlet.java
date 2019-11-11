package com.stx.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.dao.CategoryDao;
import com.stx.entity.Category;

/**
 * Servlet implementation class CategoryJumpServlet
 */
public class CategoryJumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryJumpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用CategoryDao获取所有类型数据
		CategoryDao cd = new CategoryDao();
		ArrayList<Category> categories = cd.getAllCategory();
	
		// 将数据保存到request对象中，请求转发到category.jsp中进行显示
		request.setAttribute("cates", categories);
		request.setAttribute("category", new Category(1101, "category", "20191030 14:59:34"));
		request.getRequestDispatcher("category1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
