<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<meta charset="UTF-8">
<title>Troc Enchère - Connction</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

	<div class="videTopBackgroundEmpty"></div>

	<main>
		<header>
			<h1>Troc Enchère - Connexion</h1>
		</header>
	
		<section>
			<form method="POST" action="connexion">

				<div class="form-group row">
					<label for="identifiant" class="col-sm-12 col-form-label">Identifiant :</label><br>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="identifiant" id="identifiant" placeholder="identifiant">
					</div>
				</div>


				<div class="form-group row">
					<label for="lastName" class="col-sm-12 col-form-label">Mot de passe :</label>
					<div class="col-sm-7">
						<input type="password" class="form-control" name="motDePasse" id="motDePasse" placeholder="Mot De Passe">
					</div>
				</div>


				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="souvenir">
					<label class="form-check-label" for="souvenir"> Se souvenir de moi </label>
				</div>

				<button type="submit" class="btn btn-dark">Envoyer</button>

			</form>
			<a href="#" class="link-danger">Mot de passe oublié</a> <br> 
			<a href="creeruncompte">Créer un compte</a>
		</section>
	</main>
</body>
</html>