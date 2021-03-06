<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<h1> Add a todo</h1>
		<form:form method="post" modelAttribute="todo">
			<fieldset class="form-group">
		<form:hidden path="id"/>
				<form:label path="desc">Description</form:label> 
				<form:input path="desc" type="text"
					class="form-control" required="required"/>
			<form:errors path="desc"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
		
				<form:label path="targetDate">Description</form:label> 
				<form:input path="targetDate" type="text"
					class="form-control" required="required"/>
			<form:errors path="targetDate"></form:errors>
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
	<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script>
	$('#targetDate').datepicker({
		format : 'dd/mm/yyyy'
	});
	</script>
</body>
</html>