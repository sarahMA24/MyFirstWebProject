package MSP;


	import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


	@WebServlet("/InsertStudentServlet")
	public class InsertStudentServlet extends HttpServlet {
		public static final String DB_URLTOCONNECT ="jdbc:mysql://localhost:3306/secondproject_db";
		public static final String DB_USERNAME ="root";
		public static final String DB_PASS="";
		static private Connection dbCon;
		static private String qry;
		static private PreparedStatement preparedStatement;
		private static final long serialVersionUID = 1L;


		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			String name = request.getParameter("name");
		
			String theclass = request.getParameter("class_item");
			
			
			if (name.equals("")||theclass.equals("class"))
			{
				
				
				out.println("<script type=\"text/javascript\">"); 
				out.println("alert('Please fill all the fields');"); 
				out.println("location='GetClassesCreateStudent';"); 
				out.println("</script>"); 

				
			}
			else {
				try {
					
						Class.forName("com.mysql.cj.jdbc.Driver");
						dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASS);
						System.out.println("connected successfully");
						qry = "insert into student (`sname`, `cname`) VALUES (?,?)";

						preparedStatement = dbCon.prepareStatement(qry);

						preparedStatement.setString(1, name);

						
						preparedStatement.setString(2, theclass);
						
						
						if(preparedStatement.executeUpdate() > 0)
							System.out.println("student inserted successfully");
				
						
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			 
			 
			
		}

	}