<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<form method="POST" action="${context}/reception/customer/edited">
		<table>
			<thead>
				<th>customer name</th>
				<th>customer surname</th>
				<th></th>
			</thead>
			<tbody>
				<tr>
					<td><input id="name" name="name" type="text" value="${customer.name}" /></td>
					<td><input id="surname" name="surname" type="text" value="${customer.surname}" /></td>
					<td><input type="submit" value="Submit"></td>
					<input id="id" name="id" type="hidden" value="${customer.id}" />
				</tr>
			</tbody>
		</table>
	</form>
</t:layout>
