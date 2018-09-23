<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="row login-module-container">
<div class="col-md-1">
</div>
<div class="col-md-5 login-module">
<h1 id="module-head">Login</h1>
<div id="login-form">
<form:form method="POST" modelAttribute="user" action="verify">
  <div class="form-group">
  	<div class="col-4">
		<form:label path="email">Email Address</form:label>
		<form:input class="form-control" type="email" path="email" /><form:errors path="email"/>
	 </div>
  </div>
  <div class="form-group">
  	<div class="col-4">
		<form:label path="password">Password</form:label>
		<form:password class="form-control" path="password" /><form:errors path="password"/>
	</div>
  </div>

  <input type="submit" value="Submit" class="btn btn-orange" />
	<div id="toRegisterForm"><p><a href="register">Don't have an account?</a></p></div>
</form:form>
</div>

</div>

</div>

<div class="col-md-4 login-module-right">
<spring:url value="/assets/images/MusiCloud.png" var="MusiCloudLogo" />
<img src="${MusiCloudLogo}" alt="MusiCloud Logo" class="center" width="200" height="200">
<h1><i>MusiCloud</i></h1>
</div>



