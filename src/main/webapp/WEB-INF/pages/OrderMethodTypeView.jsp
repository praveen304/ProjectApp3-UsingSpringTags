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

<h2 style="color:red;text-align:center">WELCOME TO ORDER METHOD TYPE VIEW PAGE</h2>
  <table border="1">
       <tr><th> ID </th><td> ${ob.id } </td></tr>
       <tr><th> MODE </th><td> ${ob.orderMode }  </td></tr>
       <tr><th> CODE </th><td> ${ob.orderCode}  </td></tr>
       <tr><th> TYPE </th><td> ${ob.orderType }  </td></tr>
       <tr><th> ACCEPT </th><td> ${ob.orderAcpt }  </td></tr>
       <tr><th> Description </th><td> ${ob.orderDesc }  </td></tr>
     
  </table><br><br>
  <a href="excel?id=${ob.id}"><img src="../resources/images/excel.png" width="100" height="100"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="pdf?id=${ob.id}"><img src="../resources/images/pdf.jpg" width="100" height="100"/></a>
</body>
</html>