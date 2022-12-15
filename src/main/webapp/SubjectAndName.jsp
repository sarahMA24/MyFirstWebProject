<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#FEFCF3">

<form action="list" method="post">
    Select a Teacher:&nbsp;
    <select name="category">
        <c:forEach items="${listSC}" var="category">
            <option value="${sn.}">${category.name}</option>
        </c:forEach>
    </select>
    <br/><br/>
    <input type="submit" value="Submit" />
</form>

</body
</html>
<html>ممسوووووووووح</html>