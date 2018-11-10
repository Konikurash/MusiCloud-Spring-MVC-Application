<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="row" style="margin-bottom: 100px;">
<div class="col-md-12" style="margin-top: 40px; margin-bottom: 40px;">
<h1 align="center" style="font-size: 72px;">Settings</h1>
</div>
	<div class="col-lg-2"></div>
	<div class="col-lg-4 lighter-module" align="center">
		<h1>Edit Profile</h1>
			<div class="" style="">
				<form:form method="POST" modelAttribute="user" action="updateUser">
				  <div class="form-group">
				  	<div class="col-8">
						<form:label path="firstName">First Name</form:label>
						<form:input class="form-control" path="firstName" />
					 </div>
					 <form:errors path="firstName"/>
				  </div>
				  <div class="form-group">
				  	<div class="col-8">
				  				<form:label path="lastName">Last Name</form:label>
						<form:input class="form-control" path="lastName" />
				  	</div>
				  	<form:errors path="lastName"/>
				  </div>
				  <div class="form-group">
				  	<div class="col-8">
						<form:label path="email">Email Address</form:label>
						<form:input class="form-control" type="email" path="email" />
					 </div>
					 <form:errors path="email"/>
				  </div>
				  <input type="submit" value="Submit" class="btn btn-orange" />
				</form:form>
		</div>
	</div>
	<div class="col-lg-4 lighter-module" align="center">
		<h1>Change Password</h1>
		<form:form method="POST" modelAttribute="passwordModel" action="updatePassword">
		  <div class="form-group">
		  	<div class="col-8">
				<form:label path="newPassword">New Password</form:label>
				<form:password class="form-control" path="newPassword" />
			 </div>
			 <form:errors path="newPassword"/>
		  </div>
		  <div class="form-group">
		  	<div class="col-8">
		  				<form:label path="newPasswordConfirmation">Confirmation</form:label>
				<form:password class="form-control" path="newPasswordConfirmation" />
		  	</div>
		  	<form:errors path="newPasswordConfirmation"/>
		  </div>
		  <input type="submit" value="Submit" class="btn btn-orange" />
		</form:form>
		<hr>
		<div class="col-md-12">
			<spring:url value="/deleteAccount" var="deleteURL" />
			<p id="deleteAccount"><a href="javascript:void(0)" style="color: #c4c4c4">Delete Account</a></p>
			<div id="delete-confirmation" style="display: none">
				Are you sure? This cannot be undone. <br /> 
				<a href='${deleteURL}' style="color: #f26113">Yes, delete my account</a>
			</div>
		</div>
	</div>
</div>

