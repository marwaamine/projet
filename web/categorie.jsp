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

    <nav class="pc-sidebar ">
        <div class="navbar-wrapper">
            <div class="m-header">
                <a href="index.jsp" class="b-brand">
                    <!-- ========   change your logo hear   ============ -->
                    <img src="assets/images/logo.sv" alt="" class="logo logo-lg">
                    <img src="assets/images/logo-sm.sv" alt="" class="logo logo-sm">
                </a>
            </div>
            <div class="navbar-content ps ps--active-y">
                <ul class="pc-navbar">
                    <li class="pc-item pc-caption">
                        <label>Acceuil</label>
                    </li>
                    <li class="pc-item">
                        <a href="index.jsp" class="pc-link "><span class="pc-micon"><i
                                    class="material-icons-two-tone">home</i></span><span class="pc-mtext">Pour
                                moi</span></a>
                    </li>
                    <li class="pc-item pc-caption">
                        <label>Activites</label>
                        <span>Achats, Factures...</span>
                    </li>
                    <li class="pc-item">
                        <a href="panier.jsp" class="pc-link "><span class="pc-micon"><i
                                    class="material-icons-two-tone">business_center</i></span><span
                                class="pc-mtext">Panier</span></a>
                    </li>
                    <li class="pc-item">
                        <a href="facture.jsp" class="pc-link "><span class="pc-micon"><i
                                    class="material-icons-two-tone">history_edu</i></span><span
                                class="pc-mtext">Factures</span></a>
                    </li>
                    <li class="pc-item pc-caption">
                        <label>Nos produits</label>
                        <span>Decouvrir les nouveautes</span>
                    </li>
                    <li class="pc-item"><a href="marque.jsp" class="pc-link "><span class="pc-micon"><i
                                    class="material-icons-two-tone">storefront</i></span><span
                                class="pc-mtext">Marques</span></a></li>
                    <li class="pc-item"><a href="categorie.jsp" class="pc-link "><span class="pc-micon"><i
                                    class="material-icons-two-tone">storefront</i></span><span
                                class="pc-mtext">Categories</span></a></li>
                    <li class="pc-item pc-hasmenu">
                        <a href="#!" class="pc-link"><span class="pc-micon"><i
                                    class="material-icons-two-tone">https</i></span><span
                                class="pc-mtext">Authentication</span><span class="pc-arrow"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-chevron-right">
                                    <polyline points="9 18 15 12 9 6"></polyline>
                                </svg></span></a>
                        <ul class="pc-submenu" style="display: none;">
                            <li class="pc-item"><a class="pc-link" href="inscription.jsp" target="_blank">S'inscrire
                                    </a>
                            </li>
                            <li class="pc-item"><a class="pc-link" href="login.jsp"
                                    target="_blank">Se connecter</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <div class="ps__rail-x" style="left: 0px; bottom: 0px;">
                    <div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div>
                </div>
                <div class="ps__rail-y" style="top: 0px; height: 705px; right: 0px;">
                    <div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 221px;"></div>
                </div>
            </div>
        </div>
    </nav>
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
                <div class="col-sm-4">
                    <div class="card text-white bg-warning ">
                        <div class="card-header">Ordinateurs</div>
                        <div class="card-body">
                            <h5 class="card-title text-white">Dell probook.. <a href="#" class="card-link">+19 autres</a></h5>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="card text-white bg-danger ">
                        <div class="card-header">Telephones</div>
                        <div class="card-body">
                            <h5 class="card-title text-white">Iphone 13.. <a href="#" class="card-link">+39 autres</a></h5>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="card text-white bg-info ">
                        <div class="card-header">AirPods</div>
                        <div class="card-body">
                            <h5 class="card-title text-white">Samsung.. <a href="#" class="card-link">+29 autres</a></h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/js/vendor-all.min.js"></script>
        <script src="assets/js/plugins/bootstrap.min.js"></script>
        <script src="assets/js/plugins/feather.min.js"></script>
        <script src="assets/js/pcoded.min.js"></script>
</body>

</html>