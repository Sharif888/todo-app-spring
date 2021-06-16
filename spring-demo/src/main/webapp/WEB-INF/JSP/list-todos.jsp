<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="container">
		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead >
				<tr class="text-primary">
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr class="text-info">
						<td >${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td>${todo.done}</td>
						<td class="btn btn-info"><a href="/update-todo?id=${todo.id }">Update</a></td>
						<td class="btn btn-warning"><a href="/delete-todo?id=${todo.id}">DELETE</a></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div> <a  class="button" href="/add-todo">Add a Todo</a></div>

			<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>