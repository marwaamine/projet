<%@page import="entities.Categorie"%>
<%@page import="services.CategorieServices"%>
<%@page import="java.util.List"%>
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
    
             <div class="col-md-9" >
                <div >
                    <ol class="breadcrumb" style="margin-left:300px;display: flex;justify-content: center; " >  
	  	<label class="for-dropdown" for="dropdown">Categorie :<i class="uil uil-arrow-down"></i></label>
  		<div class="section-dropdown">                     
                    <% 
                            CategorieServices cs = new CategorieServices();
                            for(Categorie c : cs.listCategories()){
                            
                            %>
  			<a href="?categorie=<%= c.getId()%>"> <%= c.getNom() %><i class="uil uil-arrow-right"></i></a>
                         <%}%>

  		</div>  

                    </ol>
                </div>  
                        </div>
                        
                <div class="row">
                    <%  String id =  request.getParameter("categorie");
                           if ( id != null){
                           ProduitServices ps = new ProduitServices();
                           for (Produit p : ps.findByCateg(cs.findCategorieById(Integer.parseInt(id)))){   
                        %>   
                    <div class="col-md-4 text-center col-sm-6 col-xs-6">
                        <div class="thumbnail product-box">
                            <img style="width: 150px; height: 150px; " src=<%="ressource\\images\\" + p.getImage()%>>
                              
                            <div class="caption"  >
                                <form action="./AddtoCart" method="get"> 
                               <p ><input name="id" value="<%= p.getId() %>" type="hidden"></input>nom : <%= p.getNom() %> </p>
                               <p>designation: <%= p.getDesignation() %> </p>
                               <p>prix : <%= p.getPrix() %> </p>
                               <input name="nb" value="1" type="hidden">
                               <!-- HTML !-->
                               <button class="button-85"  type="submit"  >  Ajouter au panier</button>
                               </form>
                            </div>
                        </div>
                        
                    </div>
                    <%}}%>  
                    </div>
                </div> 
                    <div class="col-md-8">
<table>

</td>
</tr>
</div>
                </div>
       
      <!-- Required Js -->
    <script src="assets/js/vendor-all.min.js"></script>
    <script src="assets/js/plugins/bootstrap.min.js"></script>
    <script src="assets/js/plugins/feather.min.js"></script>
    <script src="assets/js/pcoded.min.js"></script>
    <script src="js/cart.js" type="text/javascript"></script>
    
</body>
</html>