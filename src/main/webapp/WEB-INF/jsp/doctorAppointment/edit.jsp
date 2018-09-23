<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<form method="POST" action="${context}/reception/doctorAppointment/edited">
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
								<c:choose>
									<c:when test="${employee.id==doctorAppointment.employee.id}">
										<option value="${employee.id}" selected>${employee.name}
											${employee.surname}</option>
									</c:when>
									<c:otherwise>
										<option value="${employee.id}">${employee.name}
											${employee.surname}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
					<td><select id="animal" name="animal">
							<c:forEach items="${animals}" var="animal">
								<c:choose>
									<c:when test="${animal.id==doctorAppointment.animal.id}">
										<option value="${animal.id}" selected>${animal.name}
											${animal.type}</option>
									</c:when>
									<c:otherwise>
										<option value="${animal.id}">${animal.name}
											${animal.type}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
					<td><input type="submit" value="Submit"></td>
					<input id="id" name="id" type="hidden"
						value="${doctorAppointment.id}" />
				</tr>
			</tbody>
		</table>
	</form>
</t:layout>


