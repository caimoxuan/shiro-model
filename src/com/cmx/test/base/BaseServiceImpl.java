package com.cmx.test.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	protected BaseDao<T> dao;

	@Override
	public Integer add(T t) throws Exception {

		Integer id = dao.add(t);
		return id;
	}

	@Override
	public void delete(String id) throws Exception { 

		dao.delete(id);
	}

	@Override
	public void modify(T t) throws Exception {

		dao.modify(t);
	}

	@Override
	public List<T> query(T t) throws Exception {

		List<T> rowRecord = dao.query(t);
		return rowRecord;
	}

}