<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.mishra.entities.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page isELIgnored="false" %>
<!DOCTYPE html>
<%
List<Student> studentList = (List<Student>) request.getAttribute("savedStudentList");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Saved Student Details</h3>
	<hr>
	<table border="1">
		<tr>
			<th>Roll No.</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Address</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
		<%
		for (Student student : studentList) {
		%>
		<tr>
			<td><%=student.getRno()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getMobile()%></td>
			<td><%=student.getAddress()%></td>
			<td align="center" ><a href="deleteStudent?id=<%=student.getRno() %>" >[X]</a> </td>
			<td align="center"><a href="">Update</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<hr>

</body>
</html>