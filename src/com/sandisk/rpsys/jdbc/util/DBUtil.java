package com.sandisk.rpsys.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class DBUtil {
	public static final Logger logger = Logger.getLogger(new DBUtil().getClass());
	public static Connection getConnection() throws SQLException {
		//init driver
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		java.net.URL url = DBUtil.class.getClassLoader().getResource("/");
		String dbLocation = "/home/wcao/workspace/HTSandiskReportSys/WebContent/WEB-INF/resource/db/sandiskReportSys.db";
		logger.info("using "+ dbLocation + " as database");
		Connection conn = DriverManager
		        .getConnection("jdbc:sqlite:" + dbLocation );
		return conn;
	}
	
}
