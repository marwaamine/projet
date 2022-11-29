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
            <div class="page-header">
                <div class="page-block">
                    <div class="row align-items-center">
                        <div class="col-md-6 col-xl-4">
                            <div class="page-header-title">
                                <h5 class="m-b-10">Nos produits</h5>
                            </div>
                            <ul class="breadcrumb">
                                <li class="breadcrumb-item"><a href="categorie.html">Categories</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <form action="AjouterPanier" method="GET">
              
                <div>
                    <%
                        ProduitServices p = new ProduitServices();
                        for (Produit pp : p.findAllProduits()) {
                    %>
                    <figure>
                        <div class="col-sm-4">
                    <div class="card text-white bg-info ">
                        <div class="card-header"><strong>Categorie:&nbsp; <%= pp.getCategorie().getNom()%></strong>&nbsp;&nbsp;</div>
                        <a name="id" href="index.jsp?id=<%= pp.getId()%>" class="btn  btn-secondary">Afficher les produits</a>
                    </div>
                </div>
     
                    </figure>
                    <%}%>
                </div>

            </form>

            </div>
            
            
        </div>
        <script src="assets/js/vendor-all.min.js"></script>
        <script src="assets/js/plugins/bootstrap.min.js"></script>
        <script src="assets/js/plugins/feather.min.js"></script>
        <script src="assets/js/pcoded.min.js"></script>
</body>

</html>