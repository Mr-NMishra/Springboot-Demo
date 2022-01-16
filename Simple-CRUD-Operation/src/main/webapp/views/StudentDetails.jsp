<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
	<h3>Student Details</h3>
	<hr>
	<hr>
	<pre>
	Roll No : "${student.rno}"
	Name : "${student.name}"
	Mobile : "${student.mobile}"
	Address : "${student.address}"
</pre>
	<hr>
	<hr>
	<a href="/">Home</a><br>
	<a href="ViewForm">Add new Student</a>
</body>
</html>