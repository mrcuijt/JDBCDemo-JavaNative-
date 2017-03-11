package employee.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import employee.jdbc.base.BaseEntity;
import employee.jdbc.dao.EmployeeDao;
import employee.jdbc.dao.impl.EmployeeDaoImpl;
import employee.jdbc.entity.EmployeeEntity;
import employee.jdbc.utils.ShareTool;

public class EmployeeJdbc {
	private static EmployeeDao employeeDao;

	public static void main(String[] args) {
		Connection connection = null;
		
		Properties info = new Properties( );
		info.put( "user", "root" );
		info.put( "password", "root" );
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/USER?useUnicode=yes&characterEncoding=UTF-8", info);
			employeeDao = new EmployeeDaoImpl(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<BaseEntity> list = employeeDao.select();
		System.out.println("Result: " + ShareTool.toStringBuilder(list));
		System.out.println();
		
		list = employeeDao.selectByHiringEmployee();
		System.out.println("Result: " + ShareTool.toStringBuilder(list));
		System.out.println();
		
		list = employeeDao.selectByStaffEmployee();
		System.out.println("Result: " + ShareTool.toStringBuilder(list));
		System.out.println();
		
		BaseEntity baseEntity = employeeDao.selectByPrimaryKey(1);
		System.out.println("Result: " + ShareTool.toStringBuilder(baseEntity));
		System.out.println();
		
		EmployeeEntity employeeEntity;
		
		employeeEntity = new EmployeeEntity();
		employeeEntity.setName("employee4");
		employeeEntity.setGender("female");
		employeeEntity.setTelephone("0123456789");
		employeeEntity.setJob("hiring");
		baseEntity = employeeDao.insert(employeeEntity);
		System.out.println("Result: " + ShareTool.toStringBuilder(baseEntity));
		System.out.println();

		employeeEntity = new EmployeeEntity();
		employeeEntity.setId(5);
		employeeEntity.setName("employee4");
		employeeEntity.setGender("female");
		employeeEntity.setTelephone("0123456789");
		employeeEntity.setJob("staff");
		baseEntity = employeeDao.update(employeeEntity);
		System.out.println("Result: " + ShareTool.toStringBuilder(baseEntity));
		System.out.println();
		
		boolean result = employeeDao.delete(4);
		System.out.println("Result: " + ShareTool.toStringBuilder(result));
		System.out.println();
		
		/*
		 * Close connection
		 */
		
		if(connection != null){
			try {
				connection.close();
				System.out.println("Connection is closed: " + connection.isClosed());	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
