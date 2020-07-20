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
<div class="filter"></div>
<div class="form">
<form action="GestionEtapeDecision">
<fieldset>
<legend>prendre decision</legend>
<select name="decision" multiple="multiple">
<option value="accept">Accept</option>
<option  value="maj">Mis a jour</option>
<option value="refus">Refus</option>
<option value="rejet">Rejet</option>
</select>
<br>
<label for="rapport">Rediger un rapport:</label><br>
<textarea rows="5" cols="30"></textarea><br>
<input type="submit" value="valider" class="sansLabel" />
</fieldset>

</form>
</div>
</body>
</html>