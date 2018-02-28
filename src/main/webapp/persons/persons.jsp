<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
		<title>All persons</title>
	</head>
	<body>
		<main>
			<div class="container">
				<div class="row">
					<div class="col s12 m9 l10">
						<div class="section">
							<div id="roboto" class="scrollspy">
								<div id="blockquote" class="section scrollspy">
									<h2 class="header">List all persons (Servlet)</h2>
									<div class="card-panel">
										<div class="row">
									       <table>
									            <tr>
									            		<th>ID</th>
									                <th>First name</th>
									                <th>Last name</th>
									                <th>E-mail address</th>
									            </tr>
									            <c:forEach items="${listPerson}" var="person">
									                <tr>
									                		<td><c:out value="${person.id}"/></td>
									                    <td><c:out value="${person.name}"/></td>
									                    <td><c:out value="${person.surname}"/></td>
									                    <td><c:out value="${person.email}"/></td>
									                </tr>
									            </c:forEach>
									        </table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End Container -->
			</div>
		</main>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
	</body>
</html>

