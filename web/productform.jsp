<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Admin- Gestion des produits</title>
      <link href="style/forms.css" rel="stylesheet" type="text/css"/>
      <link href="style/uploadimage.css" rel="stylesheet" type="text/css"/>
      <script src="js/jquery-3.6.1.min.js" type="text/javascript"></script>
      <script src="js/categoriie.js" type="text/javascript"></script>
      <script src="js/marquee.js" type="text/javascript"></script>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
   <body>
        <%@include file="sidebar.html" %>
    <div class="container">
        <div class="text">Ajouter un produit </div>
        <form action="admin/AddProduct" id="submit" method="post">
      
            

      <div class="containerc">
         <div class="wrapper">
            <div class="image">
               <img src="" alt="">
            </div>
            <div class="content">
               <div class="icon">
                  <i class="fas fa-cloud-upload-alt"></i>
               </div>
               <div class="text">
                  Veuillez choisir un fichier!
               </div>
            </div>
            <div id="cancel-btn">
               <i class="fas fa-times"></i>
            </div>
            <div class="file-name">
               Nom du fichier!
            </div>
         </div>
         <button onclick="defaultBtnActive()" id="custom-btn">Choisir un fichier</button>
         <input id="default-btn" type="file" hidden>
      </div>
      <script>
         const wrapper = document.querySelector(".wrapper");
         const fileName = document.querySelector(".file-name");
         const defaultBtn = document.querySelector("#default-btn");
         const customBtn = document.querySelector("#custom-btn");
         const cancelBtn = document.querySelector("#cancel-btn i");
         const img = document.querySelector("img");
         let regExp = /[0-9a-zA-Z\^\&\'\@\{\}\[\]\,\$\=\!\-\#\(\)\.\%\+\~\_ ]+$/;
         function defaultBtnActive(){
           defaultBtn.click();
         }
         defaultBtn.addEventListener("change", function(){
           const file = this.files[0];
           if(file){
             const reader = new FileReader();
             reader.onload = function(){
               const result = reader.result;
               img.src = result;
               wrapper.classList.add("active");
             }
             cancelBtn.addEventListener("click", function(){
               img.src = "";
               wrapper.classList.remove("active");
             })
             reader.readAsDataURL(file);
           }
           if(this.value){
             let valueStore = this.value.match(regExp);
             fileName.textContent = valueStore;
           }
         });
      </script>
   

            
           <div class="form-row">
              <div class="input-data">
                  <input type="text" name="nom"  required>
                 <div class="underline"></div>
                 <label for="">Nom du produit:</label>
              </div>
              <div class="input-data">
                  <input type="text" name="designation"  required>
                 <div class="underline"></div>
                 <label for="">Désignation:</label>
              </div>
           </div>
           <div class="form-row">
              <div class="input-data">
                  <input type="text" name="prix" required>
                 <div class="underline"></div>
                 <label for="">Prix:</label>
              </div>
              <div class="input-data">
                  <input type="text" name="unite" required>
                 <div class="underline"></div>
                 <label for="">Unité:</label>
              </div>
           </div>
            <div class="form-row">

                <div class="input-data">
                <div class="underline"></div>
                <label for="marques">Marque:</label>                    
                    <div style="width:200px; ">
                        <select id="marques" name="marques" ></select> 
                    </div>
                </div>
                
                <div class="input-data">
                <div class="underline"></div>
                <label for="categories">Catégorie:</label>                    
                    <div style="width:200px;">
                        <select id="categories" name="categories" ></select> 
                    </div>
                </div>                
                
           </div>                  
           <div class="form-row">
              <div class="input-data textarea">
                 <textarea rows="8" cols="80" required name="description"></textarea>
                 <br />
                 <div class="underline"></div>
                 <label for="">Description:</label>
                 <br />
              </div>
           </div>

     
            <div class="form-row submit-btn">
                <div class="input-data">
                    <div class="inner"></div>
                    <input type="submit" name="envoi" value="Ajouter le produit" >
                </div>
                </div>      
              <div id="res"></div>

        </form>
     </div>
   </body>
</html>