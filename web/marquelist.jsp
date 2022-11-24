<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <script src="script/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="script/marqueliste.js" type="text/javascript"></script>
        <link href="style/lists.css" rel="stylesheet" type="text/css"/>
        <script src="script/marquedelete.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="sidebar.html" %>
  


                <legend>Liste des marques</legend>
                <br>
                <br>
                <br>
                <br>
                <table border="1">
                    <thead>
                        <tr>
                
                            <th>Noms des marques disponibles</th>
                            <th class="delete">Action</th>
                   
                          
                        </tr>
                    </thead>
                    <tbody id='content'>
                
                    </tbody>
                </table>

       
    </body>
</html>
