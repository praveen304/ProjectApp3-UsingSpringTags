<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" isErrorPage="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 style="color:red;text-align:center">WELCOME TO WH-USER REGISTER PAGE</h2>

  <form:form action="save" method="POST" modelAttribute="whUserType">
   <pre>
    User Type::<form:radiobutton path="userType" value="Vendor"/>Vendor
	           <form:radiobutton path="userType" value="Customer"/>Customer 
	               
    User Code::<form:input path="userCode"/>
                 
    User For::<form:input path="userFor"/>
                 
			      
    User Mail::<form:input path="mail"/>
                 
    User Contact::<form:input path="contact"/>  
        
    User ID Type::<form:select path="userIdType">
	                     <form:option value="">--select--</form:option>
	                     <form:option value="PAN Card">PAN Card</form:option>
	                     <form:option value="Aadhar Card">Aadhar Card</form:option>
	                     <form:option value="Voter Card">Voter Card</form:option>
	                     <form:option value="Other">Other</form:option>
	                  </form:select>        
          *If Other:: <form:input path="ifOther"/> 
    
    ID Number::<form:input path="idNumber"/> 
    
            <input type="submit" value="CREATE USER">            
  
  </pre>
 </form:form>
</body>
</html>