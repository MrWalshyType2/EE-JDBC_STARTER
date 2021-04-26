package com.qa.jdbc_starter.service;

import java.util.List;

public interface CrudService<T, U extends Number> {

	public T create(T t);
	public T readById(U u);
	public List<T> readAll();
	public T update(T t);
	public Boolean delete(U u);
}
