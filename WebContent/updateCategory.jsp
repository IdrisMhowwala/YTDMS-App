<%@page import="com.yash.ytdms.domain.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Edit Category</title>
<link rel="stylesheet" href="static/css/categoryStyle.css">
</head>
<body>
	<%
		String name = (String) request.getAttribute("categoryName");
		String description = (String) request.getAttribute("categoryDescription");
	%>
	<jsp:include page="includes/header.jsp"></jsp:include>
	<div class="container">
		<div id="main">
			<form action="EditCategoryController" method="post">
				<p class="display-4">Edit Category</p><hr>

				<div class="form-group">
					<label for="name">Name</label> <input type="text"
						class="form-control col-md-6" id="name" name="name" placeholder="${categoryName}"
						value="<%=name%>" required /> 
						<small id="errMsg" class="form-text text-danger">${param.nameErrMsg} </small>
				</div>
				<div class="form-group">
					<label for="description">Description</label>
					<textarea name="description" class="form-control col-md-6" placeholder="${categoryDescription}" required><%=description%></textarea>
					<small id="errMsg" class="form-text text-danger">${param.descErrMsg} </small>
				</div>
				<button type="submit" class="btn btn-primary">Edit Category</button>
			</form>

		</div>
	</div>







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

	<jsp:include page="includes/footer.jsp"></jsp:include>

</body>
</html>
