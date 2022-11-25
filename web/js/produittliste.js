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
            ligne += "<tr><td>" + e.nom + "</td><td>" + e.designation + "</td><td>" + e.unite + "</td><td>" + e.prix + "</td><td>" + e.description + "</td><td>" + e.categorie + "</td><td>" + e.marque + "</td><td><button class='supprimerproduit btn ' data-id=" + e.id + ">Supprimer</button></td></tr>";
        });
        content.html(ligne);
        $(".supprimerproduit").click(function () {
            var id = $(this).attr("data-id");
            $.ajax({
                url: 'admin/deleteProduit',
                data: {id: id},
                success: function (response) {
                    remplirProduit(response);
                }
            });
        })
    }

});