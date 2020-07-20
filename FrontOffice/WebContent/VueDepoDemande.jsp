<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page import="frontMetier.Procedure" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposition d'une demande</title>
  <link type="text/css" rel="stylesheet" href="inc/main.css"/>
</head>
<body>
<jsp:include page="/headerCitoyen.jsp" />
<div class="filter">  </div>
<div class="depo">
<h1>DEPOSER DEMANDE</h1>
<form method="post" action="DepoAffichage">
   <label for="cinCitoyen">CIN: <span class="requis">*</span></label>
   <input type="text" id="cinCitoyen" name="cinCitoyen" value="${cinCitoyen }" size="50" maxlength="20" />
    <br />
   <label for="emailCitoyen">EMAIL: </label>
   <input type="text" id="emailCitoyen" name="emailCitoyen" value="xxx@gmail.com" size="50" maxlength="20" />
    <br />
    
   <p>      
    <label for="procedure">Choisir une procedure</label><br /> 
     <select name="procedure" id="procedure">  
      <c:forEach var="proc" items="${procedure}">
      <option> <c:out  value="${proc}"/></option>
      </c:forEach>               
     </select>   </p>
        <span>valider pour afficher les documents necessaires</span> 
    <input type="submit" value="Valider" name="idprocedure" class="sansLabel" />
     
 <p>
        <textarea  placeholder="<c:forEach var="doc" items="${document}"><c:out value="${doc}  " /></c:forEach>"  rows="3" cols="30" disabled></textarea>
          
          
 </p>
    <br />
     
     
   <label for="fichier">Emplacement du fichier <span class="requis">*</span></label> 
   <input type="file" id="fichier" name="fichier" value="" /> 
      <br />
     <p>Voici votre jeton:<span>${jeton}</span>
     </p>
     <input type="submit" value="Valider"  class="sansLabel" /> 
     <input type="reset" value="Remettre à zéro" /> <br>
      </form>
  </div>
   

</body>
</html>