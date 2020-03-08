<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;text-align:center">WELCOME TO  SALE VIEW PAGE</h2>
  <table border="1">
       <tr><th> ID </th><td> ${ob.grnid } </td></tr>
       <tr><th> GRN-CODE </th><td> ${ob.grnCode }  </td></tr>
       <tr><th> GRN-TYPE </th><td> ${ob.grnType}  </td></tr>
       <tr><th> ORDER-CODE </th><td> ${ob.orderCode }  </td></tr>
       <tr><th> DESCRIPTION </th><td> ${ob.grnDesc }  </td></tr>
  </table><br><br>
  <a href="excel?pid=${ob.grnid}"><img src="../resources/images/excel.png" width="100" height="100"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="pdf?pid=${ob.grnid}"><img src="../resources/images/pdf.jpg" width="100" height="100"/></a>

</body>
</html>