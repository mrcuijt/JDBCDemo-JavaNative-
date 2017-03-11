package com.promeritage.jdbc.base.copy;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mysql.jdbc.Statement;

public abstract class BaseMapper {
	protected Statement statement;
	
	public BaseMapper(Connection con) {
		try {
			this.statement = (Statement) con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public abstract List<?> select();

	public abstract Object selectByPrimaryKey(int id);
	
	public abstract int insert(Object o);
	
	public abstract int update(Object o);
	
	public abstract int delete(int id);
	
	protected StringBuilder checkEndSqlSelective(StringBuilder sql){
		try {
			if(StringUtils.equals(", ", sql.substring(sql.length()-2))){
				sql.replace(sql.length()-2, sql.length(), "");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}
}
