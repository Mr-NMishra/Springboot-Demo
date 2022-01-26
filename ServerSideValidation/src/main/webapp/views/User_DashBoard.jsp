<%@page import="com.mishra.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="springTag"%>
<% User user=(User)request.getAttribute("user"); %>
<!DOCTYPE html>
<html xmlns:th="http://thymeleaf.org" lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
		<td>ID</td>
		<td>Name</td>
		<td>Email</td>
		<td>Role</td>
		<td>Enable</td>
		<td>Image</td>
		<td>About</td>
		<td>Contacts</td>
	</tr>
	<tr>
		<th><%= user.getId() %></th>
		<th><%= user.getName() %></th>
		<th><%= user.getEmail() %></th>
		<th><%= user.getRole() %></th>
		<th><%= user.isEnable() %></th>
		<th><%= user.getImageUrl() %></th>
		<th><%= user.getAbout() %></th>
		<th><%= user.getContacts()%></th>
		
	</tr>
	
	</table>
</body>
</html>