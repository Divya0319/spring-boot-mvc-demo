<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Customer Registration form</title>
	<!-- Defining a style in the jsp page itself -->
	<!-- error below is the name of css class, which we used later below -->
	<style>  
		.error {color:red}
	</style> 

</head>


<body>

<i>Fill out the form. Asterisk(*) means required</i>

<br><br>

	<form:form action="processForm" modelAttribute="customer"> <!-- data binding done for form, model attribute here is actually defined in Customer controller, and passed blank initially, but will contain values when form will be submitted -->
															  
	
		First name: <form:input path="firstName"/> <!-- "firstName" is the field defined in Customer class, which is bound to "customer" attribute above -->
		
		<br><br>
		
		Last name (*): <form:input path="lastName"/> <!-- same goes for lastName -->
		
		<!-- Below Field is added to display the errors -->
		<form:errors path="lastName" cssClass="error"/> <!-- css class used to Display an error message(is set) -->
		
		<br><br>
		
		Free passes:  <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />
		
		<br><br>
		
		Postal code: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error"/>
		
		<br><br>
		
		Course code: <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error"/>
		
		<br><br>
		
		
		<input type="submit" value="Submit"/>
	
	</form:form>
</body>

</html>