<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>PortfolioHomePage</title>
	</head>

	<body>
		<h4>Welcome to the Struts 2 Portfolio!</h4> 	
		<ul>
      <li><a href="<s:url action='Registration'/>">Create an Account</a></li>	
	    <li><a href="<s:url action='RegistrationOB'/>">Create an Account  ( Object Backed Version )</a></li>	
	    <li><a href="<s:url action='RegistrationMD'/>">Create an Account  ( Model Driven Version )</a></li>	
		  </ul> 
		
	</body>
	
</html>
