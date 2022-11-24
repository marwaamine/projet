$(document).ready(function () {
    $.ajax({
        url: "listCategorie",
        success: function (data, textStatus, jqXHR) {
           remplir(data);
           //console.table(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("erreur");
        }
    });
    function remplir(data) {
        var liste = $("#categories");
        var option = "";
        for (i = 0; i < data.length; i++) {
            option += "<option value = " + data[i] + ">" + data[i] + "</option>";
        }
        liste.html(option);
    }

 });
