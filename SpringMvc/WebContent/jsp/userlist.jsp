<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/DemoWeb/css/header.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>

<div class="header">
	<div class="content">
		<!-- <h3>Registration Form</h3>	 -->
	</div>
</div>

<h2>User List </h2>
	
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">User Name</th>
      <th scope="col">Email</th>
      <th scope="col">PhoneNumber</th>
      <th scope="col">Address</th>
      <th scope="col">Update</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="userlist" items="${userList}">
	<tr>
	
			<td>
  				${userlist.id}
  			</td>
  			<td>
  				${userlist.username}
  			</td>
  			<td>
  				${userlist.email}
  			</td>
  			<td>
  				${userlist.phoneNumber}
  			</td>
  			<td>
  				${userlist.address}
  			</td>
  			<td>
  				<a href="${pageContext.request.contextPath}/update.obj?id=${userlist.id}">Update</a>
  			</td>
  			<td>
  				 <a href="${pageContext.request.contextPath}/showlist.obj?id=${userlist.id}&username=${userlist.username}&email=${userlist.email}&phonenumber=${phonenumber}&address=${userlist.address}&action=Delete" onClick="return confirm('Are you sure you want to delete this user.')">Delete</a> 
  				 
  			</td>
	
	</tr>
	
    </c:forEach> 
  </tbody>
</table>	
    
</body>
</html>