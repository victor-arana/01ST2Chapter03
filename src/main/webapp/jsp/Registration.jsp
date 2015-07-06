<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Portfolio Registration</title>
	</head>

	<body>
		<h4>Welcome to the Struts 2 Portfolio!</h4> 	
		<s:form action="Register">
			<s:textfield name="user.username" label="Username"/>
			<s:password name="user.password" label="Password"/>
			<s:textfield name="user.portfolioName" label="Enter a name for your portfolio"/>
			<s:submit/>
		</s:form>
	</body>
</html>