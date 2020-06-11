<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="com.yash.ytdms.domain.*"%>
<%@ page import="com.yash.ytdms.util.*"%>
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


<script type="text/javascript">
$(document).ready(function() {
       $('[data-toggle="tooltip"]').tooltip();  
})
</script>





<!-- FOR POPPER AND TOOLTIP -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>




</head>
<body>
	<!--header-->
	<jsp:include page="includes/header.jsp" />

	<!--MAIN-->
	<div class="container">
		<div id="category_section" style="margin-top: 0px;">
			<h1 class="display-4">List Category</h1>
			<hr>

			<br> <a href="add-category.jsp" class="btn btn-primary">ADD
				CATEGORY</a><br><br>
			<table class="table table-hover table-responsive align-center ">
				<thead class="thead-dark">
					<tr>
						<th scope="col-1">S.No</th>
						<th scope="col-2">Name</th>
						<th scope="col-3">Description</th>
						<th scope="col-2">Creation Date</th>

						<th scope="col-2">Permission Status</th>
						<th scope="col-2">Operation</th>
						<!--  	<td>Activity</td> -->
					</tr>
				</thead>
				<tbody class="table-bordered ">
					<%
						int count = 1;
					%>
					<c:forEach items="${categories}" var="category">
						<tr>
							<td scope="row">
								<%
									out.println(count);
										count++;
								%>
							</td>

							<td> <a href="DisplaySectionListController?categoryId=${category.id}"><c:out value="${category.name}" /></a> </td>
							<td><c:out value="${category.description}"/></td>
							<td><c:out value="${category.creation_date}" /></td>

							<td><c:if test="${category.permission_status ==1}">
									<c:out value="APPROVED" />
								</c:if> <c:if test="${category.permission_status ==2}">
									<c:out value="PENDING" />
								</c:if> 
								<c:if test="${category.permission_status ==3}">
                                         <a data-toggle="tooltip" title="${category.rejectionMessage }">REJECTED</a>
                                         
                                 </c:if>
                                         </td>

							<td><c:if test="${category.permission_status ==1}">
									<a href="#" class="disabled btn btn-primary btn-sm">Edit</a>
									<a href="#" class="btn btn-danger btn-sm disabled">Delete</a>
								</c:if> <c:if test="${category.permission_status ==2}">
									<a href="edit?id=${category.id}" class="btn btn-primary btn-sm">Edit</a>
									<a href="delete?id=${category.id}"
										class="btn btn-danger btn-sm">Delete</a>
								</c:if> <c:if test="${category.permission_status ==3}">
									<a href="edit?id=${category.id}" class="btn btn-primary btn-sm">Edit</a>
									<a href="delete?id=${category.id}"
										class="btn btn-danger btn-sm">Delete</a>
								</c:if> <c:choose>

									<c:when test="${category.permission_status ==2}">

										<a href="" class="btn btn-primary btn-sm disabled"
											type="submit">Publish</a>

									</c:when>
									<c:when test="${category.permission_status ==3}">
								<a href="" class="btn btn-primary btn-sm disabled"
										type="submit">Publish</a>
								</c:when>


									<c:otherwise>
										<c:if test="${category.visibility_status ==1}">
											<a
												href="VisibilityStatusController?id=${category.id}&visibilityStatus=${category.visibility_status}"
												class="btn btn-primary btn-sm">Publish</a>
										</c:if>

										<c:if test="${category.visibility_status ==2}">
											<a
												href="VisibilityStatusController?id=${category.id}&visibilityStatus=${category.visibility_status}"
												class="btn btn-primary btn-sm">Block</a>
										</c:if>
									</c:otherwise>

								</c:choose></td>

							<!--  <td><input type="radio" name="activity" value="active">
						Active<br> <input type="radio" name="activity" value="block">
						Block<br></td>
						-->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- button -->

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