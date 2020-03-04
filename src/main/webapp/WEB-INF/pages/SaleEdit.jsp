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
<h2 style="color:red;text-align:center">WELCOME TO  SALE REGISTER PAGE</h2>
  <form:form action="update" method="POST" modelAttribute="Sale">
   <pre>
   id::<form:input path="saleId" readonly="true" />  
    
   Order Code::<form:input path="orderCode"/>
   
   Shipment Code::<form:select path="shipCode">
			           <form:option value="">--select--</form:option>
			           <form:option value="NA">NA</form:option>
			       </form:select>
   
   Customer::<form:select path="customer">
			           <form:option value="">--select--</form:option>
			           <form:option value="NA">NA</form:option>
			       </form:select>
   
   Reference Number::<form:input path="refNumber"/>
   
   Stock Mode::<form:radiobutton path="stokeMode" value="Grade"/>Grade
	           <form:radiobutton path="stokeMode" value="Margin"/>Margin
   
   Stock Source::<form:select path="stokeSource">
			           <form:option value="">--select--</form:option>
			           <form:option value="Open">Open</form:option>
			           <form:option value="Avail">Avail</form:option>
			           <form:option value="Refund">Refund</form:option>
			       </form:select>
     
     Default Status::<form:input path="dfltStatus" value="SALE-OPEN" readonly="true"/>
     
      Description::<form:textarea path="saleDesc" ></form:textarea>  
                
                
            <input type="submit" value="Update">  
   </pre>
  </form:form>
</body>
</html>