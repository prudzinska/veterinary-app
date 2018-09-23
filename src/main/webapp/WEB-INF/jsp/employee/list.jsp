<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Surname</th>
				<th>Salary</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.name}</td>
					<td>${employee.surname}</td>
					<td>${employee.salary}</td>
					<td><a href="${context}/reception/employee/edit/${employee.id}">Edit</a></td>
					<td><a href="${context}/reception/employee/delete/${employee.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:layout>