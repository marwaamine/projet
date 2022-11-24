$(document).ready(function () {      
       $.ajax({
            url: "admin/listMarques",
            data: {categories: $(this).val()},
            success: function (data, textStatus, jqXHR) {
                remplirMarque(data);
                //console.table(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("erreur");
            }
        });
 ;

    function remplirMarque(data){
        var ligne  = "";
        var content = $("#content");
        data.forEach(function(e){
            console.log(e);
            ligne+="<tr><td>"+e+"</td><td> <button data-id="+e.id+">Supprimer</button> </td></tr>";
            
            
        });
        content.html(ligne);
    }

    
    });