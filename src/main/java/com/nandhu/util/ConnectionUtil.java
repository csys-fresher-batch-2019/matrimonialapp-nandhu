package com.nandhu.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getConnect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "nandhini", "nandhini");
		return con;
	}
}
