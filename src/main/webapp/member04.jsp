<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>View Member</title>

   <meta charset="utf-8">
  <meta name="generator" content=
  "HTML Tidy for Windows (vers 14 February 2006), see www.w3.org">
  
  
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>
<table class="table table-hover">

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
 
