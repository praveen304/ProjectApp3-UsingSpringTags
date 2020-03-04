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

<h2 style="color:red;text-align:center">WELCOME TO  PART VIEW PAGE</h2>
  <table border="1">
       <tr><th> ID </th><td> ${ob.partId } </td></tr>
       <tr><th> CODE </th><td> ${ob.partCode }  </td></tr>
       <tr><th> WIDTH </th><td> ${ob.partWidth}  </td></tr>
       <tr><th> LENGTH </th><td> ${ob.partlength }  </td></tr>
       <tr><th> HEIGHT </th><td> ${ob.partHeight }  </td></tr>
       <tr><th> COST </th><td> ${ob.partBaseCost }  </td></tr>
       <tr><th> CURRENCY </th><td> ${ob.baseCurrency }  </td></tr>
       <tr><th> UOM </th><td> ${ob.partUmo }  </td></tr>
       <tr><th> SALE </th><td> ${ob.partSale }  </td></tr>
       <tr><th> PURCHASE </th><td> ${ob.partPurchase }  </td></tr>
       <tr><th> NOTE </th><td> ${ob.partDesc }  </td></tr>
  </table><br><br>
  <a href="excel?pid=${ob.partId}"><img src="../resources/images/excel.png" width="100" height="100"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="pdf?pid=${ob.partId}"><img src="../resources/images/pdf.jpg" width="100" height="100"/></a>

</body>
</html>