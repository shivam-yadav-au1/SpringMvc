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
<link rel="stylesheet" type="text/css" href="/DemoWeb/css/form.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
</head>
<body>
<div class="header">
	<div class="content">
	
	</div>
</div>

<div class="container">
  <h2>Update User</h2>
  <form id="form" action="${pageContext.request.contextPath}/update.obj" name="updateuser">
  
  	 <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id" value="${user.id}">
    </div>
  	<div class="form-group">
      <label for="username">User Name:</label>
      <input type="text" class="form-control" id="username" placeholder="Enter Username" name="username" value="${user.username}">
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${user.email}">
    </div>
    <div class="form-group">
      <label for="phonenumber">Phone Number:</label>
      <input type="text" class="form-control" id="phonenumber" placeholder="Enter Phonenumber" name="phonenumber" value="${user.phoneNumber}">
    </div>
    
     <div class="form-group">
      <label for="address">Address:</label>
      <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address" value="${user.address}">
    </div>
  
    <input type="submit" class="btn btn-default" value="Update" name="action">
  </form>
</div>
<script type="text/javascript">
			$(function()
			{
				// Validation		
				$("#form").validate(
				{					
					// Rules for form validation
					rules:
					{
						username:
						{
							required: true
						},
						email:
						{
							required: true,
							email: true
						},
						phonenumber:
						{
							required:true,
							minlength:10,
							maxlength:10
						},
						address:
						{
							required:true
						}

					},
					
					// Messages for form validation
					messages:
					{
						username:
						{
							required:'Please enter your username'
						},
						phonenumber:
						{
							required:'Please enter your 10 digit phonenumber'
						},
						address:
						{
							required:'Please enter your address'
						},
						email:
						{
							required: 'Please enter your email address',
							email: 'Please enter a VALID email address'
						},
						phonenumber:
						{
							required:'Please enter your phonenumber'
						}
						
					},		
					
					
					
					// Do not change code below
				/*	errorPlacement: function(error, element)
					{
						error.insertAfter(element.parent());
					}*/
					
			        messages: {},
			        highlight: function (element) {
			            $(element).parent().addClass('error')
			        },
			        unhighlight: function (element) {
			            $(element).parent().removeClass('error')
			        }
			        

				});
			});			
		</script>


 	
</body>
</html>