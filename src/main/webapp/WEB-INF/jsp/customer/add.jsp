<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:layout>
	<form method="POST" action="${context}/reception/customer/added">
		<table>
			<thead>
				<th>customer name</th>
				<th>customer surname</th>
				<th></th>
			</thead>
			<tbody>
				<tr>
					<td><input id="name" name="name" type="text" value="" /></td>
					<td><input id="surname" name="surname" type="text" value="" /></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</tbody>
		</table>
	</form>
</t:layout>
