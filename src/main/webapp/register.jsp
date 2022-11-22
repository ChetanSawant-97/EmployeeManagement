<%@page import="com.em.entities.Skill"%>
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
<title>Employee</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body style="background-color: #26a69a;">
	<div class="container-fluid">
		<div class="row" style="height: 70px; background-color: #4e342e;"></div>
		<div class="row">
			<div class="col-lg-4 offset-4">
				<div class="card mt-4">
					<div class="card-header text-center ">
						<h3>Create Employee</h3>
					</div>
					<form class="m-4" action="register" method="post">
						<div class="form-row">
							<div class="form-group col-lg-12">
								<label for="inputPassword4">Employee Name</label> <input
									type="text" class="form-control" name="name"
									placeholder="Enter your name">
							</div>
						</div>
						<div class="form-group">
							<label for="inputAddress">Address</label> <input type="text"
								name="address" class="form-control" placeholder="Enter Address">
						</div>
						<div class="input-group date">
							<label for="birthday">Birthday : </label> <input class="offset-1"
								type="date" id="birthday" name="birthday">
						</div>

						<div class="form-group">
							<label>Gender</label>
							<div class="form-check col-lg-9">
								<input class="form-check-inputcol-lg-6" type="radio"
									name="gender" value="male" checked> <label
									class="form-check-label" for="exampleRadios1"> Male </label> 
									<input
									class="form-check-inputcol-lg-6 offset-1" type="radio"
									name="gender" value="female"> <label
									class="form-check-label" for="exampleRadios1"> Female </label>
							</div>
						</div>



						<div class="form-group">
							<label class="mr-2">Skills</label>

							<c:forEach items="${skills}" var="s">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="checkbox" name="skill"
										value="${s.id}"> <label class="form-check-label"
										for="inlineCheckbox2"> <c:out value="${s.name}"></c:out>
									</label>
								</div>
							</c:forEach>
						</div>

						<div class="form-group">
							<label>Salary</label> <input type="number" class="form-control"
								name="salary" placeholder="Enter Salary">
						</div>

						<div class="form-group"></div>
						<button type="submit" class="btn btn-primary">Sign in</button>
					</form>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript" href="js/home.js"></script>
</body>
</html>