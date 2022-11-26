


<!DOCTYPE html>
<html lang="en">
    <head>
        <title>DashboardKit Bootstrap 5 Admin Template</title>
        <!-- HTML5 Shim and Respond.js IE11 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 11]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
        <!-- Meta -->
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
                            <th>Nom</th>
                            <th>Designation</th>
                            <th>Unité</th>
                            <th>Prix</th>
                            <th>Description</th>
                            <th>Catégorie</th>
                            <th>Marque</th>
                            <th>Action</th>
                            </thead>
                            <tbody id='content00'>

                            </tbody>
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