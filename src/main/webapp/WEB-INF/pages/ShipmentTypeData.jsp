<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false" %>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <h2 style="color:red;text-align:center">WELCOME SHIPMENT TYPE DATA PAGE</h2><br>
   <c:choose>
      <c:when test="${!empty list }">
         <table border="1" style="text-align: center"> 
            
            <tr >
               <th>ID</th>
               <th>MODE</th>
               <th>CODE</th>
               <th>ENABLE</th>
               <th>GREAD</th>
               <th>DESCRIPTION</th>
               <th>OPERATION</th>
               <c:forEach items="${list }" var="ob"> 
             <tr>
               <td>${ob.shipId }</td>
               <td>${ob.shipMode }</td>
               <td>${ob.shipCode }</td>
               <td>${ob.enbShip }</td>
               <td>${ob.shipGrade }</td>
               <td>${ob.shipDesc }</td>
               <td><a href="delete?sid=${ob.shipId }"><img src="../resources/images/delete.jpg" width="40" height="40"/></a> &nbsp;&nbsp;&nbsp;&nbsp;  
               <a href="edit?sid=${ob.shipId }"><img src="../resources/images/edit.jpg" width="40" height="40"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
               <a href="view?sid=${ob.shipId }"><img src="../resources/images/view.png" width="40" height="40"/></a></td>
            </tr>
           </c:forEach>          
         </table><br><br>
         <a href="excel"><img src="../resources/images/excel.png" width="100" height="100"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
         <a href="pdf"><img src="../resources/images/pdf.jpg" width="100" height="100"/></a>
      </c:when>
      <c:otherwise>
           <h2 style="color:blue;text-align:center">NO DATA FOUND!!</h2>
      </c:otherwise>
   </c:choose>
   
</body>
</html>