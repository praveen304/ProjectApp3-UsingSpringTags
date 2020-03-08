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
<h2 style="color:red;text-align:center">WELCOME TO  GRN REGISTER PAGE</h2>
  <form:form action="save" method="POST" modelAttribute="Grn">
   <pre>
   
   Grn Code::<form:input path="grnCode"/>
   
   Grn Type::<form:input path="grnType"/>
   
   Order Code::<form:select path="orderCode">
			           <form:option value="">--select--</form:option>
			           <form:option value="NA">NA</form:option>
			       </form:select>
			       
    Description::<form:textarea path="grnDesc"></form:textarea>  
                
                
            <input type="submit" value="CREATE GRN">  
   </pre>
   </form:form>
   
</body>
</html>