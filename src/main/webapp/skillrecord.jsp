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


			<table class="table table-hover bg-light table-bordered">
				<thead>
					<tr class="text-center">
						<th scope="col-1">Id</th>
						<th scope="col-3">Employee Name</th>
						<th scope="col-2">Address</th>
						<th scope="col-1">Skills</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${employee}" var="emp">
						<tr>
							<th scope="row">${emp.emp_id}</th>
							<td>${emp.name }</td>
							<td>${emp.address }</td>
							<td><c:forEach items="${emp.skills}" var="skill">
									<c:out value="${skill}"></c:out>, 
							</c:forEach></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-6 text-center offset-3">

			<c:choose>
				<c:when test="${count<=0}">
					<a class=" btn btn-secondary" style="pointer-events: none;"
						empskills?action=prev&count=${count}">Previous</a>
				</c:when>
				<c:otherwise>
					<a class=" btn btn-secondary"
						href="empskills?action=prev&count=${count}">Previous</a>
				</c:otherwise>
			</c:choose>

			<%
				
			int count =(int) request.getAttribute("count");
			int recordCount =(int) request.getAttribute("recordCount");
			int rem = count + 5;
			
			if(rem >= recordCount){ %>
				<a class="btn btn-secondary" style="pointer-events: none;"
				href="empskills?action=next&count=${count}">Next</a> <%
			}else{  %>
			
						<a class="btn btn-secondary" 
				href="empskills?action=next&count=${count}">Next</a>
 			<% 	} %>
		</div>
</body>
</html>