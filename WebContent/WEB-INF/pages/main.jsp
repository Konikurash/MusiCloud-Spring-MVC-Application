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
	<spring:url value="/library/addSong/" var="addURL" />
		<form:form method="POST" modelAttribute="song" action="${addURL}">
		<div class="col-md-12" align="center" style="margin-bottom: 5px;">
		<div class="col-md-8" style="margin-bottom: 5px;">
			<div class="form-group" style="margin-left: 5px;">
				<form:label path="title">Title </form:label>
				<form:input class="form-control" path="title" style="margin-left: 5px;"/>
			</div>
		</div>
		<div class="col-md-8" style="margin-bottom: 5px;">
			<div class="form-group" style="margin-left: 5px;">
		 		<form:label path="artist">Artist </form:label>
				<form:input class="form-control" path="artist" style="margin-left: 5px;" />
			</div>
		</div>
		<div class="col-md-8" style="margin-bottom: 5px;">
			<div class="form-group" style="margin-left: 5px;">
		 		<form:label path="album">Album </form:label>
				<form:input class="form-control" path="album" style="margin-left: 5px;" />
			</div>
		</div>
		<div class="col-md-8" style="margin-bottom: 5px;">
			<div class="form-group" style="margin-left: 5px;">
				<form:label path="year">Year </form:label>
				<form:input class="form-control" path="year" style="margin-left: 5px;" />
			</div>
		</div>
		<div class="col-md-8" style="margin-bottom: 5px;">
			<input type="submit" value="Submit" class="btn btn-orange" />
		</div>
		<div class="col-md-8" style="margin-bottom: 5px;">
			<form:errors path="*" />
		</div>
		</div>
		</form:form>
		</div>
	<table class="table table-hover">
	<spring:url value="/assets/images/dropdownSong.png" var="songDrop" />
	<c:forEach items="${songs}" var="s">
	 <spring:url value="${s.getMp3Path()}" var="url" />
		<tr>
			<td class="custom-row">
				<h2>${s.getTitle()}</h2>
				<p>${s.getAlbum()} </p>
				<p>${s.getArtist()}</p>
				<audio controls style="margin-bottom: 15px">
					 <source src="${url}" type="audio/mpeg">
				</audio>
				
				<div align="center">
					<button class="btn btn-orange dropdown-toggle editButton">
					</button>
					<div class="dropList" style="display: none;">
						<form:form method="POST" modelAttribute="editSong" action="updateSong">
						<form:hidden name="id" value="${s.getId()}" path="id" />
						<div class="col-md-12" align="center" style="margin-bottom: 5px;">
						<div class="col-md-8" style="margin-bottom: 5px;">
							<div class="form-group">
								<form:label path="title">Title </form:label>
								<form:input value="${s.getTitle()}" class="form-control" path="title" style="margin-left: 5px;"/>
							</div>
						</div>
						<div class="col-md-8" style="margin-bottom: 5px;">
							<div class="form-group">
			 					<form:label path="artist">Artist </form:label>
								<form:input value="${s.getArtist()}" class="form-control" path="artist" style="margin-left: 5px;" />
							</div>
						</div>
						<div class="col-md-8" style="margin-bottom: 5px;">
							<div class="form-group">
		 						<form:label path="album">Album </form:label>
								<form:input value="${s.getAlbum()}" class="form-control" path="album" style="margin-left: 5px;" />
							</div>
						</div>
						<div class="col-md-8" style="margin-bottom: 5px;">
							<div class="form-group">
								<form:label path="year">Year </form:label>
								<form:input value="${s.getYear()}" class="form-control" path="year" style="margin-left: 5px;" />
							</div>
						</div>
						</div>
						<div class="col-md-12" align="center">
							<input type="submit" class="btn btn-orange"/><br />
							<form:errors path="*" />
							<spring:url value="/library/deleteSong/${s.getId()}/" var="deleteURL" />
							<a href="deleteSong/${s.getId()}">Delete</a>
						</div>
						</form:form>
					</div>
				</div>
			</td>
		</tr>
	</c:forEach>
	</table>
	</div>
</div>
</div>
</div>

