$(document).ready(function () {
        function init() {
    $.ajax({
        url: "admin/listMarques",
        success: function (data, textStatus, jqXHR) {
            remplirMarque(data);
            //console.table(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("erreur");
        }
    });
    }

    init();

    function remplirMarque(data) {
        var ligne = "";
        var content = $("#content000");
        data.forEach(function (e) {
            console.log(e);
            ligne += "<tr><td>" + e.nom + "</td><td> <button class='supprimermarque btn' data-id=" + e.id + ">Supprimer</button> </td></tr>";


        });
        content.html(ligne);
        $(".supprimermarque").click(function () {
            var id = $(this).attr("data-id")
            $.ajax({
                url: 'admin/deleteMarque',
                data: {id: id},
                success: function (response) {
                          remplirMarque(response);

                }
            });
        })
    }


});