<%@page import="com.mishra.helper.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="th"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>login-page</title>

</head>
<body>
<div class="card text-center" >

	<div class="card-header" >
		<ul class="nav nav-tabs card-header-tabs">
			<li class="nav-item"><a class="nav-link active" aria-current="true" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link active" aria-current="true" href="about">About</a></li>
			<li class="nav-item"><a class="nav-link active" aria-current="true" href="login">Login</a></li>
			<li class="nav-item"><a class="nav-link active" aria-current="true" href="signup">SignUp</a></li>
		</ul>
	</div>
</div>

	<div class="container">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
 			<%Message message =(Message)session.getAttribute("message"); 
 				if(message!=null){
 			%>
			<div class="alert alert-danger" role="alert" >
			<label ><%message.getContent();}%></label>  	
			</div>
				<th:form action="do-register" modelAttribute="user" methodParam="${ user}">
					<div class="mb-3">
						<label class="form-label">Name</label> <span> 
						<th:input
							type="text" name="name" class="form-control" path="name"
							value="${user.name }"
							aria-describedby="usernameHelp" />
						</span>
					</div>
					<div class="mb-3">
						<label class="form-label">email</label> 
						<th:input type="email" path="email"
							class="form-control" name="email" value="${user.email}"/>
					</div>

					<div class="mb-3">
						<label class="form-label">password</label> 
						<th:input type="password" path="password"
							class="form-control" name="password" />
					</div>


					<div class="mb-3">
						<label class="form-label">About</label>
						<textarea class="form-control" rows="3" name="about"  ></textarea>
					</div>

					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1"
							name="condition"> <label class="form-check-label"
							for="exampleCheck1">Agree to Terms & Condtitons</label>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="reset" class="btn btn-primary">Reset</button>
				</th:form>


			</div>
		</div>


	</div>

</body>
</html>