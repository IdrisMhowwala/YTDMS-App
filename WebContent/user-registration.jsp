<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="static/css/group-style.css">
<link
	href="https://fonts.googleapis.com/css?family=Raleway&display=swap"
	rel="stylesheet">
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	data-auto-a11y="true"></script>
<title>YTDMS APP</title>
</head>
<body>
	
	<!--header-->
	<jsp:include page="includes/groupHeader.jsp" />
	<!--MAIN-->
	<div class="container">
		<div id="main-section">
		<h1 class="display-4">User Registration</h1>
			<hr>

			<form action="UserRegistrationController" method="post">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="exampleInputName1">Name</label> <input type="name"
							class="form-control" id="exampleInputName1"
							placeholder="Enter name" name="name">
					</div>
					<div class="form-group col-md-6">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter email"
							name="email">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password" name="password">
					</div>
					<div class="form-group col-md-6">
						<label class="mr-sm-2" for="inlineFormCustomSelect">Group
							Names</label> <select name="groupId" class="custom-select mr-sm-2"
							id="inlineFormCustomSelect">
							<c:forEach items="${groups}" var="group">
								<option value="${group.id}"><a class="dropdown-item"
										href="#" style="color: black"> <c:out
											value="${group.name}" /></a>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<button type="submit" class="btn btn-primary" value="submit">Submit</button>
			</form>
	
		</div>
	</div>

	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>