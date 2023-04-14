<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Coupon</title>
</head>
<body>
<table border="1" width="70%">
      <tr>
      <th>Coupon ID</th>
      <th>Coupon 01</th>
      <th>Coupon 02</th>
      <th>Coupon 03</th>
      <th>Coupon 04</th>
      <th>Coupon sum</th>     
            
      </tr>
        <c:forEach  var="current"  items="${coupons}" >
        <tr>
          <td><c:out value="${current.memid}" /></td>
          <td><c:out value="${current.type01}" /></td>
          <td><c:out value="${current.type02}" /></td>
          <td><c:out value="${current.type03}" /></td>
          <td><c:out value="${current.type04}" /></td>
          <td><c:out value="${current.sum}" /></td>                       
        </tr>
      </c:forEach>
    </table>
</body>
</html>
 
