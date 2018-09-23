<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html lang="en">

<head>
<link rel="stylesheet" type="text/css" href="${context}/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<div class="main-container">
		<div class="left-panel">
			<div class="logo">Veterinary clinic</div>
			<h2>Doctor appointment</h2>
			<ul>
				<li><a href="${context}/reception/doctorAppointment/list">Show appointment</a></li>
				<li><a href="${context}/reception/doctorAppointment/add">Add appointment</a></li>
			</ul>
			<h2>Customers</h2>
			<ul>
				<li><a href="${context}/reception/customer/list">Show customers</a></li>
				<li><a href="${context}/reception/customer/add">Add customer</a></li>
			</ul>
			<h2>Animals</h2>
			<ul>
				<li><a href="${context}/reception/animal/list">Show animals</a></li>
				<li><a href="${context}/reception/animal/add">Add animal</a></li>
			</ul>
			<h2>Employees</h2>
			<ul>
				<li><a href="${context}/reception/employee/list">Show employees</a></li>
				<li><a href="${context}/reception/employee/add">Add employee</a></li>
			</ul>
		</div>
		<div class="content">
			<jsp:doBody/>
		</div>
	</div>
</body>

</html>