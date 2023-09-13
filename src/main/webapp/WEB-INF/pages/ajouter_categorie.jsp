<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>

<body>
  <div class="videTopBackgroundEmpty">
  </div>
	<main>
	
	    <header>
	        <nav>
	            <ul>
	                <c:if test="${sessionScope.administrateur == true}">
	                    <li><a href="categories">Catégories</a></li>
	                </c:if>
	                <c:if test="${empty sessionScope.noUtilisateur}">
	                    <li><a href="connexion">S'inscrire - Se connecter</a></li>
	                </c:if>
	                <c:if test="${not empty sessionScope.noUtilisateur}">
	                    <li><a href="#">Enchère</a></li>
	                    <li><a href="vendre">Vendre un article</a></li>
	                    <li><a href="profil?noUtilisateur=<c:out value="${sessionScope.noUtilisateur}" />">Mon profil</a></li>
	                    <li><a href="deconnexion">Déconnexion</a></li>
	                </c:if>
	            </ul>
	        </nav>
	    </header>
    	
    	<section>
			<form action="ajouter_categorie" method="post">
				<c:if test="${action eq 'update'}">
					<input type="hidden" name="action" value="update">
					<input type="hidden" name="noCategorie" value="${categorie.noCategorie}">
				</c:if>
				<c:if test="${action eq 'insert'}">
					<input type="hidden" name="action" value="insert">
				</c:if>
				<label for="libelle">Libelle :</label> <input type="text" name="libelle" id="libelle" value="${categorie.libelle}">
				<button type="submit" value="Enregistrer" class="btn btn-primary">Enregistrer</button>
			</form>
			
			<br> <a href="accueil">Accueil</a>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	    </section>

	</main>
</body>
</html>