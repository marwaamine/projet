$(document).ready(function () {      
       $.ajax({
            url: "admin/listeCategories",
            data: {categories: $(this).val()},
            success: function (data, textStatus, jqXHR) {
                remplirUser(data);
                console.table(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("erreur");
            }
        });
 ;

    function remplirUser(data){
        var ligne  = "";
        var content = $("#content");
        data.forEach(function(e){
            ligne+="<tr><td>"+e+"</td><td> <button >Supprimer</button> </td></tr>";
        });
        content.html(ligne);
    }
    
    });