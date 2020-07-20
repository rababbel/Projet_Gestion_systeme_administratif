<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<%-- Boucle calculant le cube des entiers de 0 à 7 et les affichant dans un tableau HTML --%> 
<table>  
<tr>    
<th>Valeur</th>   
<th>Cube</th>  
</tr> <c:forEach var="i" begin="0" end="7" step="1">  <tr>    
<td><c:out value="${i}"/></td>    <td><c:out value="${i * i * i}"/></td>  
</tr>
 </c:forEach> 
 </table>

</body>
</html>