<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 style="color: red;">${requestScope.candidate_bean.message}</h5>
	<form action="candidate_registration" method="get">
		<table style="background-color: lightgrey; margin: auto;">
			<tr>
				<td>Enter Candidate Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Political Party</td>
				<td><input type="text" name="party" /></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="date" name="dob" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form>

</body>
</html>