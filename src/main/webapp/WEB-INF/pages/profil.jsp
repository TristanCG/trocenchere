<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Troc Enchere - Profil ${utilisateur.pseudo}</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
<!-- 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous"> -->
	
	</head>
<body>
<div class="videTopBackgroundEmpty">
</div>
<main>
	<header>
		<nav>
		<a href="accueil"><img src="images/auction.png" alt="logo pris en opensource pour Troc Enchère"/></a>
			<ul>
				<c:if test="${sessionScope.administrateur == true}">
					<li><a href="categories">Catégories</a></li>
				</c:if>
				
				<c:if test="${not empty sessionScope.noUtilisateur}">
					<li><a href="accueil">Enchère</a></li>
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
		
		<h1>Profil de ${utilisateur.pseudo}
		<c:if test="${sessionScope.noUtilisateur == utilisateur.noUtilisateur}">
			<a href="creeruncompte?update&noUtilisateur=<c:out value="${utilisateur.noUtilisateur}"/>" class="bouton modifier">Modifier</a>
		</c:if></h1>
	</header>
	<section>
	
	
	<div class="profil_container">
		<div>
			<h1>Identité</h1>
		</div>
		<div>
			<div>Nom : </div>
			<div>${utilisateur.nom}</div>
		</div>
		<div>
			<div>Prénom : </div>
			<div>${utilisateur.prenom}</div>
		</div>
	</div>
	<div class="profil_container">
		<div>
			<h1>Contact</h1>
		</div>
		<div>
			<div>Email : </div>
			<div>${utilisateur.email}</div>
		</div>
		<div>
			<div>Téléphone : </div>
			<div>${utilisateur.telephone}</div>
		</div>
	</div>
	
	<div class="profil_container">
		<div>
			<h1>Adresse</h1>
		</div>
		<div>
			<div>Rue : </div>
			<div>${utilisateur.rue}</div>
		</div>
		<div>
			<div>Code Postal : </div>
			<div>${utilisateur.codePostal}</div>
		</div>
		<div>
			<div>Ville : </div>
			<div>${utilisateur.ville}</div>
		</div>
	</div>
	
	
	
	
	</section>
</main>


</body>
</html>