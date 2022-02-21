package practice;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class HWMeta {
	
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	
	@Test
	public void metaResult() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM hs_hr_employees");
		
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		int columnCount = rsmd.getColumnCount();
		
		for (int i = 1; i < columnCount; i++) {
			System.out.println(rsmd.getColumnName(i));
		}
		
		//ilgili column a girilen verilerin data type ini veriyor
		System.out.println(rsmd.getColumnClassName(1));

		
		
		
		System.out.println(rsmd.getColumnTypeName(9));
		
		System.out.println(rsmd.getTableName(5));

	}

}
