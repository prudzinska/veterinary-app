<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<form method="POST" action="${context}/reception/animal/added">
		<table>
			<thead>
				<tr>
					<th>Type</th>
					<th>Breed</th>
					<th>Name</th>
					<th>Age</th>
					<th>Owner</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input id="type" name="type" type="text" value="" /></td>
					<td><input id="breed" name="breed" type="text" value="" /></td>
					<td><input id="name" name="name" type="text" value="" /></td>
					<td><input id="age" name="age" type="text" value="" /></td>
					<td><select id="owner" name="owner">
							<c:forEach items="${customers}" var="customer">
								<option value="${customer.id}">${customer.name}
									${customer.surname}</option>
							</c:forEach>
					</select></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</tbody>
		</table>
	</form>
</t:layout>

<
