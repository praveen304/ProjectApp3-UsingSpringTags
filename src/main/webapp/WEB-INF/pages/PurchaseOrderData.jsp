<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;text-align:center">WELCOME PURCHASE ORDER DATA PAGE</h2>
   <c:choose>
      <c:when test="${!empty list }">
         <table border="1" style="text-align: center"> 
            
            <tr >
               <th>ID</th>
               <th>ORDER-CODE</th>
               <th>SHIPMENT-CODE</th>
               <th>VENDOR</th>
               <th>RefNUMBER</th>
               <th>QNTY-CHECK</th>
               <th>STATUS</th>
               <th>DESCRIPTION</th>
               <th colspan="3">OPERATION</th>
               <c:forEach items="${list }" var="ob"> 
             <tr>
               <td>${ob.pid }</td>
               <td>${ob.orderCode }</td>
               <td>${ob.shipmentOb.shipCode }</td>
               <td>${ob.vendorOb.userId  }</td>
               <td>${ob.refNum }</td>
               <td>${ob.qntyCheck }</td>
               <td>${ob.defaultStatus }</td>
               <td>${ob.desc }</td>    
               <td><a href="delete?pid=${ob.pid }"><img src="../resources/images/delete.jpg" width="40" height="40"/></a> &nbsp;&nbsp;&nbsp;&nbsp;  
               <a href="edit?pid=${ob.pid }"><img src="../resources/images/edit.jpg" width="40" height="40"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
               <a href="view?pid=${ob.pid }"><img src="../resources/images/view.png" width="40" height="40"/></a></td>
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