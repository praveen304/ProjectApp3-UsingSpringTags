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
<h2 style="color:red;text-align:center">WELCOME TO  PURCHASE ORDER VIEW PAGE</h2>
  <table border="1">
       <tr><th> ID </th><td> ${ob.pid } </td></tr>
       <tr><th> ORDER-CODE </th><td> ${ob.orderCode }  </td></tr>
       <tr><th> SHIPMENT-CODE </th><td> ${ob.shipmentOb.shipCode}  </td></tr>
       <tr><th> VENDOR </th><td> ${ob.vendorOb.userId }  </td></tr>
       <tr><th> RefNUMBER </th><td> ${ob.refNum }  </td></tr>
       <tr><th> QUNTATY-CHECK </th><td> ${ob.qntyCheck }  </td></tr>
       <tr><th> STATUS </th><td> ${ob.defaultStatus }  </td></tr>
       <tr><th> DESCRIPTION </th><td> ${ob.desc }  </td></tr>
  </table><br><br>
  <a href="excel?pid=${ob.pid}"><img src="../resources/images/excel.png" width="100" height="100"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="pdf?pid=${ob.pid}"><img src="../resources/images/pdf.jpg" width="100" height="100"/></a>

</body>
</html>