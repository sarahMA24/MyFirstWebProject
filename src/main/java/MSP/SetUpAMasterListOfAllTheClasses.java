package MSP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetUpAMasterListOfAllTheClasses
 */
@WebServlet("/SetUpAMasterListOfAllTheClasses")
public class SetUpAMasterListOfAllTheClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/secondproject_db";

	public static final String DB_USERNAME = "root";

	public static final String DB_PASSWORD = "";
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(DB_URLTOCONNECT,DB_USERNAME,DB_PASSWORD);

			String sqlStatment="select class  from list_stc";

			PreparedStatement ps=con.prepareStatement(sqlStatment);

			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				out.println(" class: " + rs.getString("class"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
