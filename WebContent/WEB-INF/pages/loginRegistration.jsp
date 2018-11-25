<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="row login-module-container">
<div class="col-md-1">
</div>
<div align="center" class="col-md-5 login-module">
<h1 id="module-head">${head}</h1>
<div id="login-form" style="${logStyle}" class="login-form">
<form:form method="POST" modelAttribute="login" action="loginUser">
  <div class="form-group">
  	<div class="col-4 log-field">
		<form:label path="email">Email Address</form:label>
		<form:input class="form-control" type="email" path="email" />
	 </div>
	 <form:errors path="email"/>
  </div>
  <div class="form-group">
  	<div class="col-4 log-field log-field">
		<form:label path="password">Password</form:label>
		<form:password class="form-control" path="password" />
	</div>
	<form:errors path="password"/>
  </div>

  <input type="submit" value="Submit" class="btn btn-orange" />
	<div id="toRegisterForm"><p><a href="javascript:void(0)">Don't have an account?</a></p></div>
</form:form>

</div>
<div align="center" id="registration-form" style="${regStyle}" class="reg-form">
<form:form method="POST" modelAttribute="user" action="registerUser">
  <div class="form-group">
  <form:errors path="userExists"/>
  	<div class="col-4 log-field">
		<form:label path="firstName">First Name</form:label>
		<form:input class="form-control" path="firstName" />
	 </div>
	 <form:errors path="firstName"/>
  </div>
  <div class="form-group">
  	<div class="col-4 log-field">
		<form:label path="lastName">Last Name</form:label>
		<form:input class="form-control" path="lastName" />
  	</div>
  	<form:errors path="lastName"/>
  </div>
  <div class="form-group">
  	<div class="col-4 log-field">
		<form:label path="email">Email Address</form:label>
		<form:input class="form-control" type="email" path="email" />
	 </div>
	 <form:errors path="email"/>
  </div>
  <div class="form-group">
  	<div class="col-4 log-field">
		<form:label path="password">Password</form:label>
		<form:password class="form-control" path="password" />
	</div>
	<form:errors path="password"/>
  </div>
  <div class="form-group">
  	<div class="col-4 log-field">
		<form:label path="passwordConfirmation">Confirm Password</form:label>
		<form:password class="form-control" path="passwordConfirmation" />
	</div>
	<form:errors path="passwordConfirmation"/>
  </div>
  
  <input type="submit" value="Submit" class="btn btn-orange" />
	<p id="toLoginForm"><a href="javascript:void(0)">Return to login</a></p>
</form:form>
</div>

</div>

<div class="col-md-1"> </div>

<div align="center" class="col-md-2 login-module-right">
<spring:url value="/assets/images/MusiCloud.png" var="MusiCloudLogo" />
<img src="${MusiCloudLogo}" alt="MusiCloud Logo" class="center" width="200" height="200">
<h1><i>MusiCloud</i></h1>
</div>
</div>


