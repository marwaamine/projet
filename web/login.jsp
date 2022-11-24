<%-- 
    Document   : Login
    Created on : 16 nov. 2022, 20:28:41
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Login</title>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
      <link href="style/login.css" rel="stylesheet" type="text/css"/>
   </head>
   <body>
      <div class="center">       
         <div class="container">
            <label for="" class="close-btn fas fa-times" title="close"></label>
            <div class="text">
               Se connecter
            </div>
             <form method="post" action="<%=request.getContextPath()%>/user/login">
           
               <div class="data">
                  <label for ="uname">Email </label>
                  <input  type="text" id="email" name="email" required  placeholder="nom@gmail.com">
               </div>
               <div class="data">
                  <label for ="uname">Mot de passe</label>
                  <input type="password" id="password" name="password" required placeholder="mot de passe">                 
               </div>
                 
               <div class="forgot-pass">
                   <a href="emailverification.jsp">Mot de passe oublié</a>
               </div>
               <div class="btn">
                  <div class="inner"></div>
                  <button type="submit">Se connecter</button>
               </div>
               <div class="signup-link">
                  nouveau membre? <a href="inscription.jsp">S'inscrire</a>
               </div>
            </form>
         </div>
      </div>
   </body>
</html>