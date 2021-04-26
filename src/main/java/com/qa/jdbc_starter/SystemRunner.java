package com.qa.jdbc_starter;

import java.sql.Connection;
import java.util.Scanner;
import java.util.logging.Logger;

import com.qa.jdbc_starter.utils.DataSourceConnectionFactory;
import com.qa.jdbc_starter.utils.DatabaseConnectionUtilities;

public class SystemRunner {
	
	private final Logger LOGGER = Logger.getLogger(System.class.getName());

	public void run() {
		try (Scanner sc = new Scanner(System.in)) {
			LOGGER.info("Welcome");
		}
	}
	
	public void setup(String vendor) {
		try (Connection con = DataSourceConnectionFactory.getConnection(vendor)) {
			String schema = DatabaseConnectionUtilities.getSchema("src/main/resources/schema.sql");
			DatabaseConnectionUtilities.executeSchema(con, schema);
			LOGGER.info("System setup complete");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.warning("Schema or properties file not found");
		}
	}
}
