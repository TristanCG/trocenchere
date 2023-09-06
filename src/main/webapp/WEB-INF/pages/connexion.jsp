<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Troc Enchère - Connction</title>
</head>
<body>
<form method="POST" action="connexion">
	<label for="email">Identifiant :</label><br>
	<input type="email" name="email" id="email"><br>
	<label for="motDePasse">Mot de passe :</label><br>
	<input type="text" name="motDePasse" id="motDePasse"><br>
	<input type="submit">
</form>
<a href="creeruncompte">Créer un compte</a>
</body>
</html>