<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Type</th>
				<th>Breed</th>
				<th>Age</th>
				<th>Owner</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="animal" items="${animals}">
				<tr>
					<td>${animal.name}</td>
					<td>${animal.type}</td>
					<td>${animal.breed}</td>
					<td>${animal.age}</td>
					<td>${animal.owner.name} ${animal.owner.surname}</td>
					<td><a href="${context}/reception/animal/edit/${animal.id}">Edit</a></td>
					<td><a href="${context}/reception/animal/delete/${animal.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</t:layout>
