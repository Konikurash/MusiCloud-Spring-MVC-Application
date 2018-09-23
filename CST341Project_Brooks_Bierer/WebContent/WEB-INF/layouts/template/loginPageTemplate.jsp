<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>MusiCloud | Login & Register</title>
	 <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <spring:url value="/assets/scripts/jquery-3.3.1.min.js" var="jQueryLink" />
     <spring:url value="/assets/scripts/bootstrap.js" var="bootstrapJsLink" />
     <spring:url value="/assets/scripts/script.js" var="scriptJsLink" />
     <spring:url value="/assets/css/bootstrap.css" var="bootstrapCssLink" />
     <spring:url value="/assets/css/style.css" var="styleLink" />
     <script type="text/javascript" src="${jQueryLink}"></script>
	 <script type="text/javascript" src="${bootstrapJsLink}"></script>
	 <script type="text/javascript" src="${scriptJsLink}"></script>
	 <link rel="stylesheet" href="${bootstrapCssLink}" />
	 <link rel="stylesheet" href="${styleLink}" />
	 <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" />
</head>
 
<spring:url value="/assets/images/blurred-audience.png" var="backgroundImage" />
<body style="background: url(${backgroundImage}) no-repeat fixed center !important; background-size: cover !important;">
	<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
	<div align="center">
		<tiles:insertAttribute name="body" />
	</div>

	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
</body>

</html>