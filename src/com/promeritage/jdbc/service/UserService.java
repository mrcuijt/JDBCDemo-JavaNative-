package com.promeritage.jdbc.service;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.promeritage.jdbc.base.BaseService;
import com.promeritage.jdbc.mapper.UserMapper;
import com.promeritage.jdbc.model.UserVO;

public class UserService extends BaseService{
	private UserMapper userMapper;
	
	public UserService(Connection connection) {
		userMapper = new UserMapper(connection);
	}
	
	@Override
	public List<UserVO> select() {
		List<UserVO> list = new ArrayList<>();
		try {
			list = (List<UserVO>) userMapper.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.size() > 0 ? list : null;
	}

	@Override
	public UserVO selectByPrimaryKey(int id) {
		UserVO userVO = new UserVO();
		try {
			userVO = userMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO == null ? null : userVO;
	}

	@Override
	public UserVO insert(Object o) {
		int result = 0;
		try {
			UserVO userVO = (UserVO) o;
			result = userMapper.insert(userVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0 ? (UserVO) o : null;
	}

	@Override
	public UserVO update(Object o) {
		int result = 0;
		try {
			UserVO userVO = (UserVO) o;
			result = userMapper.update(userVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0 ? (UserVO) o : null;
	}

	@Override
	public boolean delete(int id) {
		int result = 0;
		try {
			result = userMapper.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0 ? true : false;
	}
	
	public boolean deleteByAccount(UserVO userVO){
		int result = 0;
		try {
			result = userMapper.deleteBySelective(userVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0 ? true : false;
	}
}
