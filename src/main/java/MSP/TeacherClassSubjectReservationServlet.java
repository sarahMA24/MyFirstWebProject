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
 * Servlet implementation class TeacherClassSubjectReservationServlet
 */
@WebServlet("/TeacherClassSubjectReservationServlet")
public class TeacherClassSubjectReservationServlet extends HttpServlet {
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
		List <Teacher> teachers= new ArrayList();
		List <Subject> subjects= new ArrayList();
		List <Classes> classes= new ArrayList();


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASS);
			System.out.println("connected successfully");
			qry = "select * from teacher";
			theStatement = dbCon.createStatement();
			resultset = theStatement.executeQuery(qry);
			while(resultset.next()) {
				Teacher teacher = new Teacher(resultset.getString("tname"));
				teachers.add(teacher);
			}
			System.out.println(teachers);

			request.setAttribute("teachersList", teachers);

			qry = "select * from classes";
			resultset = theStatement.executeQuery(qry);
			while(resultset.next()) {
				Classes c = new Classes(resultset.getString("cname"));//cname is the col. name in table classes
				classes.add(c);
			}

			request.setAttribute("classesList", classes);
			qry = "select * from subject";
			resultset = theStatement.executeQuery(qry);
			while(resultset.next()) {
				Subject subject = new Subject(resultset.getString("sname"));
				subjects.add(subject);
			}

			request.setAttribute("subjectsList", subjects);//what is subject lis?
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Newschedule.jsp");
			dispatcher.forward(request, response);


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}



	}

}



