package com.qa.jdbc_starter.persistence.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T, U extends Number> {

	public T create(T t, Connection connection);
	public T readById(U u, Connection connection);
	public List<T> readAll(Connection connection);
	public T update(Connection connection, T t);
	public Boolean delete(Connection connection, U u);
}
