<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Troc Enchère - Connction</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<form method="POST" action="connexion">


	  <div class="form-group row">
      <label for="identifiant" class="col-sm-12 col-form-label">Identifiant :</label><br>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="identifiant" id="identifiant"
        placeholder="identifiant">
      </div>
     </div>
     
     
      <div class="form-group row">
      <label for="lastName" class="col-sm-12 col-form-label">Mot de passe :</label>
      <div class="col-sm-7"><br>
       <input type="password" class="form-control" name="motDePasse" id="motDePasse"
        placeholder="Mot De Passe">
      </div>
     </div>

	
	  <div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="souvenir">
  <label class="form-check-label" for="souvenir">
    Se souvenir de moi
  </label>
	</div>
	
	<button type="submit" class="btn btn-dark">Envoyer</button>
	
</form>
<a href="#" class="link-danger">Mot de passe oublié</a>
<br>
<a href="creeruncompte">Créer un compte</a>
</body>


<!-- <section class="background-radial-gradient overflow-hidden"> -->
<!--   <style> -->
/*     .background-radial-gradient { */
/*       background-color: hsl(218, 41%, 15%); */
/*       background-image: radial-gradient(650px circle at 0% 0%, */
/*           hsl(218, 41%, 35%) 15%, */
/*           hsl(218, 41%, 30%) 35%, */
/*           hsl(218, 41%, 20%) 75%, */
/*           hsl(218, 41%, 19%) 80%, */
/*           transparent 100%), */
/*         radial-gradient(1250px circle at 100% 100%, */
/*           hsl(218, 41%, 45%) 15%, */
/*           hsl(218, 41%, 30%) 35%, */
/*           hsl(218, 41%, 20%) 75%, */
/*           hsl(218, 41%, 19%) 80%, */
/*           transparent 100%); */
/*     } */


/*     .bg-glass { */
/*       background-color: hsla(0, 0%, 100%, 0.9) !important; */
/*       backdrop-filter: saturate(200%) blur(25px); */
/*     } */
<!--   </style> -->

<!--   <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5"> -->
<!--     <div class="row gx-lg-5 align-items-center mb-5"> -->
<!--       <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10"> -->
<!--         <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)"> -->
<!--           The best offer <br /> -->
<!--           <span style="color: hsl(218, 81%, 75%)">for your business</span> -->
<!--         </h1> -->
<!--         <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)"> -->
<!--           Lorem ipsum dolor, sit amet consectetur adipisicing elit. -->
<!--           Temporibus, expedita iusto veniam atque, magni tempora mollitia -->
<!--           dolorum consequatur nulla, neque debitis eos reprehenderit quasi -->
<!--           ab ipsum nisi dolorem modi. Quos? -->
<!--         </p> -->
<!--       </div> -->

<!--       <div class="col-lg-6 mb-5 mb-lg-0 position-relative"> -->
<!--         <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div> -->
<!--         <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div> -->

<!--         <div class="card bg-glass"> -->
<!--           <div class="card-body px-4 py-5 px-md-5"> -->
<!--             <form> -->
<!--               2 column grid layout with text inputs for the first and last names -->
<!--               <div class="row"> -->
<!--                 <div class="form-outline mb-4"> -->
<!--                   <div class="form-outline"> -->
<!--                     <input type="text" id="identifiant" class="form-control" /> -->
<!--                     <label class="identifiant" for="identifiant" id="identifiant">Identifiant</label> -->
<!--                   </div> -->
<!--                 </div> -->


<!--               Password input -->
<!--               <div class="form-outline mb-4"> -->
<!--                 <input type="password" id="motDePasse" class="form-control" /> -->
<!--                 <label class="form-label" for="motDePasse" id="motDePasse">Mot De Passe</label> -->
<!--               </div> -->

<!--               Checkbox -->
<!--               <div class="form-check d-flex justify-content-center mb-4"> -->
<!--                 <input class="form-check-input me-2" type="checkbox" value="" id="souvenir" checked /> -->
<!--                 <label class="form-check-label" for="souvenir"> -->
<!-- 					Se souvenir de moi</label> -->
<!--               </div> -->

<!--               Submit button -->
<!--               <button type="submit" class="btn btn-primary btn-block mb-4"> -->
<!--                 Envoyer -->
<!--               </button> -->

<!--               Register buttons -->
<!--               <div class="text-center"> -->
                
<!--                 <button type="submit" class="btn btn-primary btn-block mb-4"> -->
<!--                 Créer un compte -->
<!--               </button> -->

<!--                 <button type="button" class="btn btn-link btn-floating mx-1"> -->
<!--                   <i class="fab fa-google"></i> -->
<!--                 </button> -->

<!--                 <button type="button" class="btn btn-link btn-floating mx-1"> -->
<!--                   <i class="fab fa-twitter"></i> -->
<!--                 </button> -->

<!--                 <button type="button" class="btn btn-link btn-floating mx-1"> -->
<!--                   <i class="fab fa-github"></i> -->
<!--                 </button> -->
<!--               </div> -->
<!--             </form> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
</section>

</html>