package com.qa.jdbc_starter.controller;

// Usually would return some value(s) for web apps, no need for CLI app
public interface CrudController {

	public void create();
	public void readById();
	public void readAll();
	public void update();
	public void delete();
}
