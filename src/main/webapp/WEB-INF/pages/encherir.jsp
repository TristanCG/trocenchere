<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Troc Enchere - Encherir</title>
</head>
<body>
	<h1>Détail de la vente</h1>
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
			<th>Catégorie</th>
			<td>${categorie.libelle}</td>
		</tr>
		<tr>
			<th>Meilleur offre</th>
			
			<c:if test="${enchere != null}">
			    <td>${enchere.montantEnchere} pts par ${utilisateurEnchere.pseudo}</td>
			</c:if>
			<c:if test="${enchere == null}">
			    <td>Aucune offre</td>
			</c:if>
		</tr>
		<tr>
			<th>Mise à prix</th>
			<td>${articleVendu.prixInitial} points</td>
		</tr>
		<tr>
			<th>Fin de l'enchère</th>
			<td>${articleVendu.dateFinEncheres}</td>
		</tr>
		<tr>
		    <th>Retrait</th>
		    <td>
		        <c:if test="${not empty retrait}">
		            ${retrait.rue} - ${retrait.codePostal} ${retrait.ville}
		        </c:if>
		        <c:if test="${empty retrait}">
		            ${utilisateur.rue} - ${utilisateur.codePostal} ${utilisateur.ville} 
		        </c:if>
		    </td> 
		</tr> 
		<tr>
			<th>Vendeur</th>
			<td>${utilisateur.pseudo}</td>
		</tr>
		
		<c:if test="${condition eq 'ok'}">
			<tr>
				<form action="encherir" method="POST">
					<th><label for="proposition">Ma proposition</label></th>
					<td><input type="number" name="proposition" id="proposition" value="">
					<input type="hidden" name="noArticle" value="${articleVendu.noArticle}"></td>
					<td><input type="submit" value="Encherir"></td>		
				</form>
			</tr>
		</c:if>
		
	</table>
	<c:if test="${noUtilisateur == utilisateur.noUtilisateur}">
		<a href="encherir?supprimer=${articleVendu.noArticle}">Supprimer l'enchère</a>
	</c:if>
	<a href="accueil">Annuler</a>
	
</body>
</html>