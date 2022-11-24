$(document).ready(function () {      
       $.ajax({
            url: "addProduct",
            data: {produits: $(this).val()},
            success: function (data, textStatus, jqXHR) {
                remplirProduit(data);
                console.table(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("erreur");
            }
        });
 ;

    function remplirProduit(data){
        var ligne  = "";
        var content = $("#content");
        data.forEach(function(e){
            console.log(e);
            ligne+="<tr><td>"+e.nom+"</td><td>"+e.designation+"</td><td>"+e.unite+"</td><td>"+e.prix+"</td><td>"+e.description+"</td><td>"+e.categorie+"</td><td>"+e.marque+"</td><td> <button data-id="+e.id+">Supprimer</button> </td></tr>";
        });
        content.html(ligne);
    }
    
    });
