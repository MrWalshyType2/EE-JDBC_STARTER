package com.qa.jdbc_starter.utils;

import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceFactory {

	static public DataSource getMysqlDataSource() throws Exception {
		Properties props = PropertyLoader.getProperties("src/main/resources/db.properties");
		
		if (props == null) throw new Exception("Properties file not loaded");
		
		MysqlDataSource mds = new MysqlDataSource();
		mds.setURL(props.getProperty("MYSQL_DB_URL"));
		mds.setUser(props.getProperty("MYSQL_DB_USERNAME"));
		mds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		
		return mds;
	}
}
