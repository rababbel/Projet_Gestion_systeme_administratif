<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
 <html>
<head>
<meta charset="utf-8" />
<title>Connexion</title>        
<link type="text/css" rel="stylesheet" href="inc/style.css" />    
</head>    
<body> 
<div class="filter"></div> 
<div class="form">    
<form method="post" action="connexionCitoyenVerification">            
<fieldset>                
<legend>Connexion</legend>            
<p>Vous pouvez vous connecter via ce formulaire.</p>               
 <label for="cin">CIN <span class="requis">*</span></label> 
 <input type="text" id="cin" name="cin" value=""  maxlength="60" /> 
 <span class="erreur">${erreur}</span>              
  <br />                                
<input type="submit" value="Connexion" class="sansLabel" /> 
               <br />         
 </fieldset>        
 </form> 
 </div>  
 <jsp:include page="/footer.jsp" />   
 </body> 
 </html>