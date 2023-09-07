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
<c:if test="${empty sessionScope.noUtilisateur}">
		<a href="connexion">S'inscrire - Se connecter</a>
</c:if>
<c:if test="${not empty sessionScope.noUtilisateur}">
	<a href="#">Enchère</a>
	<a href="vendre">Vendre un article</a>
	<a href="#">Mon profil</a>
	<a href="#">Déconnexion</a>

    <div>Bienvenue, <c:out value="${sessionScope.pseudo}" /> vous êtes = <c:out value="${sessionScope.administrateur}" /></div>


	<div>
	</div>
</c:if>

<c:if test="${sessionScope.administrateur == true}">
		A conditionner pour la page Admin
		<a href="categories">Catégories</a>
</c:if>

</header>

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