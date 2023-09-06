<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Troc enchère</title>
</head>
<body>


<header>
	<h1>Troc Enchère - Accueil</h1>
	<div>
		<a href="connexion">S'inscrire - Se connecter</a>
	</div>
	<div>
		<a href="vendre">Vendre un article</a>
	</div>
	<div>
		<a href="categories">Catégories</a>
	</div>
</header>
<c:if test="${not empty sessionScope.prenom}">
    <div>Bienvenue, <c:out value="${sessionScope.prenom}" /></div>
</c:if>
<section class="accueil">
	<h2>Liste des enchères</h2>
	<div class="container">
		<div>
			
		
		</div>
		<div></div>
	</div>
</section>



</body>
</html>