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
	<label for="nom">Nom :</label><br>
	<input type="text" name="nom" id="nom"><br>
	
	<label for="email">Email :</label><br>
	<input type="email" name="email" id="email"><br>
	
	<label for="rue">Rue :</label><br>
	<input type="text" name="rue" id="rue"><br>
	
	<label for="ville">Ville :</label><br>
	<input type="text" name="ville" id="ville"><br>
	
	<label for="confirmationMotDePasse">Confirmation :</label><br>
	<input type="password" name="confirmationMotDePasse" id="confirmationMotDePasse"><br>
</form>

<a href="accueil">Annuler</a>
</body>
</html>