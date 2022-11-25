$(document).ready(function () {  
    function init() {    
       $.ajax({
            url: "admin/listeCategories",
            success: function (data, textStatus, jqXHR) {
                remplirCategorie(data);
                console.table(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("erreur");
            }
        });
    }

    init();

    function remplirCategorie(data){
        var ligne  = "";
        var content = $("#content0");
        data.forEach(function(e){
            ligne+="<tr><td>"+e.nom+"</td><td> <button class='supprimercategorie btn' data-id=" + e.id + ">Supprimer</button> </td></tr>";
        });
        content.html(ligne);
        $(".supprimercategorie").click(function () {
            var id = $(this).attr("data-id")
            $.ajax({
                url: 'admin/deleteCategorie',
                data: {id: id},
                success: function (response) {
                    remplirCategorie(response);
                }
            });
        })        
    }
    
    });