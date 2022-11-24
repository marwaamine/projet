var produits=localStorage.getItem('panier') || [];
var nombre_produit=document.getElementById('nombre_produits');
var somme=0;  
var notification=document.createElement("div");; 
let row,quantite,minus,sous_total,prix_total,somme_total=0;
var panier_vide=document.getElementById("panier_vide");
var panier_pleine=document.getElementById("panier_pleine");
 
produits.find(p=>{
    somme+=p.nombre;
})
nombre_produit.innerHTML=somme;

function showTaskBar(designation){
    notification.id="snackbar";
    notification.className="show";
    notification.innerHTML=designation+" a été ajouté à votre panier..." 
    document.body.appendChild(notification)
    setTimeout(function(){  notification.className = notification.className.replace("show", ""); }, 2000);
}

function showRemoveTaskBar(designation,quantite){
    notification.id="snackbar";
    notification.className="show";
    notification.innerHTML=quantite+" article "+designation+" a bien été retiré de votre panier " 
    document.body.appendChild(notification)
    setTimeout(function(){ notification.className = notification.className.replace("show", ""); }, 2000);
   
}

function addCart(id){
    let produit=document.getElementById(id);
    let get_id=produit.getAttribute('id');
    let titre=produit.querySelector('p').innerText;
    let description=produit.querySelector('span').innerText;
    let prix=parseFloat(produit.querySelector('h3').innerText);
    let photo =produit.querySelector('img').getAttribute('src');
    let setproduit={
        id:get_id,
        photo:photo,
        designation:titre,
        description:description,
        nombre:1,
        prix:prix,
        prix_sous:prix
    }
    let isInArray=false;
    if(produits.length==0){
         produits.push(setproduit);
         showTaskBar(setproduit.designation)
         somme++;
        }
    else {
       isInArray= produits.find(p=>{
            if(p.id==get_id) {
                p.nombre++;
                p.prix_sous=Math.round((p.prix*p.nombre)*100)/100;
                showTaskBar(p.designation);
                somme++;
                return true;
            }
        })
        if(!isInArray){ 
            produits.push(setproduit);
            showTaskBar(setproduit.designation)
            

            somme++;
         }
    }
    nombre_produit.innerHTML=somme;
    localStorage.setItem('panier',JSON.stringify(produits));

}

function loadPanier(){
    let tbody=document.getElementById('table-content');
    let prix_total=document.querySelector('.prix_total').querySelector('label');
    let somme_total=0;
if(produits.length==0){
    panier_vide.style.display="block";
    panier_pleine.style.display="none";
}else {

    for(produit of produits){
        let row=document.createElement('tr');
        let id_photo=document.createElement('td');
        let description_produit=document.createElement('td');
        let quantite=document.createElement('td');
        let prix=document.createElement('td');
        let prix_sous=document.createElement('td');
        let supp=document.createElement('td');
        id_photo.innerHTML="<input type=hidden name='id_produit[]' value="+produit.id+">"+"<img src="+produit.photo+" alt='' width='150px' height='150px'>";
        description_produit.innerHTML="<h3> "+produit.designation+"</h3> <p>"+produit.description+"</p>";
        quantite.innerHTML="<i class='fas fa-minus-square' onclick=RemovedNumber("+produit.id+")></i>"+
        "<input  readonly type='text' id='quantite' value="+produit.nombre+" name=quantite[]>"+
        "<i class='fas fa-plus-square' onclick=addNumber("+produit.id+") ></i>";
        prix.innerText=produit.prix+" Mad";
        prix_sous.innerHTML="<input type=hidden name='sous_prix[]' value="+produit.prix_sous+" id='sous_prix'><label>"+produit.prix_sous+" Mad </label>";
        supp.innerHTML="<i id='button_supprimer' onclick=deleteProduit("+produit.id+") class='fas fa-trash-alt'></i> "
    
    //les classes
    row.setAttribute("class","panier-item");
    row.setAttribute("id",produit.id);
    description_produit.setAttribute("class","description_produit");
    id_photo.setAttribute("class","photo");
    quantite.setAttribute("class","nombre_produit");
    prix.setAttribute("class","prix_produit");
    prix_sous.setAttribute("class","prix_sous_total");
    row.appendChild(id_photo)  ;
    row.appendChild(description_produit);  
    row.appendChild(quantite);  
    let minus=row.querySelector('.nombre_produit i:first-child');
    if(produit.nombre==1){
            minus.style.pointerEvents="none"
            minus.style.opacity=0.4
    }else {
        minus.style.pointerEvents="auto"
        minus.style.opacity=1
    }

    row.appendChild(prix)  ;
    row.appendChild(prix_sous)  ;
    row.appendChild(supp);  
    tbody.appendChild(row);
    somme_total+=produit.prix*produit.nombre;
    }
    prix_total.innerText=Math.round(somme_total*100)/100+" Mad";
    
}
}

