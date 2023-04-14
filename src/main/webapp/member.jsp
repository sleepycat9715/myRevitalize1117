<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Member</title>
</head>
<body>
<table border="1" width="70%">
      <tr>
      <th>Member ID</th>
      <th>Member Name</th>
      <th>Password</th>
      <th>E-mail</th>
      <th>Cell</th>
     
            
      </tr>
        <c:forEach  var="current"  items="${members}" >
        <tr>
          <td><c:out value="${current.sid}" /></td>
          <td><c:out value="${current.sname}" /></td>
          <td><c:out value="${current.password}" /></td>
          <td><c:out value="${current.email}" /></td>
          <td><c:out value="${current.cell}" /></td>                       
        </tr>
      </c:forEach>
    </table>
</body>
</html>
 
