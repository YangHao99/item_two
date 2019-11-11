package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.Category;
import com.stx.util.Const;
import com.stx.util.JDBCUtil;

public class CategoryDao {

	public boolean addCategory(String cname) {
		Connection con = null;
		PreparedStatement st = null;
		int n = Const.NUM_ZERO;
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement("select * from tbl_mycategory where cname=?");
			st.setString(1, cname);
			ResultSet rs = st.executeQuery();
			if (!rs.next()) {
				st = con.prepareStatement("insert into tbl_mycategory(cid,cname,ctime) values(seq_user.nextval,?,sysdate)");
				st.setString(1, cname);
				n = st.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeCon(con, st);
		}
		
		return n == Const.NUM_ONE;
	}
	
	public ArrayList<Category> getAllCategory() {
		Connection con = null;
		PreparedStatement st = null;
		ArrayList<Category> categories = new ArrayList<Category>();
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement("select cid,cname,to_char(ctime,'yyyymmdd hh24:mi:ss') ctime from tbl_mycategory");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setCid(rs.getInt("cid"));
				c.setCname(rs.getString("cname"));
				c.setCtime(rs.getString("ctime"));
		//		Category c = new Category(rs.getInt("cid"),rs.getString("cname"),rs.getString("ctime"));
				// 将每一行转为后的对象放入容器中保存
				categories.add(c);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeCon(con, st);
		}
		return categories;
	}
	
}
