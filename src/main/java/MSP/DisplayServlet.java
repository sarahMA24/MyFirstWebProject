package MSP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;        
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/secondproject_db";

	public static final String DB_USERNAME = "root";

	public static final String DB_PASSWORD = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);

			String sqlStatmentTeacher = "select *  from teacher";
			String sqlStatmentClass = "select *  from classes";
			String sqlStatmentSubject = "select *  from subject";


			PreparedStatement psTeacher = con.prepareStatement(sqlStatmentTeacher);
			PreparedStatement psClasses = con.prepareStatement(sqlStatmentClass);
			PreparedStatement psSubject = con.prepareStatement(sqlStatmentSubject);

			RequestDispatcher rd = request.getRequestDispatcher("Display.jsp");
			
			ResultSet rsTeacher = psTeacher.executeQuery();
			ResultSet rsClass = psClasses.executeQuery();
			ResultSet rsSubject = psSubject.executeQuery();

			request.setAttribute("rsTeacher", rsTeacher);
			request.setAttribute("rsClass", rsClass);
			request.setAttribute("rsSubject", rsSubject);

			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