function viderPanier(){
    let table=document.getElementById('table-content');
    table.innerHTML=''
    localStorage.removeItem('panier');
    nombre_produit.innerHTML=0;

}

function addNumber(id){
    row=document.getElementById(id);
    quantite=row.querySelector('#quantite');
    minus=row.querySelector('.nombre_produit i:first-child');
    sous_total=row.querySelector('.prix_sous_total').querySelector('label');
    sous_prix=row.querySelector('.prix_sous_total').querySelector('#sous_prix');
    prix_total=document.querySelector('.prix_total').querySelector('label');
    somme_total=0;
   
    
  produits.find(p=>{
    if(p.id==id) {
        p.nombre++;
        quantite.setAttribute("value",parseInt(quantite.value)+1);
        showTaskBar(p.designation);
        p.prix_sous=Math.round((p.prix*p.nombre)*100)/100;
        sous_prix.setAttribute("value",p.prix_sous);
        if(p.nombre>1){
            minus.style.pointerEvents="auto";
            minus.style.opacity=1;
        }
        somme++;
        sous_total.innerHTML=Math.round((p.prix*p.nombre)*100)/100+" Mad";
      //  location.reload();

    }
})

produits.map(p=>{

    somme_total=parseFloat(somme_total)+parseFloat(p.prix_sous)
})

//prix total 
prix_total.innerHTML=Math.round(somme_total*100)/100+" Mad"
nombre_produit.innerHTML=somme;
localStorage.setItem('panier',JSON.stringify(produits));
    
}

 function RemovedNumber(id){
    row=document.getElementById(id);
    quantite=row.querySelector('#quantite');
    minus=row.querySelector('.nombre_produit i:first-child');
    sous_total=row.querySelector('.prix_sous_total').querySelector('label');
    prix_total=document.querySelector('.prix_total').querySelector('label');
    somme_total=0;

    produits.find(p=>{
       if(p.id==id) {
           p.nombre--;
           quantite.setAttribute("value",parseInt(quantite.value)-1);
           showRemoveTaskBar(p.designation,1);
           p.prix_sous=Math.round((p.prix*p.nombre)*100)/100;
           somme--;
           sous_total.innerHTML=Math.round((p.prix*p.nombre)*100)/100+" Mad";
           if(p.nombre===1) {
                minus.style.pointerEvents="none";
                minus.style.opacity=0.4;
          }
       }
   })

   produits.map(p=>{
      somme_total=parseFloat(somme_total)+parseFloat(p.prix_sous);
   }
      )
      prix_total.innerHTML=Math.round(somme_total*100)/100+" Mad"
      nombre_produit.innerHTML=somme;
   localStorage.setItem('panier',JSON.stringify(produits));
    
}

function deleteProduit(id){
    let row=document.getElementById(id);
    let table=document.getElementById('table-content');
    let  prix_total=document.querySelector('.prix_total').querySelector('label');

    
    for(i=0;i<produits.length;i++){
        if(produits[i].id==id){
            somme-=produits[i].nombre;
            prix_total.innerHTML=Math.round( ( parseFloat(prix_total.innerHTML)-parseFloat(produits[i].prix_sous) )*100)/100+" Mad"
            showRemoveTaskBar(produits[i].designation,produits[i].nombre);
            produits.splice(i,1);
        }
        
    }
    table.removeChild(row);
    if(produits.length==0){
        panier_vide.style.display="block";
        panier_pleine.style.display="none";
 
    }
    nombre_produit.innerHTML=somme;
    localStorage.setItem('panier',JSON.stringify(produits));


    
}