package practice;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.exceptions.RSAException;

public class HWSelf {

	public static void main(String[] args) throws SQLException {

		String dbUsername = "syntax_hrm";
		String dbPassword = "syntaxhrm123";
		// jdbc:driver type:hostname:port/db name
		String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
		
		// jdbc:driver type:hostname:port/db name

		String url="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
				
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword  );
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery("SELECT emp_lastname FROM hs_hr_employees");
		
		set.next();
		
	
		System.out.println(set.getString("emp_lastname"));
		
		System.out.println(	set.getRow());
		
		
	}

}
