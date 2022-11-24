<%-- 
    Document   : codeverification
    Created on : 17 nov. 2022, 20:22:37
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Code verification</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="style/registration.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
        <div class="text">Code verification</div>
        <form action="/user/verifierCode">
           <div class="form-row">
              <div class="input-data">
                  <input type="text"  required>
                 <div class="underline"></div>
                 <label for="">Entrez le code</label>
              </div>             
           </div>
                 <div class="form-row submit-btn">
                    <div class="input-data">
                       <div class="inner"></div>
                       <input type="submit" value="Entrer">
                    </div>
                
              </div>
           </div>
        </form>
     </div>
    </body>
</html>
