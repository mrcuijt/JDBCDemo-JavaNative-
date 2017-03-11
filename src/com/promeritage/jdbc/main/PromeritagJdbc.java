package com.promeritage.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.promeritage.jdbc.model.UserVO;
import com.promeritage.jdbc.service.UserService;
import com.promeritage.jdbc.utils.ShareTool;

public class PromeritagJdbc {
	private static UserService userService;
	
	public static void main(String[] args) {
		Connection connection = null;
		
		Properties info = new Properties( );
		info.put( "user", "root" );
		info.put( "password", "root" );
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/dev_test?useUnicode=yes&characterEncoding=UTF-8", info);
			userService = new UserService(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<UserVO> list = userService.select();
		System.out.println("Result: " + ShareTool.toStringBuilder(list));
		System.out.println();
		
		UserVO userVO = userService.selectByPrimaryKey(1);
		System.out.println("Result: " + ShareTool.toStringBuilder(userVO));
		System.out.println();
		
		userVO = new UserVO();
		userVO.setAccount("admin3");
		userVO.setPassword("admin3");
		userVO = userService.insert(userVO);
		System.out.println("Result: " + ShareTool.toStringBuilder(userVO));
		System.out.println();

		userVO = new UserVO();
		userVO.setId(8);
		userVO.setAccount("xxxx");
		userVO.setPassword("xxxx");
		userVO = userService.update(userVO);
		System.out.println("Result: " + ShareTool.toStringBuilder(userVO));
		System.out.println();
		
		boolean result = userService.delete(3);
		System.out.println("Result: " + ShareTool.toStringBuilder(result));
		System.out.println();

		userVO = new UserVO();
//		userVO.setAccount("admin3");
		userVO.setPassword("xxxx");
		result = userService.deleteByAccount(userVO);
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
