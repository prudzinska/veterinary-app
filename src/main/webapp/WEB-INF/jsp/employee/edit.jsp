<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<form method="POST" action="${context}/reception/employee/edited">
		<table>
			<thead>
				<tr>
					<th>name</th>
					<th>surname</th>
					<th>salary</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input id="name" name="name" type="text" value="${employee.name}" /></td>
					<td><input id="surname" name="surname" type="text" value="${employee.surname}" /></td>
					<td><input id="salary" name="salary" type="text" value="${employee.salary}" /></td>
					<td><input type="submit" value="Submit"></td>
					<input id="id" name="id" type="hidden" value="${employee.id}" />
				</tr>
			</tbody>
		</table>
	</form>
</t:layout>