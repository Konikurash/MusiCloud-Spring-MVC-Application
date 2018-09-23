<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="row login-module-container">
<div class="col-md-1">
</div>
<div class="col-md-5 login-module">
<h1>Login</h1>
<div id="login-form">
<form:form method="POST" modelAttribute="user" action="loginUser">
  <div class="form-group">
  	<div class="col-4">
		<form:label path="email">Email Address</form:label>
		<form:input class="form-control" type="email" path="email" />
	 </div>
  </div>
  <div class="form-group">
  	<div class="col-4">
		<form:label path="password">Password</form:label>
		<form:password class="form-control" path="password" />
	</div>
  </div>

  <input type="submit" value="Submit" class="btn btn-orange" />
	<form:errors path="*" />
	<div id="toRegisterForm"><p><a href="javascript:void(0)">Don't have an account?</a></p></div>
</form:form>
</div>
<div id="registration-form" style="display: none;">
<form:form method="POST" modelAttribute="user" action="registerUser">
  <div class="form-group">
  	<div class="col-4">
		<form:label path="email">First Name</form:label>
		<form:input class="form-control" path="firstName" />
		<form:label path="email">Last Name</form:label>
		<form:input class="form-control" path="lastName" />
	 </div>
  </div>
  <div class="form-group">
  	<div class="col-4">
		<form:label path="email">Email Address</form:label>
		<form:input class="form-control" type="email" path="email" />
	 </div>
  </div>
  <div class="form-group">
  	<div class="col-4">
		<form:label path="password">Password</form:label>
		<form:password class="form-control" path="password" />
	</div>
  </div>
  <div class="form-group">
  	<div class="col-4">
		<form:label path="passwordConfirmation">Confirm Password</form:label>
		<form:password class="form-control" path="passwordConfirmation" />
	</div>
  </div>

  <input type="submit" value="Submit" class="btn btn-orange" />
	<form:errors path="*" />
	<p id="toLoginForm"><a href="javascript:void(0)">Return to login</a></p>
</form:form>
</div>

</div>

<div class="col-md-4 login-module-right">
<spring:url value="/assets/images/MusiCloud.png" var="MusiCloudLogo" />
<img src="${MusiCloudLogo}" alt="MusiCloud Logo" class="center" width="200" height="200">
<h1><i>MusiCloud</i></h1>
</div>
</div>


