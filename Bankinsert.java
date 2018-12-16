package crudmvn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bankinsert
 */
public class Bankinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection con = SampleTest.getConnection();
			System.out.println(con);

			// response.getWriter().append("Served at: ").append(request.getContextPath());
			PrintWriter w = response.getWriter();
			String name = request.getParameter("name");
			w.println(name);
			Integer age = Integer.parseInt(request.getParameter("age"));
			Integer mobile_number = Integer.parseInt(request.getParameter("mobile_number"));
			Integer account_number = Integer.parseInt(request.getParameter("account_number"));
			System.out.println("inserting...");
			String query = "insert into passbookes values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setInt(3, mobile_number);
			ps.setInt(4, account_number);
			int i = ps.executeUpdate();
			System.out.println("inserted" + i);
			w.println("inserted");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}