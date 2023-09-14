<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Troc Enchère - Créer un compte</title>

</head>
<body>

	<div class="videTopBackgroundEmpty"></div>

	<main>
		<header>
			<nav>
			<a href="accueil"><img src="images/auction.png" alt="logo pris en opensource pour Troc Enchère"/></a>
				<ul>
					<c:if test="${sessionScope.administrateur == true}">
						<li><a href="categories">Catégories</a></li>
					</c:if>
					<li><a href="accueil">Enchère</a></li>
					<c:if test="${not empty sessionScope.noUtilisateur}">
						<li><a href="vendre">Vendre un article</a></li>
						<li><a href="profil?noUtilisateur=<c:out value="${sessionScope.noUtilisateur}" />">Mon profil</a></li>
					</c:if>
				</ul>
				<c:if test="${empty sessionScope.noUtilisateur}">
					<a href="connexion"><img src="./images/connexion.png" alt="logo connexion"/></a>
				</c:if>
				<c:if test="${not empty sessionScope.noUtilisateur}">
					<a href="deconnexion"><img src="./images/deconnexion.png" alt="logo déconnexion"/></a>
				</c:if>
			</nav>
			<c:if test="${action eq 'update'}">
				<h1>Troc Enchère - Modifier ${utilisateur.pseudo}</h1>
			</c:if>
			<c:if test="${action eq 'insert'}">
				<h1>Troc Enchère - Créer un compte</h1>
			</c:if>
			
		</header>
		<section>
		<img src="./images/organique2.png" class="organique">

			<form method="POST" action=creeruncompte>
				<c:if test="${action eq 'update'}">
					<input type="hidden" name="action" value="update">
					<input type="hidden" name="noUtilisateur" value="${utilisateur.noUtilisateur}">
				</c:if>
				<c:if test="${action eq 'insert'}">
					<input type="hidden" name="action" value="insert">
				</c:if>
				
				<div class="input_container">
					<label for="pseudo">Pseudo :</label>
					<input type="text" name="pseudo" id="pseudo" value="${utilisateur.pseudo}">
				</div>
				<div class="input_container">
					<label for="nom">Nom :</label>
					<input type="text" name="nom" id="nom" value="${utilisateur.nom}">
				</div>
				<div class="input_container">
					<label for="prenom">Prénom :</label>
					<input type="text" name="prenom" id="prenom" value="${utilisateur.prenom}">
				</div>
				<div class="input_container">
					<label for="email">Email :</label>
					<input type="email" name="email" id="email" value="${utilisateur.email}">
				</div>
				<div class="input_container">
					<label for="telephone">Teléphone :</label> 
					<input type="tel" name="telephone" id="telephone" value="${utilisateur.telephone}">
				</div>
				<div class="input_container">
					<label for="rue">Rue :</label>
					<input type="text" name="rue" id="rue" value="${utilisateur.rue}">
				</div>
				<div class="input_container">
					<label for="codePostal">Code postale :</label>
					<input type="text" name="codePostal" id="codePostal" value="${utilisateur.codePostal}">
				</div>
				<div class="input_container">
					<label for="ville">Ville :</label>
					<input type="text" name="ville" id="ville" value="${utilisateur.ville}">
				</div>
				<c:if test="${action eq 'update'}">
				<div class="input_container">
						<label for="motDePasseActuel">Mot de passe Actuel:</label>
						<input type="password" name="motDePasseActuel" id="motDePasseActuel" value="">
				</div>
				</c:if>
				<div class="input_container">
					<label for="motDePasse">Mot de passe :</label>
					<input type="password" name="motDePasse" id="motDePasse" value="">
				</div>
				<div class="input_container">
					<label for="confirmationMotDePasse">Confirmation :</label>
					<input type="password" name="confirmationMotDePasse" id="confirmationMotDePasse" value="">
				</div>
				
				<div>
					<div>
						<c:choose>
							<c:when test="${action eq 'update'}">
								<input type="submit" value="Modifier" name="creerUnCompte">
							</c:when>
							<c:otherwise>
								<input type="submit" value="Créer" name="creerUnCompte" class="bouton">
							</c:otherwise>
						</c:choose>
					</div>
					<c:if test="${action eq 'update'}">
						<div>
							<a href="creeruncompte?delete&noUtilisateur=${utilisateur.noUtilisateur}" class="bouton boutton_red">Supprimer</a>
						</div>
					</c:if>
					<div>
						<a href="accueil" class="bouton">Annuler</a>
					</div>
				</div>
			</form>
		</section>
	</main>
</body>
</html>