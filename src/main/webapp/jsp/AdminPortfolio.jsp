<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Administer Portfolio</title>
	</head>

	<body>
		<h4></h4>
		<ul>
			<li>
				<a href="<s:url action='AddImage'/>">Add image to portfolio</a>
			</li>
			<li>
				<a href="<s:url action='RemoveImage'/>">Remove an image from portfolio</a>				
			</li>
		</ul>
		
		 	
		<h3>The <s:property value="portfolioName" /> Portfolio</h3>
		<p>
		You may now begin working with 
		<a href="<s:url action='secure/AdminPortfolio'/>">your portfolio.</a>
		</p>
	</body>
</html>