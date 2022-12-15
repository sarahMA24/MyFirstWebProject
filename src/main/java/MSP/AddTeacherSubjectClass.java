package MSP;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/AddTeacherSubjectClass")

public class AddTeacherSubjectClass extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/secondproject_db";

	public static final String DB_USERNAME = "root";

	public static final String DB_PASSWORD = "";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

			RequestDispatcher rd = request.getRequestDispatcher("subjects.jsp");
			
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

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PrintWriter out = resp.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
			String s = req.getParameter("txtSName");
			String c = req.getParameter("txtCName");
			String t = req.getParameter("txtTName");


			String sqlStatment1 = "INSERT INTO `subject`(`sname`) VALUES ('" + s + "')";
			String sqlStatment2 = "INSERT INTO `classes`(`cname`) VALUES ('" + c + "')";
			String sqlStatment3 = "INSERT INTO `teacher`(`tname`) VALUES ('" + t + "')";

			Statement statement = con.createStatement();
			

			int rs1 = statement.executeUpdate(sqlStatment1);
			int rs2 = statement.executeUpdate(sqlStatment2);
			int rs3 = statement.executeUpdate(sqlStatment3);


			if (rs1 >= 1 || rs2>=1 || rs3>=1) {

				RequestDispatcher rd = req.getRequestDispatcher("subjects.jsp");// يوديه للولكم بيج
				rd.forward(req, resp);

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
