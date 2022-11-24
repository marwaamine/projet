<%-- 
    Document   : newpassword
    Created on : 17 nov. 2022, 20:23:26
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nouveau mot de passe</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="style/registration.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
        <div class="text">Changer le mot de passe</div>
        <form action="#">
           <div class="form-row">
              <div class="input-data">
                 <input type="text" required>
                 <div class="underline"></div>
                 <label for="">Nouveau Mot de passe</label>
              </div>
              <div class="input-data">
                 <input type="text" required>
                 <div class="underline"></div>
                 <label for="">Confirmer le nouveau mot de passe</label>
              </div>
           </div>
             <div class="form-row submit-btn">
                    <div class="input-data">
                       <div class="inner"></div>
                       <input type="submit" value="Confirmer">
                    </div>
    </body>
</html>
