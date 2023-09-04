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


	<input type="submit">

</form>

<a href="accueil">Annuler</a>

<a href="accueil">Créer un compte</a> 
</body>
</html> 