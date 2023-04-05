<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPe html>
<html>
<head>
	<title>Student Confirmation</title>
	<style type="text/css">
	td {
		border: solid 2px lightgrey;
		}
	</style>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName} 

<br><br>

Country:  ${student.country}

<br><br>

Favorite Language: ${student.favoriteLanguage}

<br><br>

Operating Systems:

<table style="border: 2px solid grey; border-collapse:collapse;">


	<c:forEach var="temp" items="${student.operatingSystems}">
	<tr>
		<td>${temp}</td>
	</tr>
	</c:forEach>

</table>

</body>
</html>