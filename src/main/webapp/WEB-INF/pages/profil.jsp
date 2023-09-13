<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Troc Enchere - Profil ${utilisateur.pseudo}</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	
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
			<li><a href="connexion"><img src="./images/connexion.png" alt="logo connexion"/></a></li>
		</c:if>
		<c:if test="${not empty sessionScope.noUtilisateur}">
			<a href="deconnexion"><img src="./images/deconnexion.png" alt="logo déconnexion"/></a>
		</c:if>
		</nav>
	</header>
	<section>
	<h1>Profil</h1>
	<table>
		<tr>
			<th>Pseudo</th>
			<td><c:out value="${utilisateur.pseudo}" /></td>
		</tr>
		<tr>
			<th>Nom</th>
			<td><c:out value="${utilisateur.nom}" /></td>
		</tr>
		<tr>
			<th>Prénom</th>
			<td><c:out value="${utilisateur.prenom}" /></td>
		</tr>
		<tr>
			<th>Email</th>
			<td><c:out value="${utilisateur.email}" /></td>
		</tr>
		<tr>
			<th>Téléphone</th>
			<td><c:out value="${utilisateur.telephone}" /></td>
		</tr>
		<tr>
			<th>Rue</th>
			<td><c:out value="${utilisateur.rue}" /></td>
		</tr>
		<tr>
			<th>Code postal</th>
			<td><c:out value="${utilisateur.codePostal}" /></td>
		</tr>
		<tr>
			<th>Ville</th>
			<td><c:out value="${utilisateur.ville}" /></td>
		</tr>
	</table>
	
	
	<c:if test="${sessionScope.noUtilisateur == utilisateur.noUtilisateur}">
		<a href="creeruncompte?update&noUtilisateur=<c:out value="${utilisateur.noUtilisateur}"/>" class="btn btn-dark">Modifier</a>
	</c:if>
	<a href="accueil" class="btn btn-dark">Accueil</a>
	</section>
</main>


</body>
</html>