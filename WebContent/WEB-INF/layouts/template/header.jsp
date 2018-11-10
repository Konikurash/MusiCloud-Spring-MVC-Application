<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/library/main" var="homeURL" />
<spring:url value="/settings" var="settingsURL" />
<spring:url value="/logout" var="logout" />

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="${homeURL}">MusiCloud</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="${homeURL}">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${settingsURL}">Settings</a>
      </li>
    </ul>
    
     <span class="nav-item">
         <a href="${logout}" style="color: #919191">Logout</a>
    </span>
  </div>
</nav>