<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page import="frontMetier.Procedure" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>suivre demande</title>
  <link type="text/css" rel="stylesheet" href="inc/style.css"/>
</head>
<body>
<jsp:include page="/headerCitoyen.jsp" />
<div class="filter"></div>
<div class="form">
<form method="post" action="SuivreDemandeCitoyen">
   <fieldset>                    
   <legend>suivre demande</legend>
   <label for="jeton">Inserer le code de votre jeton: <span class="requis">*</span></label>
   <input type="text" id="jeton" name="jeton" value="${jeton}" size="50" maxlength="50" /><span class=erreur>${erreur}</span>
    <br />
    <br />
          <input type="submit" value="Valider"  class="sansLabel" />
     <p>
    L'etat de votre demande est:<span class="etape">${etape}</span>
     </p>
   <label for="update">les document a mettre a jour:</label>
   <textarea id="update" name="update"  rows="2" cols="40" tabindex="40" placeholder="attestation de scolarité" disabled></textarea>
    <br>    
   <label for="fichier">Emplacement du fichier: </label> <br>
   <input type="file" id="fichier" name="fichier" value="" /> <br>
    <input type="submit" value="Valider"  class="sansLabel" />
      <br />
  
     </fieldset>
 

      </form>
      </div>
<jsp:include page="/footer.jsp" />
</body>
</html>