package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jni.User;

import com.stx.entity.TUser;
import com.stx.util.JDBCUtil;
import com.stx.util.StringUtil;

public class UserDao {
boolean isTure;
	/**
	 * 判断用户是否存在，存在就返回该用户所有信息 不存在返回null
	 * 
	 * @param user
	 *            用户登录数据包含用户名和密码
	 * @return TUser 用户所有信息 or null 用户不存在
	 */
	public TUser checkUserExist(TUser user) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement("select username,pwd,usernumber,email,customertype,certificatenumber,utime,discount,sex from tbl_user where username=?");
			st.setString(1, user.getUsername());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				// 得到当前登录用户的所有信息并返回
				TUser u = new TUser();
				u.setUsernumber(rs.getInt("usernumber"));
				u.setUsername(rs.getString("username"));
				u.setPwd(rs.getString("pwd"));
				u.setEmail((rs.getString("email")));
				u.setCustomertype(rs.getString("customertype"));
				u.setSex(rs.getString("sex"));
				u.setCertificatenumber((rs.getString("certificatenumber")));
				u.setCtime(rs.getString("utime"));
				return u;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeCon(con, st);
		}
		return null;
	}
	
}
