package com.app.data.interfaces;

public interface DataAccessInterface<T> {
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
	public T findByObject(T t);
	public T findByID(int id);

}	

