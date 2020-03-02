<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false" %>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h2 style="color:red;text-align:center">WELCOME TO SHIPMENT TYPE REGISTER PAGE</h2>
  <form:form action="save" method="POST" modelAttribute="shipmentType">
   <pre
  style="border=1;text-align=center">
    Shipment Mode::<form:select path="shipMode">
	                     <form:option value="">--select--</form:option>
	                     <form:option value="Air">Air</form:option>
	                     <form:option value="Truck">Truck</form:option>
	                     <form:option value="Ship">Ship</form:option>
	                     <form:option value="Train">Train</form:option>
	                  </form:select>
	                  
    Shipment Code::<form:input path="shipCode"/>
                 
    Enable Shipment:: <form:select path="enbShip">
			           <form:option value="">--select--</form:option>
			           <form:option value="Yes">Yes</form:option>
			           <form:option value="No">No</form:option>
			       </form:select>
			      
    Shipment Grade:: <form:radiobutton path="shipGrade" value="A"/>A
                  <form:radiobutton path="shipGrade" value="B"/>B
                  <form:radiobutton path="shipGrade" value="C"/>C
                 
    Description::<form:textarea path="shipDesc" ></form:textarea>  
                
                
            <input type="submit" value="CREATE SHIPMENT">            
  
  </pre>
 </form:form>
</body>
</html>