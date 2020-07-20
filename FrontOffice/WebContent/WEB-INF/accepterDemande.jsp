<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link type="text/css" rel="stylesheet" href="inc/style.css"/>
</head>
<body>
<div class="form">
<form method="post" action="">
   <fieldset>                    
   <legend>accepter Demande</legend>  
   <p>      
    <label for="demande">Choisir une demande</label><br /> 
     <select name="demande" id="demande" multiple="multiple" tabindex="30">  
     
     <c:forEach var="dem" items="${demande}">
     <option> <c:out value="${dem}"/></option>
     </c:forEach>
                    
     </select>   </p>
 <p>
          
          
 </p>
    <br />
    <input type="submit" value="accepter"  class="sansLabel" />
     
     </fieldset>
 
      </form>
      </div>
<jsp:include page="/footer.jsp" />
</body>
</html>