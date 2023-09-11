<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Troc enchère</title>
</head>
<body>

	<header>
	<a href="accueil"><img src="images/auction.png" alt="logo pris en opensource pour Troc Enchère" width=5%/></a>
		<c:if test="${sessionScope.administrateur == true}">
			<nav class="admin">
				<ul>
					<li><a href="categories">Catégories</a></li>
				</ul>
			</nav>
		</c:if>
	<nav>
		<ul>
			<c:if test="${empty sessionScope.noUtilisateur}">
				<li><a href="connexion">S'inscrire - Se connecter</a></li>
			</c:if>
			<c:if test="${not empty sessionScope.noUtilisateur}">
				<li><a href="#">Enchère</a></li>
				<li><a href="vendre">Vendre un article</a></li>
				<li><a href="profil?noUtilisateur=<c:out value="${sessionScope.noUtilisateur}" />">Mon profil</a></li>
				<li><a href="deconnexion">Déconnexion</a></li>
			</c:if>
		</ul>
	</nav>
	
	<h1>Troc Enchère - Accueil</h1>
	
	<c:if test="${not empty sessionScope.noUtilisateur}">
	    <div>Bienvenue, <c:out value="${sessionScope.pseudo}" /> vous êtes = <c:out value="${sessionScope.administrateur}" /></div>
	</c:if>
</header>


	<section class="accueil">
		<h2>Liste des enchères</h2>
		


		<table>
			<tr>
				<th>Nom de l'article</th>
				<th>Prix de vente</th>
				<th>Date de fin d'enchères</th>
				<th>Pseudo de l'utilisateur</th>
			</tr>
			<c:forEach var="article" items="${articlesvendus}">
				<tr>
					<td><a href="encherir?noArticle=${article.noArticle}">${article.nomArticle}</a></td>
					<td>${article.prixVente}</td>
					<td>${article.dateFinEncheres}</td>
					<td><a href="profil?noUtilisateur=${article.utilisateur.noUtilisateur}">${article.utilisateur.pseudo}</a></td>
				</tr>
			</c:forEach>
		</table>

	</section>



</body>
</html>