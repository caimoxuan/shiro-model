package com.cmx.test.base;

import java.util.List;

public interface BaseService<T> {

	public List<T> query(T t) throws Exception;

	public void delete(String id) throws Exception;

	public void modify(T t) throws Exception;

	public Integer add(T t) throws Exception;

}