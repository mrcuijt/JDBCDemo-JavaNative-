package com.promeritage.jdbc.base;

import java.util.List;

import com.promeritage.jdbc.model.UserVO;

public abstract class BaseService {
	public abstract List<UserVO> select();
	
	public abstract UserVO selectByPrimaryKey(int id);
	
	public abstract Object insert(Object o);
	
	public abstract Object update(Object o);
	
	public abstract boolean delete(int id);
}
