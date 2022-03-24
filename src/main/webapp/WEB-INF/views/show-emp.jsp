<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Employee Details</h1>
	<h2 align="center">
		Empno: ${employee.empno }<br>
		Ename: ${employee.ename }<br>
		Job:   ${employee.job }<br>
		Mgr:  ${employee.mgr }<br>
		Hiredate: ${employee.hiredate }<br>
		Salary: ${employee.sal }<br>
		Commission: ${employee.comm }<br>
		Deptno: ${employee.deptno }	
	</h2>
</body>
</html>