<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList"%>
<%@page import="MSP.Teacher"%>
<%@page import="MSP.Subject"%>
<%@page import="MSP.Classes"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Schedule</title>
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


<form action="InsertScheduleServlet">
<select name="teacher_item">
<option value="teacher_name">teacher name</option>
 <%
 ArrayList<Teacher> teacherslist =(ArrayList<Teacher>)request.getAttribute("teachersList");
        for(Teacher t:teacherslist){%>
        <%-- Arranging data in tabular form
        --%> 
            <option value ="<%=t.getTeacher() %>"><%=t.getTeacher() %></option>
               
            <%}%>
</select>

<select name="subject_item">
<option value="subject_name">subject</option>
 <%
 ArrayList<Subject> subjectslist =(ArrayList<Subject>)request.getAttribute("subjectsList");
        for(Subject s:subjectslist){%>
        <%-- Arranging data in tabular form
        --%>
            <option value ="<%=s.getSubject()%>"><%=s.getSubject()%></option>
               
            <%}%>
</select>
<select name="class_item">
<option value="class_name">class</option>
 <%
 ArrayList<Classes> classeslist =(ArrayList<Classes>)request.getAttribute("classesList");
        for(Classes c:classeslist){%>
        <%-- Arranging data in tabular form
        --%>
            <option value ="<%=c.getClasses()%>"><%=c.getClasses()%></option>
               
            <%}%>
</select>
<input type="submit" value="submit">
</form>
</body>
</html>
