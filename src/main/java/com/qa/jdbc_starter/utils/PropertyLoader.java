package com.qa.jdbc_starter.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	static public Properties getProperties(String path) {
		Properties properties = new Properties();
		
		try (FileInputStream fIn = new FileInputStream(path)) {
			properties.load(fIn);
			return properties;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
