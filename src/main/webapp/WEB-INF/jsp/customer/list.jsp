<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Surname</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.name}</td>
					<td>${customer.surname}</td>
					<td><a href="${context}/reception/customer/edit/${customer.id}">Edit</a></td>
					<td><a href="${context}/reception/customer/delete/${customer.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</t:layout>
