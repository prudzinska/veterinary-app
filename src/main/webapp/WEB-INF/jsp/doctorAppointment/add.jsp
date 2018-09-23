<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<form method="POST" action="${context}/reception/doctorAppointment/added">
		<table>
			<thead>
				<tr>
					<th>employee</th>
					<th>animal</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><select id="employee" name="employee">
							<c:forEach items="${employees}" var="employee">
								<option value="${employee.id}">${employee.name}
									${employee.surname}</option>
							</c:forEach>
					</select></td>
					<td><select id="animal" name="animal">
							<c:forEach items="${animals}" var="animal">
								<option value="${animal.id}">${animal.name}
									${animal.type}</option>
							</c:forEach>
					</select></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</tbody>
		</table>
	</form>
</t:layout>

<
