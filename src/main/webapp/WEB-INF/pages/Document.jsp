<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 style="color:red;text-align:center">WELCOME TO DOCUMENT PAGE</h2>
<form action="upload" method="POST" enctype="multipart/form-data">
  <pre>
     ID::<input type="text" name="fileId">
     Document::<input type="file" name="fileOb">
     
           <input type="submit" value="Upload">
  </pre>
</form>
   <table border="1">
       <tr>
          <th>ID</th>
          <th>NAME</th>
          <th>LINK</th>
       </tr>
       <c:forEach items="${list}" var="ob">
           <tr>
              <td>${ob[0]}</td>
              <td>${ob[1]}</td>
              <td><a href="download?fid=${ob[0]}">DOWNLOAD</a></td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>