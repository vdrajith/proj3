package crudmvn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SampleTest {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ajith");
		System.out.println(con);
		return con;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = SampleTest.getConnection();
		System.out.println(con);

	}

}
