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

import org.apache.tomcat.util.buf.UDecoder;

import com.stx.dao.UserDao;
import com.stx.entity.TUser;
import com.stx.util.JDBCUtil;
import com.stx.util.StringUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取客户端传递上来的数据
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		UserDao ud = new UserDao();
		TUser user = new TUser();
		user.setUsername(username);
		Connection con = null;
		try {
			con = JDBCUtil.getCon();
			String sql = "select username,pwd from tbl_user where username=? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			// 用户存在
			if (rs.next()) {
				System.out.println(rs.getString("pwd"));
				System.out.println(StringUtil.getMd5(pwd));
				System.out.println(username);
				if (rs.getString("pwd").equals(StringUtil.getMd5(pwd))) {    //StringUtil.getMd5(pwd)
					user = ud.checkUserExist(user);
					System.out.println(username + "登录成功");
					HttpSession session = request.getSession();
					session.setAttribute("uid", user.getUsernumber());
					session.setAttribute("uname", user.getUsername());
					// 用户信息展示在主界面中
					request.setAttribute("user", user);
					System.out.println(user.getUsername());
					request.getRequestDispatcher("home.jsp").forward(request, response);
				} else {
					request.setAttribute("msg1", "密码输入错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("msg", "用户不存在");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// request.setAttribute("msg", "***账号或密码输入错误***");
		// request.getRequestDispatcher("login.jsp").forward(request, response);
		

	}

}
