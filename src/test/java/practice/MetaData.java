package practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.openqa.selenium.support.ui.Select;

public class MetaData {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void dbMeta() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData = conn.getMetaData();
		String driverName = dbMetaData.getDriverName();
		String dbVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println(driverName);
		System.out.println(dbVersion);
	}

	@Test
	public void rsMeta() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees where emp_number = 14688");
		ResultSetMetaData rsMetadata = rs.getMetaData();
		int columnCount= rsMetadata.getColumnCount();
		System.out.println(columnCount);
		// column index starts from 1
		String columnName = rsMetadata.getColumnName(1);
		System.out.println(columnName);
		
		for (int i = 1; i <= columnCount; i++) {
			String columNames = rsMetadata.getColumnName(i);
			System.out.println(columNames);
		}
	}
}
