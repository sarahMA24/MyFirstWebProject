

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="MSP.Classes"%>
 <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<form action="InsertStudentServlet">
<input type="text" placeholder="first and last name" name="name">

<!--<input type="text" placeholder="grade" name="grade">  -->

<select name="class_item">
<option value="class">class</option>
 <%
 ArrayList<Classes> classesslist =(ArrayList<Classes>)request.getAttribute("classesList");
        for(Classes c:classesslist){%>
        <%-- Arranging data in tabular form
        --%>
            <option value ="<%=c.getClasses()%>"><%=c.getClasses() %></option>
               
            <%}%>
</select>


<input type="submit" value="submit">
</form>
</body>
</html>

