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

<link rel="stylesheet" href="static/css/categoryStyle.css">
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	data-auto-a11y="true"></script>
<title>YTDMS APP</title>
</head>
<body>
	<!--header-->
	<jsp:include page="includes/header.jsp" />

	<!--MAIN-->
	<div class="container">

		<div id="main-section">
			
			<div id="addCategoryForm">
				

				<form action="AddCategoryController" >
				<header><p class="display-4">Add Category<p><hr></header>
					<div class="form-group col-md-6">
						<label for="testName">Name</label> 
						<input type="text" class="form-control" id="Name" name="name" />
						<small id="errMsg" class="form-text text-danger">
						<%if(request.getAttribute("nameErrorMessage")!=null){out.println(request.getAttribute("nameErrorMessage"));} %>
						</small>
					</div>
					<div class="form-group col-md-6">
						<label for="testName">Description</label> 
						<textarea rows="" cols="" class="form-control" id="Description" name="description"></textarea>
						<small id="errMsg" class="form-text text-danger">
						<%if(request.getAttribute("descriptionErrorMessage")!=null){out.println(request.getAttribute("descriptionErrorMessage"));} %>
						</small>
					</div>
					<div class="form-group col-md-6" >
					<input type="submit" value="Add category" class="btn btn-primary"/>
					</div>
				</form>				
			</div>

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