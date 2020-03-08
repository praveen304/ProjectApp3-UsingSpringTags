<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 style="color:red;text-align:center">WELCOME TO UOM TYPE EDIT PAGE</h2>
  <form:form action="update" method="POST" modelAttribute="Uom">
   <pre>
  id::<form:input path="uomId" readonly="true"/>
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