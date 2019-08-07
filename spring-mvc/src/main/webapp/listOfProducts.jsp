<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Products</title>
</head>
<body>
<c:forEach items="${ listOfProducts }" var="p">
ID : ${ p.id } <br>
Name :${ p.name } <br>
Price :${ p.price} <br>
Stock :${ p.stock } <br>
<hr>
</c:forEach>

</body>
</html>