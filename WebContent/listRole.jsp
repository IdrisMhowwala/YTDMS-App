<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>YTDMS</title>
<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" href="static/css/style.css">
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	data-auto-a11y="true"></script>
</head>
<body>

	<!--header-->
	<jsp:include page="includes/AdminMenu.jsp" />
	<div id="main-section">
		<div class="container bgcontainer">
			<div class="row">
				<div class="col-md-4 heading">
					<div class="register-form ">
						<h1>Roles</h1>
					</div>
				</div>


				<div class="col-md-8">
					<div class="register-form ">
						<table class="table table-striped table-bordered table-hover center">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Sr.No.</th>
									<th scope="col">Role Name</th>
									<th scope="col">Assigned Permissions</th>
								</tr>
							</thead>
							
								<c:forEach items="${roles}" var="role">
									<tbody>
											<td><c:out value="${role.id}"></c:out></td>
										
											<td><c:out value="${role.name}"></c:out></td>
											
											<td><a href="PermissionByRoleController?roleId=${role.id}">See Permissions</a></td>
										
										</tbody>
								</c:forEach>
							
						</table>


					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
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
</html>