package com.nandhu.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class ConnectionUtil {

	public static Connection getConnect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		//LOGGER.debug(con);
		return con;
	}
	public static Jdbi getJdbi() throws Exception {
		Connection connection = ConnectionUtil.getConnect();
		Jdbi jdbi = Jdbi.create(connection);
		jdbi.installPlugin(new SqlObjectPlugin());
		return jdbi;
	}
}
