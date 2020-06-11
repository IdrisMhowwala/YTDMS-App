
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
<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap2-toggle.min.js"
	rel="stylesheet">

<link rel="stylesheet" href="static/css/group-style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap2-toggle.min.css"></script>
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
			<div class="group-section">
				<h1 class="display-4">List of all Groups</h1>
				<hr>
				<table class="table table-bordered table-hover">
					<thead class="thead-dark thead-color">
						<tr>
							<th scope="col">Group Name</th>
							<th scope="col">Description</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${groups}" var="group">
							<tr>
								<c:choose>
									<c:when test="${group.status==2}">
										<td class="text-muted"><c:out value="${group.name}" /></td>
										<td class="text-muted"><c:out value="${group.description}"/></td>
						
									</c:when>
									<c:otherwise>
										<td><c:out value="${group.name}" /></td>
										<td><c:out value="${group.description}" /></td>
									
								   </c:otherwise>
								</c:choose>
								<td><a href="ShowTraineeListController?id=${group.id}"class="btn btn-success btn-sm p-1" role="button">Trainees 
									<i class="fa fa-eye"></i></a> 
									<a href="edit.jsp?id=${group.id}&name=${group.name}&description=${group.description}"class="btn btn-primary btn-sm p-1" role="button">Edit Group 
									<i class='fas fa-edit'></i></a> 
								
						
								<c:choose>
										<c:when test="${group.status==1}">
											<a	href="StatusController?id=${group.id}&status=${group.status}"
												class="btn btn-danger btn-sm p-1" role="button">Deactivate</a>
										</c:when>
										<c:when test="${group.status==2}">
											<a	href="StatusController?id=${group.id}&status=${group.status}"
												class="btn btn-success btn-sm p-1" role="button">Activate</a>
										</c:when>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
