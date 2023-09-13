<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis./css2?family=Marriweather&family=Raleway&display=swap"
	rel="stylesheet">
<title>Vendre un article</title>
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
			<h1>Nouvelle vente</h1>

			<form method="POST" action="vendre">

				<table>
					<tr>
						<th><label for="nomArticle">Article :</label></th>
						<td><input type="text" name="nomArticle" id="nomArticle" value="test"></td>
					</tr>
					<tr>
						<th><label for="description">Description :</label></th>
						<td><textarea id="description" name="description" rows="5" cols="35">test</textarea></td>
					</tr>
					<tr>
						<th><label for="categorie">Catégorie :</label></th>
						<td>
							<select name="categorie" id="categorie">
									<c:forEach items="${categories}" var="categorie">
										<option value="${categorie.noCategorie}">${categorie.libelle}</option>
									</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th><label for="photo">Photo :</label></th>
						<td><input type="file" id="photo" /></td>
					</tr>
					<tr>
						<th><label for="prixInitial">Mise à prix :</label></th>
						<td><input type="number" id="prixInitial" name="prixInitial" value="150" /></td>
					</tr>
					<tr>
						<th><label for="dateDebutEncheres">Début de l'enchère :</label></th>
						<td><input type="date" id="dateDebutEncheres" name="dateDebutEncheres" value="2023-09-08" /></td>
					</tr>
					<tr>
						<th><label for="dateFinEncheres">Fin de l'enchère :</label></th>
						<td><input type="date" id="dateFinEncheres" name="dateFinEncheres" value="2023-09-09" /></td>
					</tr>
				</table>

				<h2>Retrait</h2>
				<table>
					<tr>
						<th><label for="rue">Rue :</label></th>
						<td><input type="text" name="rue" id="rue" value="${utilisateur.rue }"></td>
					</tr>
					<tr>
						<th><label for="codePostal">Code Postal :</label></th>
						<td><input type="text" name="codePostal" id="codePostal" value="${utilisateur.codePostal }"></td>
					</tr>
					<tr>
						<th><label for="ville">Ville :</label></th>
						<td><input type="text" name="ville" id="ville" value="${utilisateur.ville }"></td>
					</tr>
				</table>

				<input type="submit"> <a href="accueil">Annuler</a>

			</form>
		</section>

	</main>
</body>
</html>