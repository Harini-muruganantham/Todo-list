 package com.usermanagement.dao;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.SQLException;

import com.usermanagment.bean.User;
import com.usermanagement.utils.JDBCUtils;

public class UserDao {

	public int registerEmployee(User employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (name,gender, email, password,country) VALUES " +
            " (?, ?, ?, ?,?);";

        int result = 0;
        try (Connection connection = JDBCUtils.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getGender());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getCountry());

            System.out.println(preparedStatement);
            
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            
            JDBCUtils.printSQLException(e);
        }
        return result;
    }
	
	
	
	
}
