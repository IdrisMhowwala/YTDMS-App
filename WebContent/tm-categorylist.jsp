<%@page import="com.yash.ytdms.domain.Category"%>
<%@page import="java.util.List"%>
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
<link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
<link rel="stylesheet" href="static/css/categoryStyle.css">
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	data-auto-a11y="true"></script>
<title>YTDMS APP</title>
</head>
<body>
	<!--header-->
	<jsp:include page="includes/header.jsp" />

	<%
		List<Category> categories = (List<Category>) session.getAttribute("tmCategories");
	%>
	<!--MAIN-->
	<div class="container">
		<div id="addTestForm">
		<h1 class="display-4">Category List</h1>
		<hr>
			<table class="table table-hover table-responsive ">
				<thead class="thead-dark">
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Name</th>
						<th scope="col">Description</th>
						<th scope="col">Due Date</th>
						<th scope="col">Permission Status</th>
					</tr>
				</thead>

				<%
					int count = 1;
				%>
				<c:forEach items="${sessionScope.tmCategories}" var="category">
					<tr>
						<td scope="row">
							<%
								out.println(count);
									count++;
							%>
						</td>

						<td><c:out value="${category.name}" /></td>
						<td><c:out value="${category.description}"></c:out></td>
						<td><c:out value="${category.creation_date}" /></td>
						<td><c:choose>
								<c:when test="${category.permission_status ==1}">
									<div>
										<c:out value="APPROVED" />
									</div>
								</c:when>
								<c:when test="${category.permission_status ==3}">
									<div>
										<c:out value="REJECTED" />
									</div>
								</c:when>
								<c:otherwise>
									<a href="ApproveCategoryController?id=${category.id}"
										class="btn btn-primary btn-sm">Approve</a>
									<button type="button" class="btn btn-danger btn-sm"
										data-toggle="modal" data-target="#rejectModal">Reject</button>


									<!--REJECTION MESSAGE MODAL -->
									<div class="modal fade" id="rejectModal" tabindex="-1"
										role="dialog" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Rejection
														Reason</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<form action="RejectCategoryController">
														<div class="form-group">
															<textarea name="rejectionMessage" class="form-control"
																rows="3"></textarea>
														</div>

														<div class="form-group">
															<input type="hidden" name="id" value="${category.id}">
														</div>


														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Close</button>
															<input type="submit" class="btn btn-primary" value="Save">
														</div>
													</form>

												</div>

											</div>
										</div>
									</div>

								</c:otherwise>
							</c:choose></td>

					</tr>
				</c:forEach>


			</table>




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