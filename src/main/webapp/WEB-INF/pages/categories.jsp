<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Troc enchere - Catégories</title>
</head>
<body>
	 <a href = "ajouter_categorie">Ajouter une catégories </a>
	 <table>
		 <tr>
		 	<th>Numéro</th>
		 	<th>Nom</th>
		 </tr>
		 <c:forEach items="${categories }" var="categories">
			 <tr>
			 	<td>${categories.noCategorie }</td>
			 	<td><a href="ajouter_categorie?noCategorie=${categories.noCategorie }">${categories.libelle }</a></td>
			 </tr>
		 </c:forEach>
	 </table>
	 <a href="accueil">Accueil</a>
</body>
</html>