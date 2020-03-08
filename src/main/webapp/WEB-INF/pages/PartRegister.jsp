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
   
   Base Currency::<form:select path="baseCurrency">
			           <form:option value="">--select--</form:option>
			           <form:option value="INR">INR</form:option>
			           <form:option value="DOLLAR">DOLLAR</form:option>
			           <form:option value="POUND">POUND</form:option>
			       </form:select>
			       
   Uom:: <form:select path="uomOb.uomId">
			           <form:option value="">--select--</form:option>
			           <form:options items="${uomMap}"/>
			       </form:select>
			       
   Order Method Code  
                     Sale::<form:select path="omSaleOb.id" class="form-control">
                            <form:option value="">-SELECT-</form:option>
                            <form:options items="${omSaleMap}" />
                         </form:select>
                         
                 Purchase::<form:select path="omPurchaseOb.id" class="form-control">
                            <form:option value="">-SELECT-</form:option>
                            <form:options items="${omPurchaseMap}" />
                         </form:select>
                     
    Description::<form:textarea path="partDesc" ></form:textarea>  
                
                
            <input type="submit" value="CREATE PART">  
   </pre>
  </form:form>
</body>
</html>