<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><%@ page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student Details</title>
</head>

<body>

	<div class="container">

		<h3>Student Details</h3>
		<hr>

		<p class="h4 mb-4">Add Student Details</p>

		<form action="/StudentDetailManagement/student/add" method="POST">


			<input type="hidden" name="id" value="${Student.studentId}" />

			<div class="form-inline">
				<input type="text" name="name" value="${Student.name}"
					class="form-control mb-4 col-4" placeholder="Name" />
			</div>

			<div class="form-inline">

				<input type="text" name=department value="${Student.department}"
					class="form-control mb-4 col-4" placeholder="Department">
			</div>

			<div class="form-inline">
				<input type="text" name="country" value="${Student.country}"
					class="form-control mb-4 col-4" placeholder="Country">
			</div>

			<button type="submit" class="btn btn-info col-2">Add</button>

		</form>


		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${studentDetails}" var="sd">
					<tr>
						<td><c:out value="${sd.name}" /></td>
						<td><c:out value="${sd.department}" /></td>
						<td><c:out value="${sd.country}" /></td>
						<td><a
							href="/StudentDetailsManagement/student/updateStudentDetail?id=${sd.studentId}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->


							<a
							href="/StudentDetailsManagement/student/delete?studentId=${sd.studentId}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
								Delete </a></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>


		<hr>


	</div>
</body>

</html>










