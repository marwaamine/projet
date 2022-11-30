$(document).ready(function () {
        function init() {
    $.ajax({
        url: "user/listUsers",
        success: function (data, textStatus, jqXHR) {
            remplirClient(data);
           console.table(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("erreur");
        }
    });
    }

    init();

    function remplirClient(data) {
        var ligne = "";
        var content = $("#content001");
        data.forEach(function (e) {
            console.log(e);
            ligne += "<tr><td>" + e.nom + "</td><td>" + e.prenom + "</td><td>" + e.email + "</td><td>" + e.telephone + "</td><td>" + e.adresse + "</td><td> <button class='supprimerclient btn' data-id=" + e.id + ">Supprimer</button> </td></tr>";


        });
        content.html(ligne);
        $(".supprimerclient").click(function () {
            var id = $(this).attr("data-id")
            var confirmalert = confirm("Etes vous-sur de vouloir supprimer definitivement le client?");
                if (confirmalert == true) {
                    $.ajax({
                        url: 'user/deleteClient',
                        data: {id: id},
                        success: function (response) {
                                  remplirClient(response);

                        }
                    });
             }
        })
    }


});