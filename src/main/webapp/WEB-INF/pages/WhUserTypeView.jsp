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
<h2 style="color:red;text-align:center">WELCOME TO WH-USER TYPE VIEW PAGE</h2>
  <table border="1">
       <tr><th> ID </th><td> ${ob.userId } </td></tr>
       <tr><th> TYPE </th><td> ${ob.userType }  </td></tr>
       <tr><th> CODE </th><td> ${ob.userCode}  </td></tr>
       <tr><th> USER-FOR </th><td> ${ob.userFor }  </td></tr>
       <tr><th> MAIL </th><td> ${ob.mail }  </td></tr>
       <tr><th> Contact </th><td> ${ob.contact }  </td></tr>
       <tr><th> ID-TYPE </th><td> ${ob.userIdType }  </td></tr>
       <tr><th> OTHER </th><td> ${ob.ifOther }  </td></tr>
       <tr><th> ID-NUMBER </th><td> ${ob.idNumber }  </td></tr>
  </table><br><br>
  <a href="excel?whid=${ob.userId}"><img src="../resources/images/excel.png" width="100" height="100"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="pdf?whid=${ob.userId}"><img src="../resources/images/pdf.jpg" width="100" height="100"/></a>
</body>
</html>