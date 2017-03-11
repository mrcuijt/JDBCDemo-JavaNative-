package employee.jdbc.dao;

import java.util.List;

import employee.jdbc.base.BaseEntity;

public interface EmployeeDao {
	public List<BaseEntity> select();

	public List<BaseEntity> selectByHiringEmployee();

	public List<BaseEntity> selectByStaffEmployee();
	
	public BaseEntity selectByPrimaryKey(int id);
	
	public BaseEntity insert(BaseEntity entity);
	
	public BaseEntity update(BaseEntity entity);
	
	public boolean delete(int id);
}
