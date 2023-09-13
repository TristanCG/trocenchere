<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<meta charset="UTF-8">
<title>Troc enchere - Catégories</title>
</head>

<body>
	<div class="videTopBackgroundEmpty"></div>
	<main>

	    <header>
	        <nav>
	            <ul>
	                <c:if test="${sessionScope.administrateur == true}">
	                    <li><a href="categories">Catégories</a></li>
	                </c:if>
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
	    </header>

		<section>
			<a href="ajouter_categorie">Ajouter une catégories </a>
			<table>
				<tr>
					<th>Numéro</th>
					<th>Nom</th>
					<th>Supprimer</th>
				</tr>
				<c:forEach items="${categories }" var="categories">
					<tr>
						<td>${categories.noCategorie }</td>
						<td><a href="ajouter_categorie?noCategorie=${categories.noCategorie }">${categories.libelle }</a></td>
						<td><a href="ajouter_categorie?supprimer=${categories.noCategorie }">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
			<a href="accueil">Accueil</a>
		</section>

	</main>
</body>
</html>