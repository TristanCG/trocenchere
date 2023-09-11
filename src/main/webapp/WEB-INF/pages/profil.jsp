<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Troc Enchere - Profil ${utilisateur.pseudo}</title>
</head>
<body>
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
		<a href="creeruncompte?update&noUtilisateur=<c:out value="${utilisateur.noUtilisateur}" />">Modifier</a>
	</c:if>
	<a href="accueil">Accueil</a>

</body>
</html>