package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stx.entity.TUser;
import com.stx.util.JDBCUtil;

public class AddDao {

	/**
	 * 保存数据
	 * 
	 * @param user
	 * @return
	 */
	public void save(TUser user) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement(
					"insert into tbl_user(username,pwd,usernumber,email,customertype,certificatenumber,utime,discount,sex) values(?,?,seq_user.nextval,?,?,?,sysdate,?,?)");
			System.out.println(user.getUsername());
			st.setString(1, user.getUsername());
			st.setString(2, user.getPwd());
			st.setString(3, user.getEmail());
			st.setString(4, user.getCustomertype());
			st.setString(5, user.getCertificatenumber());
			if (user.getCustomertype().equals("会员用户")) {
				user.setDiscount(8);
			} else {
				user.setDiscount(10);
			}
			st.setInt(6, user.getDiscount());
			st.setString(7, user.getSex());
			st.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeCon(con, st);
		}
	}

	/**
	 * 验证账号是否被占用
	 */
	/*
	 * public boolean findByUsername(String username){ boolean isUsed = false;
	 * Connection con = null; try { con = JDBCUtil.getCon(); String sql =
	 * "select username from tbl_user where username=?"; PreparedStatement st =
	 * con.prepareStatement(sql); st.setString(1, username); ResultSet rs =
	 * st.executeQuery(); if(rs.next()){ isUsed = true; } } catch
	 * (ClassNotFoundException | SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } return isUsed; }
	 */

}
