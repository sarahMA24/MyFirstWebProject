<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Teacher or Subject or Class</title>
 <link rel="stylesheet" href="styl.css">

</head>
 <div class="topnav">
  <a class="active" href="administrator.jsp">Home</a>
  <a href="AddTeacherSubjectClass">Add New Class or Teacher or Subject</a>
  <a href="TeacherClassSubjectReservationServlet">Insert a Subject For a Specific Class With a Specific Teacher</a>
  <a href="StudentToClassServlet">Add Student For a Specific Class</a>
    <a href="Display.jsp">Report</a>
    </div>
<body style="background-color:#FEFCF3">
<div align=center>
<form method="POST" action="AddTeacherSubjectClass">
<tr><td> Subject Name:</td><td><input type = text name=txtSName placeholder="Enter a Subject name"></td></tr>
<tr><td><input type=submit value="Add Subject"></td></tr>
<br></br>
<tr><td> Class Name:</td><td><input type = text name=txtCName placeholder="Enter a Class name"></td></tr>
<tr><td><input type=submit value="Add Class"></td></tr>
<br></br>
<tr><td> Teacher Name:</td><td><input type = text name=txtTName placeholder="Enter a Teacher name"></td></tr>
<tr><td><input type=submit value="Add Teacher"></td></tr>
<br></br>
<td><input type=reset></td></tr>
</form>
	
	<br></br>
</div>
<div align=center>

</div>
</body>
</html>