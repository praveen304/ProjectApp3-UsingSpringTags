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
<h2 style="color:red;text-align:center">WELCOME TO  PART REGISTER PAGE</h2>
  <form:form action="save" method="POST" modelAttribute="Part">
   <pre>
   
   Code::<form:input path="partCode"/>
   
   Dimension
            Width::<form:input path="partWidth"/>
            Length::<form:input path="partlength"/>
            Height::<form:input path="partHeight"/>
                  
   Base Cost::<form:input path="partBaseCost"/>
   
   Base Currency::<form:input path="baseCurrency"/>
   
   Uom:: <form:select path="partUmo">
			           <form:option value="">--select--</form:option>
			           <form:option value="NA">NA</form:option>
			       </form:select>
			       
   Order Method Code  
                     sale::<form:input path="partSale"/>
                     Purchase::<form:input path="partPurchase"/>
                     
    Description::<form:textarea path="partDesc" ></form:textarea>  
                
                
            <input type="submit" value="CREATE PART">  
   </pre>
  </form:form>
</body>
</html>