<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="static/css/group-style.css">
<title>Create Group</title>
</head>
<body>
	<!--header-->
		<jsp:include page="includes/groupHeader.jsp" />
	<div id="main-section">
		<div class="container">
			<div class="col-sm-6">
				<div class="card text-center card-form" id="form-card">
				<small id="errMsg" class="form-text text-danger">${param.successMsg}</small>
					<div class="card-body">
						<h1>Create Group</h1>
						<p>Create your own group with custom information</p>
						<form action="CreateGroup" method="post">
							<div class="form-group">
								<input type="text" class="form-control form-control-sm"
									placeholder="Enter Name" name="name" required="true">
							</div>
							<div class="form-group">
								<input type="text" class="form-control form-control-sm"
									placeholder="Enter Description" name="description">
							</div>

							<div class="form-group">
								<input type="text" class="form-control form-control-sm"
									placeholder="Enter Start Date(DD/MM/YYYY)" name="start_date">
							</div>
							<div class="form-group">
								<input type="text" class="form-control form-control-sm"
									placeholder="Enter End Date(DD/MM/YYYY)" name="end_date">
							</div>	
							<!-- Status Toggle -->
							<div class="btn-group btn-group-toggle" data-toggle="buttons" id="status-toggler">
							<div class="form-group">
								<input type="text" class="form-control form-control-sm "
									placeholder="Select Status" id="status-value" readonly>
							</div>	
								<label class="btn btn-secondary active" id="option1-lable"> 
								<input	type="radio" name="status" id="option1" autocomplete="off" value="1" checked> Active	
								</label> 
								<label class="btn btn-secondary" id="option2-lable"> 
								<input type="radio"	name="status" id="option2" autocomplete="off" value="2"> Deactive
								</label> 							
							</div>							
							<input type="submit" value="Create"
								class="btn btn-outline-light btn-block" id="create-btn">
						</form>
					</div>
				</div>
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