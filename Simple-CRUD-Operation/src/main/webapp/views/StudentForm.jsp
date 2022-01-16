<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student-Details</title>
</head>
<body bgcolor="fefcb7">
	<h4>Student Details</h4>
	<hr>
	<hr>

	<form action="addStudent" method="get">
		<table align="center">
			<tr>
				<td>Roll No</td>
				<td><input type="text" name="rno"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="reset"><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>
	<hr>
	<hr>
</body>
</html>