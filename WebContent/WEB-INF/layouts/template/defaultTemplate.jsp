<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- 
  --	Default template to be used throughout the application
  --	uses bootstrap css, JQuery, custom css stylesheets, and railway font
  --
  --	Created by William Bierer & Brendan Brooks.
  -- 
  -->

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>MusiCloud</title>
	 <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <spring:url value="/assets/scripts/jquery-3.3.1.min.js" var="jQueryLink" />
     <spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" var="bootstrapJsLink" />
     <spring:url value="/assets/scripts/script.js" var="scriptJsLink" />
     <spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" var="bootstrapCssLink" />
     <spring:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" var="popperLink" />
     <spring:url value="/assets/css/style.css" var="styleLink" />
     <script type="text/javascript" src="${jQueryLink}"></script>
	 <script type="text/javascript" src="${bootstrapJsLink}"></script>
	 <script type="text/javascript" src="${scriptJsLink}"></script>
 	 <script type="text/javascript" src="${popperLink}"></script>
	 <link rel="stylesheet" href="${bootstrapCssLink}" />
	 <link rel="stylesheet" href="${styleLink}" />
	 <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" />

</head>

<body>
	<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
		<tiles:insertAttribute name="body" />

	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
</body>

</html>