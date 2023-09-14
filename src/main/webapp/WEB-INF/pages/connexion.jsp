<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<meta charset="UTF-8">
<title>Troc Enchère - Connexion</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

	<div class="videTopBackgroundEmpty"></div>

	<main>
		<header>
			<nav>
			<a href="accueil"><img src="images/auction.png" alt="logo pris en opensource pour Troc Enchère"/></a>
				<ul>
					<li><a href="accueil">Enchère</a></li>
				</ul>
				<a href="connexion"><img src="./images/connexion.png" alt="logo connexion"/></a>
			</nav>
			<h1>Troc Enchère - Connexion</h1>
		</header>
	
		<section>
			<form method="POST" action="connexion">
				<div>
					<div class="input_container">
						<label for="identifiant">Identifiant : </label>
						<input type="text" placeholder="Identifiant" name="identifiant" id="identifiant">
					</div>
					<div class="input_container">
						<label for="motDePasse">Mot de passe : </label>
						<input type="password" name="motDePasse" id="motDePasse" placeholder="Mot De Passe">
					</div>
				</div>
				
				<div class="form-check input-group">
				    <input class="form-check-input" type="checkbox" value="" id="souvenir">
				    <label class="form-check-label" for="souvenir"> Se souvenir de moi </label>
				</div>

				<button type="submit" class="input-submit btn btn-dark">Envoyer</button>

			</form>
			<a href="#" class="link-danger">Mot de passe oublié</a> <br> 
			<a href="creeruncompte">Créer un compte</a>
		</section>
	</main>
</body>
</html>