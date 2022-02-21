package practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class KDPractice {

	static String username = "postgres";
	static String password = "password";
	static String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";

//	@Test
	public void aconnectionAndRS() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, username, password);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from film");

		// bir sonraki row a geciyor
		// rs.next();
		
		

		List<String> list = new ArrayList<>();
		while (rs.next()) {
			String title = rs.getObject("title").toString();
			list.add(title);
			System.out.println(rs.getRow());

		}
		System.out.println(list.size());
		System.out.println(list);
	}

//	@Test
	public void bdbMeta() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, username, password);
		Statement st = conn.createStatement();
		DatabaseMetaData dbmt = conn.getMetaData();
		System.out.println(dbmt.getDriverName());
		System.out.println(dbmt.getDatabaseProductVersion());

	}

//	@Test
	public void crsMeta() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, username, password);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from film");

		ResultSetMetaData rsmd = rs.getMetaData();

		// Table dan herhangi bir index girerek table in adini retrieve edebilirsin
		System.out.println(rsmd.getTableName(5));

		// table daki column sayisi icin
		rsmd.getColumnCount();

		// table daki herhangi bir column un adi icin
		// rsmd.getColumnName(columnIndex);

		// prints the type of value in cell in a particular column
		System.out.println(rsmd.getColumnClassName(3));

		for (int i = 1; i < rsmd.getColumnCount(); i++) {
			System.out.println(rsmd.getColumnName(i));
		}

		// retrieves the current row number
		// rs.getRow();

	}

//	@Test
	public void methods() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, username, password);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from film");
		ResultSetMetaData rsmd = rs.getMetaData();

		/*
		 * rs.next(); -- next row rs.getMetaData(); -- meta data for resultset
		 * rs.getObject(columnIndex).toString(); -- herhangi bir clumnda cell e ait
		 * degeri cikariyor
		 * 
		 */

		/*
		 * rsmd.getColumnCount(); -- num of columns rsmd.getColumnName(int column) -- name
		 * of clumn rsmd.getTableName(int column) -- table name
		 * rsmd.getColumnClassName(int column) -- column Java type
		 * 
		 * 
		 */
		

	}

	@Test
	public void dstoreDataInMap() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, username, password);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select title,length from film");

		ResultSetMetaData rsmd = rs.getMetaData();

		List<Map<String, String>> listMap = new ArrayList<>();

		while (rs.next()) {
			Map<String, String> map = new LinkedHashMap<>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				map.put(rsmd.getColumnName(i), rs.getObject(i).toString());
			}

			listMap.add(map);

		}

		System.out.println(listMap);

	}

}
