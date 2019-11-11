package com.stx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	public static Connection getCon() throws ClassNotFoundException,
			SQLException {
		// 1.注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2.创建连接
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "yh", "123456");
	}

	public static void closeCon(Connection con, Statement st) {
		// 4.释放连接
		try {
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
