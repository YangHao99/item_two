package com.stx.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stx.dao.AddDao;
import com.stx.dao.UserDao;
import com.stx.entity.TUser;
import com.stx.util.JDBCUtil;
import com.stx.util.StringUtil;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TUser user = new TUser();
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		// 获取客户端传递上来的数据
		String username = request.getParameter("username");
		System.out.println(username);
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String customertype = request.getParameter("customertype");
		String certificatenumber = request.getParameter("certificatenumber");
		String sex = request.getParameter("sex");
		                           
		
		user.setUsername(username);
		
		user.setPwd(StringUtil.getMd5(pwd));
		user.setEmail(email);
		user.setCustomertype(customertype);
		user.setCertificatenumber(certificatenumber);
		user.setSex(sex);
		
		
		
		// 从数据库中查询该用户是否存在
		AddDao ad = new AddDao();
		Connection con = null;
		
			try {
				con = JDBCUtil.getCon();
				String sql = "select username from tbl_user where username=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, username);
				ResultSet rs = st.executeQuery();
				// 用户存在
				if(rs.next()){
					request.setAttribute("rMes", "**用户已存在**");
			request.getRequestDispatcher("regist.jsp").forward(request, response);
				} else {
					ad.save(user);
					System.out.println(username+"注册成功");
					response.sendRedirect("/project_two/login.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
