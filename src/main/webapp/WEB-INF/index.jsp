<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis./css2?family=Marriweather&family=Raleway&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Troc enchère</title>
</head>

<body>
	<div class="videTopBackgroundEmpty"></div>
	<main>
		<header>

	        <nav>
		        <a href="accueil"><img src="images/auction.png" alt="logo pris en opensource pour Troc Enchère"/></a>
		            <ul>
		                <c:if test="${sessionScope.administrateur == true}">
		                    <li><a href="categories">Catégories</a></li>
		                </c:if>
		                
		                
		                    <li><a href="accueil">Enchère</a></li>
		                 <c:if test="${not empty sessionScope.noUtilisateur}">
		                    <li><a href="vendre">Vendre un article</a></li>
		                    <li><a href="profil?noUtilisateur=<c:out value="${sessionScope.noUtilisateur}" />">Mon profil</a></li>
		                </c:if>
		            </ul>
		        <c:if test="${empty sessionScope.noUtilisateur}">
		            <a href="connexion"><img src="./images/connexion.png" alt="logo connexion"/></a>
		        </c:if>
		        <c:if test="${not empty sessionScope.noUtilisateur}">
		            <a href="deconnexion"><img src="./images/deconnexion.png" alt="logo déconnexion"/></a>
		        </c:if>
	        </nav>

			<h1>Troc Enchère - Accueil</h1>

			<c:if test="${not empty sessionScope.noUtilisateur}">
				<div class="welcome"> Bienvenue,<c:out value="${sessionScope.pseudo}" /></div>
			</c:if>
		</header>


		<section class="accueil">
			<div class="formulairerecherche">
				<form action="accueil" method="POST">
					<label for="nomRecherche">Filtres :</lablel> <input type="text" name="nomRecherche" id="nomRecherche" placeholder="Le nom de l'article contient"> <label for="categorieRecherche">Catégorie :</label> 
					<select name="categorieRecherche" id="categorieRecherche">
							<c:forEach items="${categories}" var="categorie">
								<option value="${categorie.noCategorie}">${categorie.libelle}</option>
							</c:forEach>
					</select> <c:if test="${not empty sessionScope.noUtilisateur}">
							<div class="achat">
								<input type="radio" name="typeRecherche" id="achatsRecherche" value="achats" checked>
								<label for="achatsRecherche">Achats</label>
								<input type="checkbox" name="achats1" id="achats1" value="achats1">
								<label for="achats1">enchères ouvertes</label>
								<input type="checkbox" name="achats2" id="achats2" value="achats2">
								<label for="achats2">mes enchères</label>
								<input type="checkbox" name="achats3" id="achats3" value="achats3">
								<label for="achats3">mes enchères remportées</label>
							</div>
							<div class="ventes">
								<input type="radio" name="typeRecherche" id="ventesRecherche" value="ventes">
								<label for="ventesRecherche">Ventes</label>
								<input type="checkbox" name="ventes1" id="ventes1" value="ventes1">
								<label for="ventes1">mes ventes en cours</label>
								<input type="checkbox" name="ventes2" id="ventes2" value="ventes2">
								<label for="ventes2">ventes non débutées</label>
								<input type="checkbox" name="ventes3" id="ventes3" value="ventes3">
								<label for="ventes3">ventes terminées</label>
							</div>
						</c:if> 
						<div>
							<input type="submit" value="Rechercher">
						</div>
				</form>
			</div>


			<h2>Liste des enchères</h2>
			<div class="container">
				<div class="row">
					<c:forEach var="article" items="${articlesvendus}">
						<div class="col-xl-4 col-lg-4 col-md-6 col-sm-12">
							<a href="encherir?noArticle=${article.noArticle}">
								<div class="card" style="width: 18rem;">
									<img src="images/photo-enchere.jpg" class="card-img-top"
										alt="Photo Open-source d'une enchère">
									<div class="card-body">
										<h5 class="card-title">${article.nomArticle}</h5>
										<p class="card-text">Prix de vente : ${article.prixVente}
											crédits</p>
										<p class="card-text">Date de fin de l'enchère :
											${article.dateFinEncheres}</p>
										<div class="d-flex justify-content-between">
											<a href="profil?noUtilisateur=${article.utilisateur.noUtilisateur}" 
											class="btn btn-dark"> ${article.utilisateur.pseudo}</a>
										</div>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>


	</main>
</body>
</html>