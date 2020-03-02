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

<h2 style="color:red;text-align:center">WELCOME TO SHIPMENT TYPE VIEW PAGE</h2>
  <table border="1">
       <tr><th> ID </th><td> ${ob.shipId } </td></tr>
       <tr><th> MODE </th><td> ${ob.shipMode }  </td></tr>
       <tr><th> CODE </th><td> ${ob.shipCode}  </td></tr>
       <tr><th> ENABLE </th><td> ${ob.enbShip }  </td></tr>
       <tr><th> GRADE </th><td> ${ob.shipGrade }  </td></tr>
       <tr><th> Description </th><td> ${ob.shipDesc }  </td></tr>
     
  </table><br><br>
  <a href="excel?sid=${ob.shipId}"><img src="../resources/images/excel.png" width="100" height="100"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="pdf?sid=${ob.shipId}"><img src="../resources/images/pdf.jpg" width="100" height="100"/></a>
</body>
</html>