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
<link rel="stylesheet" href="static/css/style.css">
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	data-auto-a11y="true"></script>
<title>YTDMS APP</title>
</head>
<body>
	<!--header-->
	<jsp:include page="includes/documentMenu.jsp" />

	<!--MAIN-->
  <div class="container">
 
    <div id="main-section">
    <h1 id=section-name class="display-4">Trash List</h1>
    <hr/>
			<div id="document-main-section">
             
                    <div class="row">
                      <div class="col-12">
                        <table class="table table-responsive">
                       <thead class="thead-dark" >
                                         <tr>
                                                <th id="serial-column" scope="col">S.no</th>
                                                <th id="category-column" scope="col">Document name</th>
                                                <th id="action-column" scope="col">Actions</th>
                                         </tr>
                         </thead >
                          <tbody class="table-bordered">
                          <% int count =1; %>
                          		<c:forEach items="${documents}" var="document">
                         
                                  <tr>
                                  <th id="serial-column" scope="row" ><%= count++ %></th>
                                  <td id="document-column"><strong><c:out value="${document.title}"/></strong></td>
                                  <td id="action-column">
                                         <button type="button" class="btn btn-success" data-toggle="tooltip" data-placement="bottom" title="Restore"
                                         onclick="location.href ='RestoreDocumentController?id=${document.id}';">
                                                <i class="fas fa-trash-restore"></i>
                                         </button>
                                         <button type="button" class="btn btn-danger " data-toggle="tooltip" data-placement="bottom" title="delete" onclick="location.href ='RemoveDocumentTrashController?id=${document.id}';">
                                                <i class="far fa-trash-alt"></i>
                                         </button>
                                  </td>
                           </tr>
                            </c:forEach>
                          </tbody>
                        </table>
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