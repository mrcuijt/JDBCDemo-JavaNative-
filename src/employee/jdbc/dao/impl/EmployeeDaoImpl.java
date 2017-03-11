package employee.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import employee.jdbc.base.BaseDao;
import employee.jdbc.base.BaseEntity;
import employee.jdbc.dao.EmployeeDao;
import employee.jdbc.entity.EmployeeEntity;
import employee.jdbc.vo.HiringEmployeeVO;
import employee.jdbc.vo.PrincipalEmployeeVO;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao{
	public EmployeeDaoImpl(Connection con) {
		super(con);
	}

	@Override
	public List<BaseEntity> select() {
		List<BaseEntity> data = new ArrayList<>();
		try {
			StringBuilder sql = new StringBuilder("SELECT * FROM employee");
			System.out.println("ExecuteQuery: " + sql);
			ResultSet resultSet = statement.executeQuery(sql.toString());
			while (resultSet.next()) {
				EmployeeEntity employeeEntity = new EmployeeEntity();
				employeeEntity.setName(resultSet.getString("name"));
				employeeEntity.setGender(resultSet.getString("gender"));
				employeeEntity.setTelephone(resultSet.getString("telephone"));
				employeeEntity.setJob(resultSet.getString("job"));
				data.add(employeeEntity);
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<BaseEntity> selectByHiringEmployee() {
		List<BaseEntity> data = new ArrayList<>();
		try {
			StringBuilder sql = new StringBuilder("SELECT * FROM employee WHERE job = 'hiring'");
			System.out.println("ExecuteQuery: " + sql);
			ResultSet resultSet = statement.executeQuery(sql.toString());
			while (resultSet.next()) {
				HiringEmployeeVO employeeEntity = new HiringEmployeeVO();
				employeeEntity.setName(resultSet.getString("name"));
				employeeEntity.setGender(resultSet.getString("gender"));
				employeeEntity.setTelephone(resultSet.getString("telephone"));
				employeeEntity.setJob(resultSet.getString("job"));
				data.add(employeeEntity);
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<BaseEntity> selectByStaffEmployee() {
		List<BaseEntity> data = new ArrayList<>();
		try {
			StringBuilder sql = new StringBuilder("SELECT * FROM employee WHERE job = 'staff'");
			System.out.println("ExecuteQuery: " + sql);
			ResultSet resultSet = statement.executeQuery(sql.toString());
			while (resultSet.next()) {
				PrincipalEmployeeVO employeeEntity = new PrincipalEmployeeVO();
				employeeEntity.setName(resultSet.getString("name"));
				employeeEntity.setGender(resultSet.getString("gender"));
				employeeEntity.setTelephone(resultSet.getString("telephone"));
				employeeEntity.setJob(resultSet.getString("job"));
				data.add(employeeEntity);
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public BaseEntity selectByPrimaryKey(int id) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		try {
			StringBuilder sql = new StringBuilder("SELECT * FROM employee WHERE id = " + id);
			System.out.println("ExecuteQuery: " + sql);
			ResultSet resultSet = statement.executeQuery(sql.toString());
			while (resultSet.next()) {
				employeeEntity.setId(resultSet.getInt("id"));
				employeeEntity.setName(resultSet.getString("name"));
				employeeEntity.setGender(resultSet.getString("gender"));
				employeeEntity.setTelephone(resultSet.getString("telephone"));
				employeeEntity.setJob(resultSet.getString("job"));
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeEntity;
	}

	@Override
	public BaseEntity insert(BaseEntity entity) {
		int result = 0;
		try {
			EmployeeEntity employeeEntity = (EmployeeEntity) entity;
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO employee(name, gender, telephone, job) VALUES (");
			if(StringUtils.isNotBlank(employeeEntity.getName())){
				sql.append("'" + employeeEntity.getName() + "', ");
			}
			if(StringUtils.isNotBlank(employeeEntity.getGender())){
				sql.append("'" + employeeEntity.getGender() + "', ");
			}
			if(StringUtils.isNotBlank(employeeEntity.getTelephone())){
				sql.append("'" + employeeEntity.getTelephone() + "', ");
			}
			if(StringUtils.isNotBlank(employeeEntity.getJob())){
				sql.append("'" + employeeEntity.getJob() + "'");
			}
			sql = checkEndSqlSelective(sql);
			sql.append(")");
			System.out.println("ExecuteQuery: " + sql);
			result = statement.executeUpdate(sql.toString());
			
			if(result > 0){
				return employeeEntity;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BaseEntity update(BaseEntity entity) {
		int result = 0;
		try {
			EmployeeEntity employeeEntity = (EmployeeEntity) entity;
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE employee SET ");
			if(StringUtils.isNotBlank(employeeEntity.getName())){
				sql.append("name = '" + employeeEntity.getName() + "', ");
			}
			if(StringUtils.isNotBlank(employeeEntity.getGender())){
				sql.append("gender = '" + employeeEntity.getGender() + "', ");
			}
			if(StringUtils.isNotBlank(employeeEntity.getTelephone())){
				sql.append("telephone = '" + employeeEntity.getTelephone() + "', ");
			}
			if(StringUtils.isNotBlank(employeeEntity.getJob())){
				sql.append("job = '" + employeeEntity.getJob() + "'");
			}
			sql = checkEndSqlSelective(sql);
			sql.append(" WHERE id = " + employeeEntity.getId());
			System.out.println("ExecuteQuery: " + sql);
			result = statement.executeUpdate(sql.toString());	

			if(result > 0){
				return employeeEntity;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM employee WHERE id = " + id);
			System.out.println("ExecuteQuery: " + sql);
			result = statement.executeUpdate(sql.toString());
			
			if(result > 0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteBySelective(EmployeeEntity employeeEntity){
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM employee WHERE ");
			if(employeeEntity.getId() != 0){
				sql.append("id = " + employeeEntity.getId() + ", ");
			}
			if(StringUtils.isNotBlank(employeeEntity.getName())){
				sql.append("'" + employeeEntity.getName() + "', ");
			}
			if(StringUtils.isNotBlank(employeeEntity.getGender())){
				sql.append("'" + employeeEntity.getGender() + "', ");
			}
			if(StringUtils.isNotBlank(employeeEntity.getTelephone())){
				sql.append("'" + employeeEntity.getTelephone() + "', ");
			}
			if(StringUtils.isNotBlank(employeeEntity.getJob())){
				sql.append("'" + employeeEntity.getJob() + "'");
			}
			sql = checkEndSqlSelective(sql);
			System.out.println("ExecuteQuery: " + sql);
			result = statement.executeUpdate(sql.toString());
			
			if(result > 0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
