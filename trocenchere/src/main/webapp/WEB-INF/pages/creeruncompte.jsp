<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Troc Enchère - Créer un compte</title>
	<style>
		form{
			display: flex;
			flex-wrap: wrap;
			flex-direction: column;
		}
		form div{
			display: flex;
			flex-wrap: nowrap;
			gap: 50px;
			margin: 0 0 10px 0;
		}
		form label{
			diplay:block;
			width:100px;
		}
	</style>
</head>
<body>
<form method="POST" action=creeruncompte>
    	<c:if test="${action eq 'update'}">
		    <input type="hidden" name="action" value="update">
		    <input type="hidden" name="noUtilisateur" value="${utilisateur.noUtilisateur}">   
		</c:if>
    	<c:if test="${action eq 'insert'}">
		    <input type="hidden" name="action" value="insert">
		</c:if>
	<div>
		<div>
			<label for="pseudo">Pseudo :</label>
			<input type="text" name="pseudo" id="pseudo" value="${utilisateur.pseudo}">
		</div>
		<div>
			<label for="nom">Nom :</label>
			<input type="text" name="nom" id="nom" value="${utilisateur.nom}">
		</div>
	</div>
	<div>
		<div>
			<label for="prenom">Prénom :</label>
			<input type="text" name="prenom" id="prenom" value="${utilisateur.prenom}">
		</div>
		<div>
			<label for="email">Email :</label>
			<input type="email" name="email" id="email" value="${utilisateur.email}">
		</div>
	</div>
	<div>
		<div>
			<label for="telephone">Teléphone :</label>
			<input type="tel" name="telephone" id="telephone" value="${utilisateur.telephone}">
		</div>
		<div>
			<label for="rue">Rue :</label>
			<input type="text" name="rue" id="rue" value="${utilisateur.rue}">
		</div>
	</div>
	<div>
		<div>
			<label for="codePostal">Code postale  :</label>
			<input type="text" name="codePostal" id="codePostal" value="${utilisateur.codePostal}">
		</div>
		<div>
			<label for="ville">Ville :</label>
			<input type="text" name="ville" id="ville" value="${utilisateur.ville}">
		</div>
	</div>
    <c:if test="${action eq 'update'}">
		<div>
			<div>
				<label for="motDePasseActuel">Mot de passe Actuel:</label>
				<input type="password" name="motDePasseActuel" id="motDePasseActuel" value="">
			</div>
			<div>
			</div>
		</div> 
	</c:if>
	<div>
		<div>
			<label for="motDePasse">Mot de passe :</label>
			<input type="password" name="motDePasse" id="motDePasse" value="">
		</div>
		<div>
			<label for="confirmationMotDePasse">Confirmation :</label>
			<input type="password" name="confirmationMotDePasse" id="confirmationMotDePasse" value="">
		</div>
	</div>
	<div>
		<div>
			<c:choose>
			    <c:when test="${action eq 'update'}">
			        <input type="submit" value="Modifier" name="creerUnCompte">
			    </c:when>
			    <c:otherwise>
					<input type="submit" value="Créer" name="creerUnCompte">
			    </c:otherwise>
			</c:choose>
		</div>
    	<c:if test="${action eq 'update'}">
			<div>
				<a href="creeruncompte?delete&noUtilisateur=${utilisateur.noUtilisateur}">Supprimer</a>
			</div>
		</c:if>
		<div>
			<a href="accueil">Annuler</a>
		</div>
	</div>
</form>
</body>
</html> 