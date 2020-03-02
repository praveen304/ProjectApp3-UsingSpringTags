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

	<h2 style="color: red; text-align: center">WELCOME TO SHIPMENT
		TYPE EDIT PAGE</h2>

	<form:form action="update" method="POST" modelAttribute="OrderMethodType">
		<pre>
       id::<form:input path="id" readonly="true" />  
       
        Order Mode::<form:radiobutton path="orderMode" value="SALE" />SALE
	            <form:radiobutton path="orderMode" value="PURCHASE" />PURCHASE
	            
    Order Code::<form:input path="orderCode" />
                 
    Order Type:: <form:select path="orderType">
			           <form:option value="">--select--</form:option>
			           <form:option value="FIFO">FIFO</form:option>
			           <form:option value="LIFO">LIFO</form:option>
			           <form:option value="FCFO">FCFO</form:option>
			           <form:option value="FEFO">FEFO</form:option>
			       </form:select>
			      
    Order Accept::<form:checkbox path="orderAcpt" value="Multi-Model" />Multi-Model
                 <form:checkbox path="orderAcpt" value="Accept Return" />Accept Return
                 
    Description::<form:textarea path="OrderDesc"></form:textarea>  
                
                
            <input type="submit" value="UPDATE">            
  
   </pre>
	</form:form>
</body>
</html>