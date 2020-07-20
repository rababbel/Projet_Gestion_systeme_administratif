<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link type="text/css" rel="stylesheet" href="inc/style.css"/>
</head>
<body>
<jsp:include page="/headerEmploye.jsp" />
<div>

<ul>
<c:forEach var="demande" items="${demandes}">

<li class="accuiel">la demande  <c:out value="${demande.value}"/> de l'etape <c:out value="${demande.key}"/></li>

</c:forEach>

</ul>
</div>
<jsp:include page="/footer.jsp" />
</body>
</html>