<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendre un article</title>
</head>
<body>

	<h1>Nouvelle vente</h1>
	
	<form method="POST" action="vendre">
	
	<label for="nomArticle">Article :</label>
	<input type="text" name="nomArticle" id="nomArticle">
	<br>
	
	<label for="description">Description :</label>
	<textarea id="description" name="description" rows="5" cols="33">
	</textarea>
	<br>

	<label for="categorie">Catégorie :</label>
	<select name="categorie" id="categorie">
	  <option value="1">Informatique</option>
	  <option value="2">Ameublement</option>
	  <option value="3">Vêtement</option>
	  <option value="4">Sport et Loisirs</option>
	</select>
	<br>
	
	<input type="file" />
	<br>
	
	<label for="prixInitial">Mise à prix :</label>
	<input type="number" id="prixInitial" name="prixInitial"/>
	<br>
	
	<label for="dateDebutEncheres">Début de l'enchère :</label>
	<input type="date" id="dateDebutEncheres" name="dateDebutEncheres"/>
	<br>
	
	<label for="dateFinEncheres">Fin de l'enchère :</label>
	<input type="date" id="dateFinEncheres" name="dateFinEncheres"/>
	<br>
	
	<h2>Retrait</h2>

<!-- TODO : PAR DEFAUT CE SERA LE LIEU DU VENDEUR  -->

	<label for="rue">Rue :</label>
	<input type="text" name="rue" id="rue">
	<br>
	
	<label for="codePostal">Code Postal :</label>
	<input type="text" name="codePostal" id="codePostal">
	<br>
	
	<label for="ville">Ville :</label>
	<input type="text" name="ville" id="ville">
	<br>
	
	<input type="submit">
	<a href="accueil">Annuler</a>
	
</form>
</body>
</html>