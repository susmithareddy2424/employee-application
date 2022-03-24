<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2 align="center">Employee List</h2>

		<table class="table">
			<thead>
				<tr>					
					<th>Empno</th>
					<th>Ename</th>
					<th>Job</th>
					<th>Mgr</th>
					<th>Hiredate</th>
					<th>Salary</th>										
					<th>Commission</th>
					<th>Deptno</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
			    <%-- <c:forEach> is a jstl core tag that iterates through a list --%>
				<%-- we are able to iterate through an arraylist
				     using jstl tag without writing any Java code --%>
				<c:forEach var="e" items="${employeeList}">
					<tr class="success">						
						<td>${e.empno}</td>
						<td>${e.ename}</td>
						<td>${e.job}</td>
						<td>${e.mgr}</td>
						<td>${e.hiredate}</td>	
						<td>${e.sal}</td>	
						<td>${e.comm}</td>
						<td>${e.deptno}</td>						
						<td><a href="edit-emp?id=${e.empno}">edit</a></td>
						<td><a href="delete-emp?id=${e.empno}">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>