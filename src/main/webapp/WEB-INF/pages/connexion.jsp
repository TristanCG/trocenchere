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
	<label for="identifiant">Identifiant :</label><br>
	<input type="text" name="identifiant" id="identifiant"><br>
	<label for="motDePasse">Mot de passe :</label><br>
	<input type="text" name="motDePasse" id="motDePasse"><br>
	
	<input type="checkbox" name="souvenir" id="souvenir"><label for="souvenir"> Se souvenir de moi</label><br>
	<input type="submit">
</form>
<a href="#">Mot de passe oublié</a>

<a href="creeruncompte">Créer un compte</a>
</body>
</html>