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
<h2 style="color:red;text-align:center">WELCOME TO  PURCHASE ORDER REGISTER PAGE</h2>
  <form:form action="save" method="POST" modelAttribute="PurchaseOrder">
   <pre>
     
     Order Code::<form:input path="orderCode"/>
     
     Shipment Code::<form:select path="shipCode">
			           <form:option value="">--select--</form:option>
			           <form:option value="NA">NA</form:option>
			       </form:select>
	
	 Vendor::<form:select path="vendor">
			           <form:option value="">--select--</form:option>
			           <form:option value="NA">NA</form:option>
			       </form:select>
			       
     Reference Number::<form:input path="refNum"/>
     
     Quantity Check::<form:radiobutton path="qntyCheck" value="Required"/>Required
	                 <form:radiobutton path="qntyCheck" value="Not-Required"/>Not-Required 
     
     
     Default Status::<form:input path="defaultStatus"/>
     
     Description::<form:textarea path="desc" ></form:textarea>  
                
                
            <input type="submit" value="PLACE ORDER"> 
   </pre>
  </form:form>
</body>
</html>