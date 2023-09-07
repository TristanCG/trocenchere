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
	<c:if test="${sessionScope.administrateur == true}">
		<nav class="admin">
			<ul>
				<li><a href="categories">Catégories</a></li>
			</ul>
		</nav>
	</c:if>
	
	<nav>
		<ul>
			<c:if test="${empty sessionScope.noUtilisateur}">
				<li><a href="connexion">S'inscrire - Se connecter</a></li>
			</c:if>
			<c:if test="${not empty sessionScope.noUtilisateur}">
				<li><a href="#">Enchère</a></li>
				<li><a href="vendre">Vendre un article</a></li>
				<li><a href="#">Mon profil</a></li>
				<li><a href="deconnexion">Déconnexion</a></li>
			</c:if>
		</ul>
	</nav>
	
	<h1>Troc Enchère - Accueil</h1>
	
	<c:if test="${not empty sessionScope.noUtilisateur}">
	    <div>Bienvenue, <c:out value="${sessionScope.pseudo}" /> vous êtes = <c:out value="${sessionScope.administrateur}" /></div>
	</c:if>
</header>

<section class="accueil">
	<h2>Liste des enchères</h2>

</section>



</body>
</html>