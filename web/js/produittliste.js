$(document).ready(function () {
    function init() {
        $.ajax({
            url: "admin/listProduits",
            success: function (data, textStatus, jqXHR) {
                remplirProduit(data);
                console.table(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("erreur");
            }
        });
    }

    init();
    function remplirProduit(data) {
        var ligne = "";
        var content = $("#content00");
        data.forEach(function (e) {
            ligne += "<tr><td><button class='supprimerproduit btn ' data-id=" + e.id + ">Supprimer</button></td></tr>";
        });
        content.html(ligne);
        $(".supprimerproduit").click(function () {
            var id = $(this).attr("data-id");
            var confirmalert = confirm("Etes vous-sur de vouloir supprimer definitivement le produit?");
                if (confirmalert == true) {            
                    $.ajax({
                        url: 'admin/deleteProduit',
                        data: {id: id},
                        success: function (response) {
                            remplirProduit(response);
                        }
                    });
        }
        })
    }

});