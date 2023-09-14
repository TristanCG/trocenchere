<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<meta charset="UTF-8">
<title>Troc Enchere - Encherir</title>
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
			<h1>Détail de la vente</h1>
	    </header>

		<section>
			<img src="./images/photo-enchere.jpg" class="miniature">
			<div class="profil_container">
				<div>
					<h1>Produit</h1>
				</div>
				<div>
					<div>Titre : </div>
					<div>${articleVendu.nomArticle}</div>
				</div>
				<div>
					<div>Description : </div>
					<div>${articleVendu.description}</div>
				</div>
				<div>
					<div>Catégorie : </div>
					<div>${categorie.libelle}</div>
				</div>
				<div>
					<div>Fin de l'enchère : </div>
					<div>${articleVendu.dateFinEncheres}</div>
				</div>
				<div>
					<div>Vendeur : </div>
					<div><a href="profil?noUtilisateur=${utilisateur.noUtilisateur}">${utilisateur.pseudo}</a></div>
				</div>
			</div>
			<div class="profil_container">
				<div>
					<h1>Offre</h1>
				</div>
				<div>
					<div>Meilleure offre : </div>
					<div>
						<c:if test="${enchere != null}">
							<td>${enchere.montantEnchere}pts par ${utilisateurEnchere.pseudo}</td>
						</c:if>
						<c:if test="${enchere == null}">
							<td>Aucune offre</td>
						</c:if>
					</div>
				</div>
				<div>
					<div>Mise à prix : </div>
					<div>${articleVendu.prixInitial} points</div>
				</div>
			</div>
			<div class="profil_container">
				<div>
					<h1>Retrait</h1>
				</div>
				<div>
					<div>Adresse : </div>
					<div> 
						<c:if test="${not empty retrait}"> 
							${retrait.rue}
				        </c:if> 
				        <c:if test="${empty retrait}"> 
				        	${utilisateur.rue}
				        </c:if>
					</div>
				</div>
				<div>
					<div>Ville : </div>
					<div> 
						<c:if test="${not empty retrait}"> 
							${retrait.codePostal} - ${retrait.ville}
				        </c:if> 
				        <c:if test="${empty retrait}"> 
				        	${utilisateur.codePostal} - ${utilisateur.ville} 
				        </c:if>
					</div>
				</div>
			</div>
	
	
			<c:if test="${condition eq 'ok'}">
				<tr>
					<form action="encherir" method="POST">
						<th><label for="proposition">Ma proposition</label></th>
						<td><input type="number" name="proposition" id="proposition"
							value=""> <input type="hidden" name="noArticle"
							value="${articleVendu.noArticle}"></td>
						<td><input type="submit" value="Encherir"></td>
					</form>
				</tr>
			</c:if>
			<c:if test="${noUtilisateur == utilisateur.noUtilisateur}">
				<a href="encherir?supprimer=${articleVendu.noArticle}">Supprimer l'enchère</a>
			</c:if>
			<a href="accueil">Annuler</a>
		</section>

	</main>
</body>
</html>