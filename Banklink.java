package crudmvn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Banklink extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		
	}

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		insert(con);
		
	}

	public static void insert(Connection con) throws SQLException {
		Bankpoj b1 = new Bankpoj();
		Scanner s = new Scanner(System.in);
		String query = "insert into passbook values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		System.out.println("enter your name,age,mobile_number,account_number");
		String bname = s.next();
		int bage = s.nextInt();
		int bmobile_number = s.nextInt();
		int baccount_number = s.nextInt();
		b1.setName(bname);
		b1.setAge(bage);
		b1.setMobile_number(bmobile_number);
		b1.setAccount_number(baccount_number);
		System.out.println("name is" + b1.getName() + "age is" + b1.getAge() + "mobile_number is"
				+ b1.getMobile_number() + "account_number is" + b1.getAccount_number());
		ps.setString(1, b1.getName());
		ps.setInt(2, b1.getAge());
		ps.setInt(3, b1.getMobile_number());
		ps.setInt(4, b1.getAccount_number());
		int executeUpdate = ps.executeUpdate();
		System.out.println("inserted");
		}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ajith");
		System.out.println(con);
		return con;
	}
}