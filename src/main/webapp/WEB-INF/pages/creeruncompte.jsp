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
			<label for="pseudo">pseudo :</label>
			<input type="text" name="pseudo" id="pseudo">
		</div>
		<div>
			<label for="nom">Nom :</label>
			<input type="text" name="nom" id="nom">
		</div>
	</div>
	<div>
		<div>
			<label for="prenom">prénom :</label>
			<input type="text" name="prenom" id="prenom">
		</div>
		<div>
			<label for="email">Email :</label>
			<input type="email" name="email" id="email">
		</div>
	</div>
	<div>
		<div>
			<label for="telephone">Teléphone :</label>
			<input type="tel" name="telephone" id="telephone">
		</div>
		<div>
			<label for="rue">Rue :</label>
			<input type="text" name="rue" id="rue">
		</div>
	</div>
	<div>
		<div>
			<label for="codepostal">Code postale  :</label>
			<input type="number" name="codepostal" id="codepostal">
		</div>
		<div>
			<label for="ville">Ville :</label>
			<input type="text" name="ville" id="ville">
		</div>
	</div>
	<div>
		<div>
			<label for="motDePasse">Mot de passe :</label>
			<input type="password" name="motDePasse" id="motDePasse">
		</div>
		<div>
			<label for="confirmationMotDePasse">Confirmation :</label>
			<input type="password" name="confirmationMotDePasse" id="confirmationMotDePasse">
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