<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
<jsp:include page="/headerEmploye.jsp" />
<div class="position">
<c:if test="${!empty sessionScope.idEtape}">
<p>les demandes de l'etape ${sessionScope.idEtape} sont:</p>
</c:if>
<form action="Decision">
<select name="Demande"  >
<c:forEach var="dem" items="${demandes }" >
<option><c:out value="${dem}"/></option>
</c:forEach>
</select><br>
<input type="submit" value="valider"><br>
</form>
</div>

<c:if test="${!empty sessionScope.id_Demande}">
<jsp:include page="/decision.jsp" />

</c:if>

<jsp:include page="/footer.jsp" />
</body>
</html>