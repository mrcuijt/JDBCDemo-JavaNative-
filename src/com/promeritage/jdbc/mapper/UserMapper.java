package com.promeritage.jdbc.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.promeritage.jdbc.base.BaseMapper;
import com.promeritage.jdbc.model.UserVO;

public class UserMapper extends BaseMapper{
	public UserMapper(Connection con) {
		super(con);
	}

	@Override
	public List<?> select() {
		List<UserVO> data = new ArrayList<>();
		try {
			StringBuilder sql = new StringBuilder("SELECT * FROM user");
			System.out.println("ExecuteQuery: " + sql);
			ResultSet resultSet = statement.executeQuery(sql.toString());
			while (resultSet.next()) {
				UserVO userVO = new UserVO();
				userVO.setAccount(resultSet.getString("account"));
				userVO.setPassword(resultSet.getString("password"));
				data.add(userVO);
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public UserVO selectByPrimaryKey(int id) {
		UserVO userVO = new UserVO();
		try {
			StringBuilder sql = new StringBuilder("SELECT * FROM user WHERE id = " + id);
			System.out.println("ExecuteQuery: " + sql);
			ResultSet resultSet = statement.executeQuery(sql.toString());
			while (resultSet.next()) {
				userVO.setId(resultSet.getInt("id"));
				userVO.setAccount(resultSet.getString("account"));
				userVO.setPassword(resultSet.getString("password"));
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}

	@Override
	public int insert(Object o) {
		int result = 0;
		try {
			UserVO userVO = (UserVO) o;
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO user(account, password) VALUES (");
			if(StringUtils.isNotBlank(userVO.getAccount())){
				sql.append("'" + userVO.getAccount() + "', ");
			}
			if(StringUtils.isNotBlank(userVO.getPassword())){
				sql.append("'" + userVO.getPassword() + "'");
			}
			sql = checkEndSqlSelective(sql);
			sql.append(")");
			System.out.println("ExecuteQuery: " + sql);
			result = statement.executeUpdate(sql.toString());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Object o) {
		int result = 0;
		try {
			UserVO userVO = (UserVO) o;
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE user SET ");
			if(StringUtils.isNotBlank(userVO.getAccount())){
				sql.append("account = '" + userVO.getAccount() + "', ");
			}
			if(StringUtils.isNotBlank(userVO.getPassword())){
				sql.append("password = '" + userVO.getPassword() + "'");
			}
			sql = checkEndSqlSelective(sql);
			sql.append(" WHERE id = " + userVO.getId());
			System.out.println("ExecuteQuery: " + sql);
			result = statement.executeUpdate(sql.toString());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int id) {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM user WHERE id = " + id);
			System.out.println("ExecuteQuery: " + sql);
			result = statement.executeUpdate(sql.toString());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteBySelective(UserVO userVO){
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM user WHERE ");
			if(userVO.getId() != 0){
				sql.append("id = " + userVO.getId() + ", ");
			}
			if(StringUtils.isNotBlank(userVO.getAccount())){
				sql.append("account = '" + userVO.getAccount() + "', ");
			}
			if(StringUtils.isNotBlank(userVO.getPassword())){
				sql.append("password = '" + userVO.getPassword() + "'");
			}
			sql = checkEndSqlSelective(sql);
			System.out.println("ExecuteQuery: " + sql);
			result = statement.executeUpdate(sql.toString());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
