/**
 * @ version 1.0
 * @ author dbxiao
 */

package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

	public TestJdbc() {
		String username = "root";
		String password = "";
		String url = "jdbc:mysql:///test1?characterEncoding=utf8&serverTimezone=UTC ";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from course");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				} 
				rs = null;
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				} 
				stmt = null;
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}

	public static void main(String[] args) {
		new TestJdbc();

	}

}
