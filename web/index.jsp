<%@page import="services.ProduitServices"%>
<%@page import="entities.Produit"%>
<%@page import="java.util.List"%>
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

</head>



<body class="">

    <%@include file="nav.jsp" %>





    <div class="pc-container">
        <div class="pcoded-content">
            <!-- [ breadcrumb ] start -->
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
            <!-- [ breadcrumb ] end -->
            <!-- [ Main Content ] start -->
            <div class="row">
                <!-- [ sample-page ] start -->
                <div class="card">
					<div class="card-header">
						<h5>Plus recent</h5>
					</div>
                <%!int i = 0;%>
                <%
                    HttpSession sessio = request.getSession();
                    List<Produit> produits = (List<Produit>) sessio.getAttribute("listpr");
                    if (produits != null) {
                        i = produits.size();
                    }
                %>
                <div style="text-align: right;">
                    Panier :<a href="panier.jsp"> <i data-feather="shopping-cart"></i> <%= i%></a>
                </div>
                <div>
                    <%
                        ProduitServices p = new ProduitServices();
                        for (Produit pp : p.findAllProduits()) {
                    %>
                    <figure>
                        <img src=<%="ressource\\images\\" + pp.getImage()%>><br/>
                        <strong>Nom:&nbsp; <%= pp.getNom()%></strong>&nbsp;&nbsp;
                        <br>
                        <strong>Prix :&nbsp;<%= pp.getPrix()%>&nbspDH</strong><br>    
                        <input type ="number" data-id="<%=pp.getId()%>" class="quantity-input" >
                        <button class="add-to-cart" data-id="<%=pp.getId()%>">Ajouter au panier</button>
                    </figure>
                    <%}%>
                </div>
 
				</div>
                
            </div>
            
        </div>
    </div>







    <!-- Required Js -->
    <script src="assets/js/vendor-all.min.js"></script>
    <script src="assets/js/plugins/bootstrap.min.js"></script>
    <script src="assets/js/plugins/feather.min.js"></script>
    <script src="assets/js/pcoded.min.js"></script>
</body>

</html>