<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;text-align:center">WELCOME TO UOM TYPE REGISTER PAGE</h2>
  <form:form action="save" method="POST" modelAttribute="uomType">
   <pre>
    UOM Type::<form:select path="uType">
	                     <form:option value="">--select--</form:option>
	                     <form:option value="Packing">Packing</form:option>
	                     <form:option value="No Packing">No Packing</form:option>
	                     <form:option value="">--NA--</form:option>
	                  </form:select>
	                  
    UOM Model::<form:input path="uomModel"/>
                               
    Description::<form:textarea path="uomDesc" ></form:textarea>  
                
                
            <input type="submit" value="CREATE UOM">            
  
  </pre>
 </form:form>
</body>
</html>