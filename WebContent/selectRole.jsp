<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" href="static/css/permissions.css">
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	data-auto-a11y="true"></script>
<title>YTDMS APP</title>
<style type="text/css">
th {
	text-align: center;
}

td {
	text-align: center;
}


</style>

</head>
<body>
	<!--header-->
	<jsp:include page="includes/AdminMenu.jsp" />

	<!--MAIN-->
	<div class="container overflow-auto">

		<div id="main-section">
		<div class="anyClass">

			<form class="form-inline" action="#">
				<input class="form-control mr-sm-2 d-block" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			<div id="errMsg"
				class="form-text text-danger text-center font-weight-bold">${param.msg}</div>
			<form class="form" action="PermissionsAssignController" method="post">
				<input type="hidden" name="moduleId" value="${moduleId}" /> <select
					class="custom-select mb-2" name="role">
					<option disabled selected>-- select an option --</option>
					<c:forEach items="${roles}" var="role">
						<option value="${role.id}"><c:out value="${role.name}" /></option>
					</c:forEach>
				</select>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">S. No.</th>
							<th scope="col">Select</th>
							<th scope="col">Permissions</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="0" scope="page" />
						<c:forEach items="${permissions}" var="permission">
							<c:set var="count" value="${count + 1}" scope="page" />
							<tr>
								<th>${count}</th>
								<td><input type="checkbox" name="permission"
									value="${permission.id}"></td>
								<td>${permission.name}</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="3"><input type="submit" value="Assign"
								class="align-middle btn btn-danger btn-lg"></td>
						</tr>
					</tbody>
				</table>
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