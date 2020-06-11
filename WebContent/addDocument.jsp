<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
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

	<div id="add-main-section" >

		<div class="dark-overlay">
			
			<div class="container home-inner">
			<h1 id=section-name class="display-4">Create Document</h1>
			<hr/>
				<div class="row">

					<div class="col-lg-12 ">
						<div class="card bg-dark">
							<div class="card-body">

								
								<form action="AddDocumentController" method="post">
									<div class="form-group">
										<label for="title">Document Title</label> <input
											pattern=".{3,20}"
											title="The Document title length Should be between 3-20 "
											type="text" class="form-control"
											placeholder=" Enter Document Title" name="title" id="title">
									</div>

									<div class="form-group">
										<label for="content">Data</label>
										<textarea class="form-control" rows="8" id="content"
											name="content"></textarea>
									</div>
									<div class="text-center">
										<input type="submit" value="save" class="btn btn-primary"
											id="save-btn">
									</div>

								</form>
								<script type="text/javascript">
									CKEDITOR.replace('content');
								</script>


							</div>
						</div>
					</div>
			</div>

			</div>

		</div>
		</header>
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