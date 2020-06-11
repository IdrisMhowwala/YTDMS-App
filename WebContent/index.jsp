<%
	//TODO :  this file must be used only for the home page redirection
	// No other code is excepted here apart from home page redirection
	String path =getServletContext().getContextPath().toString();
	System.out.println(path);
	response.sendRedirect(path+"/home.jsp");
%>