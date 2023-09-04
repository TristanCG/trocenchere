<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Troc Enchère - Créer un compte</title>
</head>
<body>
	 <form method="POST" action="accueil">
	<label for="pseudo">pseudo :</label><br>
	<input type="text" name="pseudo" id="pseudo"><br>
	
	<label for="prenom">prénom :</label><br>
	<input type="text" name="prenom" id="prenom"><br>
	
	<label for="telephone">Teléphone :</label><br>
	<input type="tel" name="telephone" id="telephone"><br>
	
	<label for="codepostal">Code postale  :</label><br>
	<input type="number" name="codepostal" id="codepostal"><br>
	
	<label for="motDePasse">Mot de passe :</label><br>
	<input type="password" name="motDePasse" id="motDePasse"><br>
	<input type="submit">
</form>

<a href="accueil">Créer un compte</a> 
</body>
</html> 