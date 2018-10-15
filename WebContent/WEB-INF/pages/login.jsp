<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- 
  --	Login view that contains login form and redirects to the main view
  --	uses LoginModel to transfer data to UserController
  --
  --	Created by William Bierer & Brendan Brooks.
  -- 
  -->

<div class="row login-module-container">
<div class="col-md-1">
</div>
<div class="col-md-5 login-module">
<h1 id="module-head">Login</h1>
<div id="login-form">
<!-- Create login form that uses verify action from UserController  -->
<form:form method="POST" modelAttribute="login" action="verify">  <!-- login attribute linked with verify action form UserController -->
  <div class="form-group">
  	<div class="col-4">
  		<!-- Create email input with error validation  -->
		<form:label path="email">Email Address</form:label>
		<form:input class="form-control" type="email" path="email" /><form:errors path="email"/>
	 </div>
  </div>
  <div class="form-group">
  	<div class="col-4">
  		<!-- Create password input with error validation  -->
		<form:label path="password">Password</form:label>
		<form:password class="form-control" path="password" /><form:errors path="password"/>
	</div>
  </div>
	
	<!-- Create submit button for login form  -->
  <input type="submit" value="Submit" class="btn btn-orange" />
    <!-- Create href that directs to the register view  -->
	<div id="toRegisterForm"><p><a href="register">Don't have an account?</a></p></div>
</form:form>
</div>

</div>

</div>

<div class="col-md-4 login-module-right">
<spring:url value="/assets/images/MusiCloud.png" var="MusiCloudLogo" />
<img src="${MusiCloudLogo}" alt="MusiCloud Logo" class="center" width="175" height="175">
<h1><i>MusiCloud</i></h1>
</div>


