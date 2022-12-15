<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MSP.Classes"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#FEFCF3">
<div>
<form action="StudentToClassServlet" method=post>
<table>
<tr><td> Enter Student Name:</td><td><input type = text name=txtSName></td></tr>
<tr><td><input type=submit value=Add></td></tr>
<tr><td><select name="class_item">
<option value="class_name">class</option>
 <%
 ArrayList<Classes> classeslist =(ArrayList<Classes>)request.getAttribute("classesList");
        for(Classes c:classeslist){%>
        <%-- Arranging data in tabular form
        --%>
            <option value ="<%=c.getClasses()%>"><%=c.getClasses()%></option>
               
            <%}%>
</select>
</td></tr>
</table>
</form>
</div>
</body>
</html>