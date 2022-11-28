
<%@page import="entities.Client"%>
<header class="pc-header ">
    <div class="header-wrapper">
        <div class="ml-auto">
            <ul class="list-unstyled">
                <li class="dropdown pc-h-item">
                    <a class="pc-head-link dropdown-toggle arrow-none mr-0" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                        <i class="material-icons-two-tone">search</i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right pc-h-dropdown drp-search" style="">
                        <form class="px-3">
                            <div class="form-group mb-0 d-flex align-items-center">

                                <input type="search" class="form-control border-0 shadow-none" placeholder="Chercher. . .">
                            </div>
                        </form>
                    </div>
                </li>
                <li class="dropdown pc-h-item">
                    <a class="pc-head-link dropdown-toggle arrow-none mr-0" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                        <span>
                            <%  Client user = (Client) session.getAttribute("user");
                                if (user == null) { %>
                            <span class="user-name">non connecte</span>
                            <%} else {
                            %>
                            <span class="user-name"><%= ((Client) session.getAttribute("user")).getNom()%></span>
                            <%
                                }%>
                            <span class="user-desc">Client</span>
                        </span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right pc-h-dropdown">

                        <a href="user/logout" class="dropdown-item">
                            <i class="material-icons-two-tone">chrome_reader_mode</i>
                            <span>Logout</span>
                        </a>
                    </div>
                </li>
            </ul>
        </div>

    </div>
</header>

<nav class="pc-sidebar ">
    <div class="navbar-wrapper" >
        <div class="m-header" >
            <p class="text-white" style="font-size: 1.5em">HAB SHOP</p>
            <a href="index.html" class="b-brand">
                <!-- ========   change your logo hear   ============ -->

            </a>
        </div>
        <div class="navbar-content ps ps--active-y">
            <ul class="pc-navbar">
                <li class="pc-item pc-caption" style="text-decoration-color:#fff">
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
                        <%if (user == null) { %>
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
                        <li class="pc-item"><a class="pc-link" href="inscription.jsp" target="_blank">S'inscrire</a>
                        </li>
                        <li class="pc-item"><a class="pc-link" href="login.jsp" target="_blank">Se connecter</a>
                        </li>
                    </ul>
                </li>
                <% }%>
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



