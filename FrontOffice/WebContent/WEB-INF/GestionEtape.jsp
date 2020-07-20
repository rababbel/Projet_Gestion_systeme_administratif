<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>gestion etape</title>
<link type="text/css" rel="stylesheet" href="inc/style.css"/>
</head>
<body>
<jsp:include page="/headerEmploye.jsp" />
<div class="position">
<form action="GestionEtapeEmploye">
<fieldset>
<legend>choisir une etape</legend>
<select name="idEtape"  >
<c:forEach var="id" items="${ListeEtapes}">
<option ><c:out value="${id}"/></option>
</c:forEach>

</select>
</fieldset>
<input type="submit" value="valider">
</form>
<br>
</div>
<jsp:include page="/footer.jsp" />
</body>
</html>