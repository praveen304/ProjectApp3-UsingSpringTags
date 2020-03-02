<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 style="color:red;text-align:center">WELCOME TO UOM TYPE VIEW PAGE</h2>
  <table border="1">
       <tr><th> ID </th><td>${ob.uomId}</td></tr>
       <tr><th> TYPE </th><td>${ob.uType}</td></tr>
       <tr><th> MODEL </th><td>${ob.uomModel}</td></tr>
       <tr><th> DESCRIPTION </th><td>${ob.uomDesc}</td></tr>
     
  </table><br><br>
  <a href="excel?uid=${ob.uomId}"><img src="../resources/images/excel.png" width="100" height="100"/></a>&nbsp;&nbsp;||&nbsp;&nbsp;
  <a href="pdf?uid=${ob.uomId}"><img src="../resources/images/pdf.jpg" width="100" height="100"/></a>
</body>
</html>