package com.qa.jdbc_starter.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceConnectionFactory {

	static public Connection getConnection(String dbVendor) throws SQLException, Exception {
		switch (dbVendor.toLowerCase()) {
		case "mysql":
			return DataSourceFactory.getMysqlDataSource()
									.getConnection();
		default:
			throw new Exception("Database vendor not supported");
		}
	}
}
