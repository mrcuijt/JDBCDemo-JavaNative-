package employee.jdbc.base;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseDao {
	protected Statement statement;
	
	public BaseDao(Connection con) {
		try {
			this.statement = (Statement) con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
