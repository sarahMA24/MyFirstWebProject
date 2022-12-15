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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/secondproject_db";

	public static final String DB_USERNAME = "root";

	public static final String DB_PASSWORD = "";
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(DB_URLTOCONNECT,DB_USERNAME,DB_PASSWORD);
			String n=request.getParameter("txtName");//txtName is the txtbox name
			String p=request.getParameter("txtPwd");//txtPassword is the txtbox name
			String sqlStatment="select uname from login where uname =? and password=?";
			PreparedStatement ps=con.prepareStatement(sqlStatment);
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd=request.getRequestDispatcher("administrator.jsp");
				rd.forward(request, response);
			}else {
				out.println("<font color=red size=18>Login Faild!<br>");
				out.println("<a href=login.jsp>Try AGAIN!!</a>");//go back to login page 
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
