<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Page</title>
<link rel="stylesheet" href="styl.css">
</head>
<div class="topnav">
  <a class="active" href="administrator.jsp">Home</a>
  <a href="AddTeacherSubjectClass">Add New Class or Teacher or Subject</a>
  <a href="TeacherClassSubjectReservationServlet">Insert a Subject For a Specific Class With a Specific Teacher</a>
  <a href="StudentToClassServlet">Add Student For a Specific Class</a>
    <a href="Display.jsp">Report</a>
    </div>
<body style="background-color:#FEFCF3";>

	<%
	String id = request.getParameter("userId");
	String driverName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/secondproject_db";
	//String dbName = "jsptutorials";
	String userId = "root";
	String password = "";

	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSetClass = null;
	connection = DriverManager.getConnection(connectionUrl , userId, password);
	statement = connection.createStatement();
	/* ResultSet resultSetTeacher = null;
	ResultSet resultSetSubject = null; */
	%>
	<h2 align="center">
		<font><strong>The Report</strong></font>
	</h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
		<tr bgcolor="DBA39A">
			<th>Classes</th>
			
		</tr>
		<%
		try {
			
			String sqlClass = "SELECT * FROM classes";
			/* String sqlTeacher = "SELECT * FROM teacher";
			String sqlSubject = "SELECT * FROM subject"; */

			resultSetClass = statement.executeQuery(sqlClass);

			/* resultSetTeacher = statement.executeQuery(sqlTeacher);

			resultSetSubject = statement.executeQuery(sqlSubject);
 */			
			%>
			<tr bgcolor="F0DBDB">
			<%
			while (resultSetClass.next()) {
		%>
			<tr>
			<td><%=resultSetClass.getString("cname")%></td>
			</tr>
			
		
		<%
			}
		%>
		</table>
		
		<%

		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
		
		<table align="center" cellpadding="5" cellspacing="5" border="1">
		<tr bgcolor="DBA39A">
			<th>Teachers</th>
			
		</tr>
		<%
		try {
			
			String sqlTeacher = "SELECT * FROM teacher";
			/* String sqlTeacher = "SELECT * FROM teacher";
			String sqlSubject = "SELECT * FROM subject"; */

			ResultSet resultSetTeacher = statement.executeQuery(sqlTeacher);

			/* resultSetTeacher = statement.executeQuery(sqlTeacher);

			resultSetSubject = statement.executeQuery(sqlSubject);
 */			
			%>
			<tr bgcolor="F0DBDB">
			<%
			while (resultSetTeacher.next()) {
		%>
			<tr>
			<td><%=resultSetTeacher.getString("tname")%></td>
			</tr>
			
		
		<%
			}
		%>
		</table>
		
		<%

		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
		
		<table align="center" cellpadding="5" cellspacing="5" border="1">
		<tr bgcolor="DBA39A">
			<th>Subjects</th>
			
		</tr>
		<%
		try {
			
			String sqlTeacher = "SELECT * FROM subject";
			/* String sqlTeacher = "SELECT * FROM teacher";
			String sqlSubject = "SELECT * FROM subject"; */

			ResultSet resultSetTeacher = statement.executeQuery(sqlTeacher);

			/* resultSetTeacher = statement.executeQuery(sqlTeacher);

			resultSetSubject = statement.executeQuery(sqlSubject);
 */			
			%>
			<tr bgcolor="F0DBDB">
			<%
			while (resultSetTeacher.next()) {
		%>
			<tr>
			<td><%=resultSetTeacher.getString("sname")%></td>
			</tr>
			
		
		<%
			}
		%>
		</table>
		
		<%

		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
		
</body>
</html>