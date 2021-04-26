package com.qa.jdbc_starter.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class DatabaseConnectionUtilities {

	private String dbms;
	private String server;
	private Integer port;
	private String username;
	private String password;
	
	public DatabaseConnectionUtilities() {
		this("mysql", "localhost", 3306, "root", "root");
	}

	public DatabaseConnectionUtilities(String dbms, String server, Integer port, String username, String password) {
		super();
		this.dbms = dbms;
		this.server = server;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	public Connection getConnection() throws Exception {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.username);
        connectionProps.put("password", this.password);

        if (this.dbms.equals("mysql")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://" +
                    this.server +
                    ":" + this.port + "/",
                    connectionProps);
        } else {
        	throw new Exception("DBMS not named");
        }
        System.out.println("Connected to database");
        return conn;
    }
	
	public Connection getConnection(String url) throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	static public Connection getConnection(String url, String username, String password) throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	static public void printSQLException(SQLException e) {
		// TODO: implement
		System.out.println(e.getMessage());
	}
	
	static public String getSchema(String path) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			StringBuilder sb = new StringBuilder();
			String line;
			
			while ((line = br.readLine()) != null) {
				if (line.isBlank()) sb.append("\n");
				sb.append(line);
			}
			return sb.toString();
		}
	}
	
	static public void executeSchema(Connection con, String query) throws SQLException {
		String[] queries = query.split("\n");
		try (Statement s = con.createStatement()) {
			for (var q : queries) {
				s.executeUpdate(q);
			}
		}
	}

	public String getDbms() {
		return dbms;
	}

	public void setDbms(String dbms) {
		this.dbms = dbms;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
