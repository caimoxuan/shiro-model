package com.cmx.test.base;

import java.util.List;

public interface BaseDao<T> {

	public List<T> query(T t);

	public void delete(String id);

	public void modify(T t);

	public Integer add(T t);

}