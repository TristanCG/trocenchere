<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Troc Enchere - Encherir</title>
</head>
<body>
	<h1>D�tail de la vente</h1>
	<table>
		<tr>
			<th>Titre</th>
			<td>${articleVendu.nomArticle}</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>${articleVendu.description}</td>
		</tr>
		<tr>
			<th>Cat�gorie</th>
			<td>${articleVendu.noCategorie}</td>
		</tr>
		<tr>
			<th>Meilleur offre</th>
			<td>${articleVendu.prixVente} pts par</td>
		</tr>
		<tr>
			<th>Mise � prix</th>
			<td>${articleVendu.prixInitial} points</td>
		</tr>
		<tr>
			<th>Fin de l'ench�re</th>
			<td>${articleVendu.dateFinEncheres}</td>
		</tr>
		<tr>
			<th>Retrait</th>
			<td></td>
		</tr>
		<tr>
			<th>Vendeur</th>
			<td>${articleVendu.noUtilisateur}</td>
		</tr>
	</table>
	<a href="accueil">Retour</a>
</body>
</html>