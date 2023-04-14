<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>View Coupon</title>
<meta charset="utf-8">
<meta name="generator" content=
  "HTML Tidy for Windows (vers 14 February 2006), see www.w3.org">

  
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

<table class="table table-hover">
<tbody>
      <tr>
      <th><span>帳號</span></th>
       <th><span>春遊券</span></th>
       <th><span>夏遊券</span></th>
       <th><span>秋遊券</span></th>
       <th><span>冬遊券</span></th>
       <th><span>已選項目</span></th>      
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
        </tbody>
    </table>
    </div>
</body>
</html>
 
