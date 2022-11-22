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


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Update Details</title>
</head>
<body style="background-color: #26a69a;">
	<div class="container-fluid">
		<div class="row" style="height: 70px; background-color: #4e342e;"></div>
		<div class="row">
			<div class="col-lg-4 offset-4">
				<div class="card mt-4">
					<div class="card-header text-center ">
						<h3>Update Details</h3>
					</div>
					<form class="m-4" action="employee" method="post">
						<div class="form-row">

							<div class="form-group col-lg-12">
							<input
									type="hidden" class="form-control" name="id"
									value="${emp.emp_id}"
									placeholder="<c:out value="${emp.emp_id}"></c:out>">
							</div>

							<div class="form-group col-lg-12">
								<label for="inputPassword4">Employee Name</label> <input
									type="text" class="form-control" name="name"
									value="${emp.name}"
									placeholder="<c:out value="${emp.name}"></c:out>">
							</div>
						</div>
						<div class="form-group">
							<label for="inputAddress">Address</label> <input type="text"
								name="address" class="form-control" value="${emp.address}"
								placeholder=" <c:out value="${emp.address}"></c:out>">
						</div>
						<div class="input-group date">
							<label for="birthday">Birthday : </label> <input class="offset-1"
								type="date" value="${emp.birthdate}"
								name="birthdate">
						</div>

						<c:set var="Male" value="Male"></c:set>
						<c:set var="Female" value="Female">
						</c:set>

						<c:choose>
							<c:when test="${emp.gender== Male}">
				            <div class="form-group">
							<label>Gender</label>
							<div class="form-check col-lg-9">
								<input class="form-check-inputcol-lg-6" type="radio"
									name="gender" value="male" checked>
								<label class="form-check-label" for="exampleRadios1">
									Male </label> 
								<input class="form-check-inputcol-lg-6 offset-1"
									type="radio" name="gender" value="female">
								<label class="form-check-label" for="exampleRadios1">
									Female </label>
							</div>
						</div>
				         </c:when>

							<c:when test="${emp.gender==Female}">
				            <div class="form-group">
							<label>Gender</label>
							<div class="form-check col-lg-9">
								<input class="form-check-inputcol-lg-6" type="radio"
									name="gender" value="male" >
								<label class="form-check-label" for="exampleRadios1">
									Male </label> 
								<input class="form-check-inputcol-lg-6 offset-1"
									type="radio" name="gender" value="female" checked>
								<label class="form-check-label" for="exampleRadios1">
									Female </label>
							</div>
						</div>
				        </c:when>

						</c:choose>



						<div class="form-group">
							<label>Salary</label> <input type="number" class="form-control"
								name="salary"
								placeholder=" <c:out value="${emp.salary}"></c:out>"
								value="${emp.salary}">
						</div>

						<div class="form-group text-center"></div>
						<button type="submit" class="btn btn-primary">Update</button>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>