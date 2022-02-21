package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemoPostGres {

	String username = "postgres";
	String password = "password";
	String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
	// String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void run() throws SQLException {
		Connection con = DriverManager.getConnection(dbURL, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT title FROM film");
		rs.next();
		rs.next();

		String title = rs.getString("title");
		System.out.println(title);
	}
}
