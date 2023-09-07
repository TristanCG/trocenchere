<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/vendre.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis./css2?family=Marriweather&family=Raleway&display=swap"
	rel="stylesheet">
<title>Vendre un article</title>
</head>
<body>

	<h1>Nouvelle vente</h1>

	<form method="POST" action="vendre">

		<label for="nomArticle">Article :</label> <input type="text"
			name="nomArticle" id="nomArticle" value="test"> <br> <label
			for="description">Description :</label>
		<textarea id="description" name="description" rows="5" cols="35">tagada</textarea>
	
		<br> <label for="categorie">Catégorie :</label> 
		<select name="categorie" id="categorie">
			<c:forEach items="${categories}" var="categorie">
				<option value="${categorie.noCategorie}">${categorie.libelle}</option>
			</c:forEach>
		</select>
		
		<br> <input type="file" /> <br> <label for="prixInitial">Mise
			à prix :</label> <input type="number" id="prixInitial" name="prixInitial" />
		<br> <label for="dateDebutEncheres">Début de l'enchère :</label>
		<input type="date" id="dateDebutEncheres" name="dateDebutEncheres" value="2023-09-06"/>
		<br> <label for="dateFinEncheres">Fin de l'enchère :</label> <input
			type="date" id="dateFinEncheres" name="dateFinEncheres" value="2023-09-06"/> <br>

		<h2>Retrait</h2>

		<!-- TODO : PAR DEFAUT CE SERA LE LIEU DU VENDEUR  -->

		<label for="rue">Rue :</label> <input type="text" name="rue" id="rue">
		<br> <label for="codePostal">Code Postal :</label> <input
			type="text" name="codePostal" id="codePostal"> <br> <label
			for="ville">Ville :</label> <input type="text" name="ville"
			id="ville"> <br> <input type="submit"> <a
			href="accueil">Annuler</a>

	</form>
</body>
</html>