<%@page import="entities.LigneCommandePK"%>
<%@page import="entities.Commande"%>
<%@page import="services.ProduitServices"%>
<%@page import="services.LigneCommandeServices"%>
<%@page import="entities.Produit"%>
<%@page import="entities.LigneCommande"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    <link href="js/dataTables.bootstrap4.min.css" rel="stylesheet" media="all">   
    <link href="js/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    

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
                                <h5 class="m-b-10">Activites</h5>
                            </div>
                            <ul class="breadcrumb">
                                <li class="breadcrumb-item"><a href="index.html">Panier</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>           
            <div class="row">
                <div class="card">
                    <div class="card-header">
                        <h5>Panier</h5>
                    </div>
                    <div class="card-body table-border-style">
                        <div class="table-responsive">
                            <table id="tPanier" class="table table-hover" style="width: 100%;">
                               <thead>
                            <tr class="text-uppercase bg-light">
                               
                                <th scope="col">Produit</th>
                                <th scope="col">Quantite</th>
                                <th scope="col">Prix</th>
                                <th scope="col">Supprimer</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            
                            <%
                           double somme =0;
                           LigneCommandeServices ls = new LigneCommandeServices();
                           ProduitServices ps = new ProduitServices();
                           LigneCommandePK lcpk = new LigneCommandePK();
                           LigneCommande lc = new LigneCommande();
                           Commande c = new Commande();
                           for (LigneCommande l : ls.findAll()){
                           somme = somme+(l.getQuantité()*l.getPrixVente());
                          
                        %> 
                            <tr>
                                <td><%= l.getProduit().getNom() %></td>
                                <td><%= l.getQuantité() %></td>
                                <td><%= l.getPrixVente() %></td>
                                
                                <td><button type="button" class="button-85 supprimer"> <a href="./DeleteCommande?idproduit=<%= l.getProduit().getId()%>&idcommande=<%= l.getCommande().getId()%>">Supprimer</button></td>
                                
                            </tr>
                         <%}%>  
   
                        </tbody>
                        
                        <tfoot>
            <tr> 
                <th></th>
                <th>Prix Total</th>
                <th><%= somme %></th>
                <th></th>
            </tr>
        </tfoot>
                    </table>
                    <form >
                        <button type="submit" class="button-85" style="margin-left: 850px"> <a href="suiviCommande.jsp">Commander</button>
                    </form>
                  <form >
                      <button type="submit" class="button-85" style="margin-left: 850px"> <a href="./Facture?somme=<%=somme%>">Facture</button>
                    </form>
                </div>
            </div>
        </div>
    </div>    
      <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
     <script src='js/jquery-3.2.1.min.js'></script>  
  
   
    <script src="js/panier.js" type="text/javascript"></script>
    <script>
        $(function () {

            $('#mi-slider').catslider();

        });
		</script>
                 
     
</body>
</html>