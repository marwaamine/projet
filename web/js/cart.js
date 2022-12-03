$(document).ready(function () {
    $.ajax({  
        url: "ListCart",
        success: function (data, textStatus, jqXHR) {
            remplirCart(data);
            total(totale);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("erreur");
        }
        
    });
 var totale  ;

    
    
function remplirCart(data) {
        totale = 0 ;
        var liste = $("#listcart");
        var option = "";
        for (i = 0; i < data.length ; i++) {
            totale = totale + (data[i][2]*data[i][1]);
            option +=  " <tr> "
                         +   "<td class='align-middle'><img src='img/product/"+data[i][4]+"' alt='' style='width: 50px;'> "+data[i][3]+"</td> "
                         +  " <td class='align-middle'>"+ data[i][1] +"dh</td> "
                        +   " <td class='align-middle'> "
                          +   "   <div class='input-group quantity mx-auto' style='width: 100px;'> "
                             +    "   <div class='input-group-btn'> " 
                              +     "     <button class='btn btn-sm btn-primary btn-minus' > "
                               +    "     <i onclick='minus("+data[i][0].produitId+","+data[i][0].commandeId+")' class='fa fa-minus'></i> "
                              +      "    </button> "
                              +    "  </div> "
                              +    "  <input type='text' disabled='' class='form-control form-control-sm bg-secondary text-center' value='"+data[i][2]+"'> "
                              +    "  <div class='input-group-btn'> "
                             +        "   <button class='btn btn-sm btn-primary btn-plus'> "
                              +     "         <i onclick='plus("+data[i][0].produitId+","+data[i][0].commandeId+")' class='fa fa-plus'></i> "
                            +       "     </button> "
                            +     "   </div> "
                          +    "  </div> "
                        +    "</td> "
                        + "   <td class='align-middle'>"+(data[i][2]*data[i][1])+" Dh</td> "
                      + "     <td class='align-middle'><button onclick='deleteElement("+data[i][0].produitId+","+data[i][0].commandeId+")' class='btn btn-sm btn-primary'><i class='fa fa-times'></i></button></td> "
                      + " </tr> "
                    
        ;
        }
        liste.html(option);
    }

function minus(idproduit,idcommande) {
        $.ajax({
            url: "UpdateCart?idproduit=" + idproduit +"&idcommande="+idcommande+"&arg=1",
            success: function (data, textStatus, jqXHR) {     
                remplirCart(data);    
                cartCount(data);
                total(totale);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("erreur");
            }

        });
       

    }
    function cartCount(data) {
        var liste = $("#cart");
        var option = "<span class='badge'>" + data.length + "</span>";
       
        liste.html(option);
    }
    function plus(idproduit,idcommande) {
        $.ajax({
            url: "UpdateCart?idproduit=" + idproduit +"&idcommande="+idcommande+"&arg=0",
            success: function (data, textStatus, jqXHR) {     
                remplirCart(data); 
                cartCount(data);
                total(totale);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("erreur");
            }

        });

    }
    function deleteElement(idproduit,idcommande) {
        $.ajax({
            url: "DeleteFromCart?idproduit=" + idproduit +"&idcommande="+idcommande,
            success: function (data, textStatus, jqXHR) {     
                remplirCart(data);    
                cartCount(data);
                total(totale);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("erreur");
            }

        });

    }
     function total(data) {
        var liste = $("#total");
        var liste1 = $("#total1");
        var option = "<h5 class='font-weight-bold'>Total</h5>"
                          + "<h5 class='font-weight-bold'>"+data+" Dh</h5>";
       
        liste.html(option);
         liste1.html(option);
    }

    window.deleteElement=deleteElement;
        window.plus=plus;
         window.minus=minus;
});
