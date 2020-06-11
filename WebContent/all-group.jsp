<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="static/css/group-style.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	data-auto-a11y="true"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="static/js/ytdms_code.js"></script>
<title>YTDMS APP</title>


</head>
<body>
	<!--header-->
	<jsp:include page="includes/groupHeader.jsp" />

	<!--MAIN-->
	<div class="container">
		<div id="main-section">
			<div class="group-section">
				<h3>List of groups</h3>
				<br>
				<table class="table table-bordered table-hover">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Group Name</th>
							<th scope="col">Description</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${groups}" var="group">
							<tr>
								<td><c:out value="${group.name}" /></td>
								<td><c:out value="${group.description}" /></td>
								<!-- ACCORDIAN -->
								<td>
									<div class="accordion" id="accordionExample${group.id}">
										<div class="card">
											<div class="card-header" id="headingOne">
												<h5 class="mb-0">
													<a href="ShowTraineeListController?id=${group.id}">
														<button class="btn btn-warning btn-sm collapsed"
															type="button" data-toggle="collapse"
															data-target="#collapseOne${group.id}"
															aria-expanded="true"
															aria-controls="#collapseOne${group.id}">Show</button> <a
														class="btn btn-primary btn-sm" data-toggle="collapse"
														href="#collapseOne${group.id}" role="button"
														aria-expanded="false"
														aria-controls="collapseOne${group.id}"> <i
															class="fa fa-times" aria-hidden="true"></i>
													</a>

													</a>
												</h5>
											</div>
											<div id="collapseOne${group.id}" aria-labelledby="headingOne"
												data-parent="#accordionExample${group.id}">
												<div class="card-body">
													<c:set var="idOfGroup" scope="session" value="${group.id}" />
													<c:set var="idOfAccordian" scope="session"
														value='<%=session.getAttribute("idOfAccordian")%>' />

													<c:if test="${idOfGroup == idOfAccordian}">

														<table>
															<c:forEach items="${user}" var="traineeNames">
																<tr>
																	<td><h6>
																			<c:out
																				value="${fn:toUpperCase(traineeNames.getName())}"></c:out>

																			<div class="dropdown">
																				<button class="btn btn-secondary dropdown-toggle"
																					type="button" id="dropdownMenuButton"
																					data-toggle="dropdown" aria-haspopup="true"
																					aria-expanded="false">Assign Group</button>
																				<div class="dropdown-menu"
																					aria-labelledby="dropdownMenuButton">
																					<c:forEach items="${groups}" var="group">
																						<a class="dropdown-item"
																							href="UpdateGroupController?idOfGroup=${group.id}&idOfTrainee=${traineeNames.getId()}">
																							<c:out value="${group.name}" />
																						</a>
																					</c:forEach>

																				</div>
																			</div>

																		</h6></td>
																</tr>

															</c:forEach>
														</table>

													</c:if>
												</div>
											</div>
										</div>
									</div>

								</td>
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
