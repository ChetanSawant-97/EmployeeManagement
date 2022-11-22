<%@ page isELIgnored="false"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Employee Record</title>
</head>
<body style="background-color: #26a69a;">
	<div class="container-fluid">

		<div class="row" style="height: 70px; background-color: #4e342e;"></div>

		<div class="col-lg-10 mt-5 offset-1">
		
		<form>
			<table class="table table-hover bg-light table-bordered">
				<thead>
					<tr class="text-center">
						<th scope="col-1">Id</th>
						<th scope="col-3">Employee Name</th>
						<th scope="col-2">Address</th>
						<th scope="col-1">Gender</th>
						<th scope="col-2">Salary</th>
						<th scope="col-1">DOB</th>
						<th scope="col-2">Action</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${empDetails}" var="emp">
						<tr>
							<th scope="row">${emp.emp_id}</th>
							<td>${emp.name }</td>
							<td>${emp.address }</td>
							<td class="text-center">${emp.gender}</td>
							<td class="text-center">${emp.salary }</td>
							<td class="text-center">${emp.birthdate }</td>
							<td>
								<div>
									<a class ="btn btn-primary btn-sm  offset-2" href="employee?id=<c:out value='${emp.emp_id}'/>&method=update" > Edit</a>
									
									<a class ="btn btn-primary btn-sm delete offset-2" href="employee?id=<c:out value='${emp.emp_id}'/>&method=delete" onclick='delete()'> Delete</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</form>
		</div>
		<script type="text/javascript"></script>
</body>
</html>