<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Troc Enchère - Créer un compte</title>
	<style>
		form{
			display: flex;
			flex-wrap: wrap;
			flex-direction: column;
		}
		form div{
			display: flex;
			flex-wrap: nowrap;
			gap: 50px;
			margin: 0 0 10px 0;
		}
		form label{
			diplay:block;
			width:100px;
		}
	</style>
</head>
<body>
<form method="POST" action="accueil">
	<div>
		<div>
			<label for="pseudo">Pseudo :</label>
			<input type="text" name="pseudo" id="pseudo" value="Chantal">
		</div>
		<div>
			<label for="nom">Nom :</label>
			<input type="text" name="nom" id="nom" value="GUILLOU">
		</div>
	</div>
	<div>
		<div>
			<label for="prenom">Prénom :</label>
			<input type="text" name="prenom" id="prenom" value="Tristan">
		</div>
		<div>
			<label for="email">Email :</label>
			<input type="email" name="email" id="email" value="tristan.guillou2023@campus-eni.fr">
		</div>
	</div>
	<div>
		<div>
			<label for="telephone">Teléphone :</label>
			<input type="tel" name="telephone" id="telephone" value="0768589133">
		</div>
		<div>
			<label for="rue">Rue :</label>
			<input type="text" name="rue" id="rue" value="8 avenue Tatatiana">
		</div>
	</div>
	<div>
		<div>
			<label for="codePostal">Code postale  :</label>
			<input type="text" name="codePostal" id="codePostal" value="35000">
		</div>
		<div>
			<label for="ville">Ville :</label>
			<input type="text" name="ville" id="ville" value="Rennes">
		</div>
	</div>
	<div>
		<div>
			<label for="motDePasse">Mot de passe :</label>
			<input type="password" name="motDePasse" id="motDePasse" value="Tatiana">
		</div>
		<div>
			<label for="confirmationMotDePasse">Confirmation :</label>
			<input type="password" name="confirmationMotDePasse" id="confirmationMotDePasse" value="Tatiana">
		</div>
	</div>
	<div>
		<div>
			<input type="submit" value="Créer">
		</div>
		<div>
			<a href="accueil">Annuler</a>
		</div>
	</div>
</form>
</body>
</html> 