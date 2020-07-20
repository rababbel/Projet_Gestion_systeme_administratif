<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link type="text/css" rel="stylesheet" href="inc/style.css"/>
</head>
<body>

<div >
<p class="accuiel"> Bien venu dans l'espace client:</p>
<div class="headerEmploye">
<p>choisir une action:</p>
<a href="/JAVA_PROJET_FRONT/afficherDepo">deposer demande</a>
<a href="/JAVA_PROJET_FRONT/suiviCitoyen">suivre demande</a><br>
</div>
</div>
<jsp:include page="/footer.jsp" />
</body>
</html>