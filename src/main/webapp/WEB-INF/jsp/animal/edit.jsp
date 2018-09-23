<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<form method="POST" action="${context}/reception/animal/edited">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Type</th>
					<th>Breed</th>
					<th>Age</th>
					<th>Owner</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input id="name" name="name" type="text" value="${animal.type}" /></td>
					<td><input id="type" name="type" type="text" value="${animal.breed}" /></td>
					<td><input id="breed" name="" type="text" value="${animal.name}" /></td>
					<td><input id="age" name="age" type="text" value="${animal.age}" /></td>
					<td><select id="owner" name="owner">
							<c:forEach items="${customers}" var="customer">
								<c:choose>
									<c:when test="${customer.id==animal.owner.id}">
										<option value="${customer.id}" selected>${customer.name} ${customer.surname}</option>
									</c:when>
									<c:otherwise>
										<option value="${customer.id}">${customer.name} ${customer.surname}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
					<td><input type="submit" value="Submit"></td>
					<input id="id" name="id" type="hidden" value="${animal.id}" />
				</tr>
			</tbody>
		</table>
	</form>
</t:layout>