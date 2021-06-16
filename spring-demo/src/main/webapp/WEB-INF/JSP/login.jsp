<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><font color="red">${errorMsg }</font></h1>
<form action="/login" method="post">
First Name: <input type="text" name="name">
<br>
Password: <input type="password" name="password">
<br>
<button type="submit" value="submit">Submit</button>
</form>
</body>
</html>