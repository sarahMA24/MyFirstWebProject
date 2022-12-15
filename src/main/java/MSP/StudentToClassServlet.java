package MSP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentToClassServlet
 */
@WebServlet("/StudentToClassServlet")
public class StudentToClassServlet extends HttpServlet {
	public static final String DB_URLTOCONNECT ="jdbc:mysql://localhost:3306/secondproject_db";
	public static final String DB_USERNAME ="root";
	public static final String DB_PASS="";
	static private Connection dbCon;
	static private String qry;
	static private Statement theStatement;
	static private ResultSet resultset;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		List <Classes> classes= new ArrayList();


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASS);
			System.out.println("connected successfully");
			qry = "select * from classes";
			theStatement = dbCon.createStatement();
			resultset = theStatement.executeQuery(qry);
			while(resultset.next()) {
				Classes c = new Classes(resultset.getString("cname"));
				classes.add(c);
			}	

			request.setAttribute("classesList", classes);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertStudent.jsp");
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
}