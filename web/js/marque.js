$(document).ready(function () {
    $.ajax({
        url: "admin/listMarques",
        success: function (data, textStatus, jqXHR) {
           remplir(data);
          // console.table(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("erreur");
        }
    });
    function remplir(data) {
        var liste = $("#marques");
        var option = "";
        for (i = 0; i < data.length; i++) {
            option += "<option value = " + data[i] + ">" + data[i]+ "</option>";
        }
        liste.html(option);
    }

 });