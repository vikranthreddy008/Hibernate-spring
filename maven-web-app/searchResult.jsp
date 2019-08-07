<%@page import="com.lti.model.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Search Result</title>
</head>
<body>
<%
	Account acc = (Account) session.getAttribute("account");
%>
<h1>Search Result</h1>
Acno : <%= acc.getId() %> <br />
Name : <%= acc.getName() %> <br />
Date of Birth : <%= acc.getDateOfBirth() %> <br />
Balance : <%= acc.getBalance() %> <br />

<br /><br />
<a href="AccountPDFServlet">Click here</a> to download a PDF copy!
</body>
</html>