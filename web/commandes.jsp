<%@page import="entities.LigneCommande"%>
<%@page import="entities.Commande"%>
<%@page import="services.CommandeServices"%>
<%@page import="services.LigneCommandeServices"%>
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

        <div class="col-xl-6 col-md-12">
                <div class="card">
                   
                    </div>
                </div>
                <div class="card table-card">
                    <div class="card-header">
                        <h5>Commandes</h5>
                    </div>
                    <div class="pro-scroll ps ps--active-y" style="height:255px;position:relative;">
                        <div class="card-body p-0">
                            <div class="table-responsive">
                                <table  class="table table-hover m-b-0">
                                    <thead>
                                        <tr class="text-uppercase bg-light">
                                            <th scope="col">Client</th>
                                            <th scope="col">Date</th>
                                            <th scope="col">Etat</th>
                                            <th scope="col">Quantité</th>
                                            <th scope="col">Prix</th>
                                        </tr>
                                    </thead>
                           <tbody>   
                            <%
                            double somme= 0;    
                           CommandeServices cs= new CommandeServices();
                           LigneCommandeServices ls= new LigneCommandeServices();
                           
                               for (LigneCommande l: ls.findAll()){
                                   somme = somme+(l.getQuantité()*l.getPrixVente());
                                   for (Commande c :cs.findCommandes()){
                        %> 
                            <tr>
                                <td><%= c.getClient().getNom() %> </td>
                                <td><%= c.getDate() %></td>                             
                                <td><%= c.getStatus() %> </td>
                                <td><%= l.getQuantité() %> </td>
                                <td><%= l.getPrixVente() %></td>                                
                                
                            </tr>
                          
    <%}}%> 
                        </tbody>    
                         <tfoot>
                                <tr> 
                                    <th></th>
                                    <th>Montant</th>
                                    <th><%= somme %></th>
                                    <th></th>
                                </tr>
                            </tfoot>
                  </table>
                            </div>
                        </div>
                </div>
            </div>



            </div>
                 

        <script src="assets/js/vendor-all.min.js"></script>
        <script src="assets/js/plugins/bootstrap.min.js"></script>
        <script src="assets/js/plugins/feather.min.js"></script>
        <script src="assets/js/pcoded.min.js"></script>
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