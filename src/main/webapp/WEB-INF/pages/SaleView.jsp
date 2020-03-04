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
       <tr><th> ID </th><td> ${ob.saleId } </td></tr>
       <tr><th> ORDER-CODE </th><td> ${ob.orderCode }  </td></tr>
       <tr><th> SHIPMENT-CODE </th><td> ${ob.shipCode}  </td></tr>
       <tr><th> CUSTOMER </th><td> ${ob.customer }  </td></tr>
       <tr><th> Ref-NUMBER </th><td> ${ob.refNumber }  </td></tr>
       <tr><th> STOCK-MODE </th><td> ${ob.stokeMode }  </td></tr>
       <tr><th> STOCK-SOURCE </th><td> ${ob.stokeSource }  </td></tr>
       <tr><th> DEFAULT-STATUS </th><td> ${ob.dfltStatus }  </td></tr>
       <tr><th> NOTE </th><td> ${ob.saleDesc }  </td></tr>
  </table><br><br>
  <a href="excel?pid=${ob.saleId}"><img src="../resources/images/excel.png" width="100" height="100"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="pdf?pid=${ob.saleId}"><img src="../resources/images/pdf.jpg" width="100" height="100"/></a>

</body>
</html>