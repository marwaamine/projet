<%@page import="entities.Produit"%>
<%@page import="services.ProduitServices"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <title>Site E-commerce</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="description" content="" />
    <meta name="keywords" content="">
    <meta name="author" content="Phoenixcoded" />
    <script src="js/jquery-3.6.1.min.js" type="text/javascript"></script>
    <script src="js/panier.js" type="text/javascript"></script>
    <!-- Favicon icon -->
    <link rel="icon" href="assets/images/favicon.svg" type="image/x-icon">

    <!-- font css -->
    <link rel="stylesheet" href="assets/fonts/feather.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome.css">
    <link rel="stylesheet" href="assets/fonts/material.css">

    <!-- vendor css -->
    <link rel="stylesheet" href="assets/css/style.css" id="main-style-link">
    <link href="style/style.css" rel="stylesheet" type="text/css"/>

</head>

<body>
    <%@include file="nav.jsp" %>
    <div class="pc-container">
        <div class="pcoded-content">
    <div class="page-header">
                <div class="page-block">
                    <div class="row align-items-center">
                        <div class="col-md-6 col-xl-4">
                            <div class="page-header-title">
                                <h5 class="m-b-10">Acceuil</h5>
                            </div>
                            <ul class="breadcrumb">
                                <li class="breadcrumb-item"><a href="index.html">Pour moi</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <h1><i class=" fa fa-shopping-cart"></i></h1>
             <%
                        ProduitServices p = new ProduitServices();
                        for (Produit pp : p.findAllProduits()) {
                    %>
	
	<section>
		<div class="item">
			 <img style="width: 150px; height: 150px; " src=<%="ressource\\images\\" + pp.getImage()%>>
                         <p>Nom:&nbsp; <%= pp.getNom()%>&nbsp;&nbsp;</p>
			<p>Description:&nbsp; <%= pp.getDescription()%>&nbsp;&nbsp;</p>
                        <p> Marque:&nbsp; <%= pp.getMarque().getNom()%>&nbsp;&nbsp;</p>
                         <p> Categorie:&nbsp; <%= pp.getCategorie().getNom()%>&nbsp;&nbsp;</p>
			<h6>Prix :&nbsp;<%= pp.getPrix()%>&nbspDH</h6>
			<span></span>
			<button class="add-to-cart" data-id="<%=pp.getId()%>">Ajouter au panier</button>
			
		</div>
		
		
		
	</section>
	<div class="select">
		
	</div>
        <%}%>
        </div>
        </div>
      <!-- Required Js -->
    <script src="assets/js/vendor-all.min.js"></script>
    <script src="assets/js/plugins/bootstrap.min.js"></script>
    <script src="assets/js/plugins/feather.min.js"></script>
    <script src="assets/js/pcoded.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>
