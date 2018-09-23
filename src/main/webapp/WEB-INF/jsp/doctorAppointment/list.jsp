<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<table>
		<thead>
			<tr>
				<th>employee</th>
				<th>animal</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="doctorAppointment" items="${doctorAppointments}">
				<tr>
					<td>${doctorAppointment.employee.name} ${doctorAppointment.employee.surname}</td>
					<td>${doctorAppointment.animal.type} ${doctorAppointment.animal.name}</td>
					<td><a href="${context}/reception/doctorAppointment/edit/${doctorAppointment.id}">Edit</a></td>
					<td><a href="${context}/reception/doctorAppointment/delete/${doctorAppointment.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</t:layout>
