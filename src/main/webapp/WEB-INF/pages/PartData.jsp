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

<h2 style="color:red;text-align:center">WELCOME PART DATA PAGE</h2>
   <c:choose>
      <c:when test="${!empty list }">
         <table border="1" style="text-align: center"> 
            
            <tr >
               <th>ID</th>
               <th>CODE</th>
               <th>WIDTH</th>
               <th>LENGTH</th>
               <th>HEIGHT</th>
               <th>COST</th>
               <th>CURRENCY</th>
               <th>UOM</th>
               <th>SALE</th>
               <th>PURCHASE</th>
               <th>DESCRIPTION</th>
               <th colspan="3">OPERATION</th>
               <c:forEach items="${list }" var="ob"> 
             <tr>
               <td>${ob.partId }</td>
               <td>${ob.partCode }</td>
               <td>${ob.partWidth }</td>
               <td>${ob.partlength }</td>
               <td>${ob.partHeight }</td>
               <td>${ob.partBaseCost }</td>
               <td>${ob.baseCurrency }</td>
               <td>${ob.partUmo }</td>
               <td>${ob.partSale }</td>
               <td>${ob.partPurchase }</td>
               <td>${ob.partDesc }</td>    
               <td><a href="delete?pid=${ob.partId }"><img src="../resources/images/delete.jpg" width="40" height="40"/></a> &nbsp;&nbsp;&nbsp;&nbsp;  
               <a href="edit?pid=${ob.partId }"><img src="../resources/images/edit.jpg" width="40" height="40"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
               <a href="view?pid=${ob.partId }"><img src="../resources/images/view.png" width="40" height="40"/></a></td>
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