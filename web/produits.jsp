


<%@page import="entities.Produit"%>
<%@page import="services.ProduitServices"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Liste des produits</title>

        <meta charset="utf-8">
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/produittliste.js" type="text/javascript"></script>
        <script src="js/jquery-3.6.1.min.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="description" content="DashboardKit is made using Bootstrap 5 design framework. Download the free admin template & use it for your project.">
        <meta name="keywords" content="DashboardKit, Dashboard Kit, Dashboard UI Kit, Bootstrap 5, Admin Template, Admin Dashboard, CRM, CMS, Free Bootstrap Admin Template">
        <meta name="author" content="DashboardKit ">


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
        <%@include file="sidebar.html" %>


        <div class="pc-container">
            <div class="pcoded-content">



                <div class="card-body table-border-style">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <th>Image</th>    
                            <th>Nom</th>
                            <th>Designation</th>
                            <th>Unit?</th>
                            <th>Prix</th>
                            <th>Description</th>
                            <th>Cat?gorie</th>
                            <th>Marque</th>
                            <th>Action</th>
                            </thead>
                            <%
                        ProduitServices p = new ProduitServices();
                        for (Produit pp : p.findAllProduits()) {
                    %>
                            <tbody >
                                <tr><td><img style="width: 150px; height: 150px; " src=<%="ressource\\images\\" + pp.getImage()%>></td>
                                    <td>&nbsp; <%= pp.getNom()%>&nbsp;&nbsp;</td>
                                    <td>&nbsp; <%= pp.getDesignation() %>&nbsp;&nbsp;</td>
                                    <td>&nbsp; <%= pp.getUnite() %>&nbsp;&nbsp;</td>
                                    <td>&nbsp; <%= pp.getPrix() %>&nbsp;&nbsp;</td>
                                    <td>&nbsp; <%= pp.getDescription() %>&nbsp;&nbsp;</td>
                                    <td>&nbsp; <%= pp.getCategorie().getNom()%>&nbsp;&nbsp;</td>
                                    <td>&nbsp; <%= pp.getMarque().getNom()%>&nbsp;&nbsp;</td>
                                    <td><button class="btn"><a name="content00" href="admin/deleteProduit?id=<%= pp.getId()%>" >Supprimer</a></button></td>
                                    
     
                                </tr> 
                            </tbody>
                            <%}%>
                        </table>
                    </div>
                </div>

            </div>
        </div>             

        <script src="assets/js/vendor-all.min.js"></script>
        <script src="assets/js/plugins/bootstrap.min.js"></script>
        <script src="assets/js/plugins/feather.min.js"></script>
        <script src="assets/js/pcoded.min.js"></script>
    </body>
    