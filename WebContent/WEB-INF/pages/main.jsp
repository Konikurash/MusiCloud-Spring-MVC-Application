<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- 
  --	Main view that will contain a library of songs uploaded by the user that can be streamed.
  --	Will contain link to view where user can upload songs to the application
  --
  --	Created by William Bierer & Brendan Brooks.
  -- 
  -->
<nav class="navbar navbar-inverse navbar-static-top">
  <ul class="nav navbar-nav">
    <p class="navbar-text navbar-right"><a href="/" class="navbar-link">Logout</a></p>
  </ul>
</nav>

<div class="music-module-container">
<div class="row">
<div class="col-md-2">
</div>
<div class="col-md-8">
	<div class="music-module-header">
		<spring:url value="/assets/images/MusiCloud.png" var="MusiCloudLogo" />
		<img src="${MusiCloudLogo}" alt="MusiCloud Logo" class="center" width="200" height="200">
		<h1 class="musicloud-big"><i>MusiCloud</i></h1><br>
		<hr><br>
		<h2 class="main-tag">Welcome to <i>your</i> music library!</h2>
		<br>
		<p>Try uploading a song to the cloud</p>
	</div>
	<div class="lighter-module">
	<div id="addSongToggle"><button class="btn btn-orange" id="">Add</button></div>
	<div id="addSongModule" style="display: none;">
		<form:form method="POST" class="form-inline" modelAttribute="song" action="addSong">
			<div class="form-group" style="margin-left: 5px;">
				<form:label path="title">Title </form:label>
				<form:input class="form-control" path="title" style="margin-left: 5px;"/>
			</div>
			<div class="form-group" style="margin-left: 5px;">
		 		<form:label path="artist">Artist </form:label>
				<form:input class="form-control" path="artist" style="margin-left: 5px;" />
			</div> <br>
			<div class="form-group" style="margin-left: 5px;">
		 		<form:label path="album">Album </form:label>
				<form:input class="form-control" path="album" style="margin-left: 5px;" />
			</div>
			<div class="form-group" style="margin-left: 5px;">
				<form:label path="year">Year </form:label>
				<form:input class="form-control" path="year" style="margin-left: 5px;" />
			</div>
				<input type="submit" value="Submit" class="btn btn-orange" style="margin-bottom: 0; margin-left: 10px;" />
			<form:errors path="*" />
		</form:form>
		</div>
	<table class="table table-hover">
	<c:forEach items="${songs}" var="s">
	 <spring:url value="${s.getMp3Path()}" var="url" />
		<tr>
			<td>
				<h2>${s.getTitle()}</h2>
				<p>${s.getAlbum()} </p>
				<p>${s.getArtist()}</p>
				<audio controls>
					 <source src="${url}" type="audio/mpeg">
				</audio>
			</td>
		</tr>
	</c:forEach>
	</table>
	</div>
</div>
</div>
</div>

