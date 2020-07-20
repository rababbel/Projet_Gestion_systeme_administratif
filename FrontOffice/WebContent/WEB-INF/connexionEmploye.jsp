<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
 <html>    
 <head>        
 <meta charset="utf-8" />        
<title>Connexion</title>        
<link type="text/css" rel="stylesheet" href="inc/main.css" />   
<link type="text/css" rel="stylesheet" href="inc/style.css" />   
</head>    
<body>
<div class="filter"></div> 
<div class="login">       
<form method="post" action="ConnexionEmploye">             
<h1>LOG IN</h1>                               
 <input class="input" type="text" placeholder="username" name="nom"><br>  
<span class="erreur">${form.erreurs['nom']}</span>               
<br /> 
<input class="input" type="password" placeholder="Password" name="motdepasse"><br>                               
<span class="erreur">${form.erreurs['motdepasse']}</span>                
<br />   
  <select name="role" id="role" >
  <option value="employe">Employe</option>
   <option value="chef">chef de division</option>
  </select>
  <br>
 <input type="submit" value="Log in" class="sansLabel" />                
 <br />                
 <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>                    
 </form>  
 </div>  
 <jsp:include page="/footer.jsp" />
 </body> 
 </html>