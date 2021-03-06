package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	// select을 수행한 후 리소르 해제를 위한 메서드
	public static void close(Connection conn, Statement pstmt, ResultSet rs) {
		try {
			if(rs != null);
			rs.close();
			if(pstmt != null);
			pstmt.close();
			if(conn != null);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	// insert, update, delete
	public static void close(Connection conn, Statement pstmt) {
		try {
			if(pstmt != null);
			pstmt.close();
			if(conn != null);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
