$(document).ready(function () {
    $(".add-to-cart").click(function () {
            var id = $(this).attr("data-id")
            var quantite = $(".quantity-input[data-id='"+id+"']").val();
            $.ajax({
                url: 'client/AjouterPanier',
                data: {id: id, quantite:quantite},
                success: function (response) {
                          

                }
            });
        })
    
    
    
    
    
    })


