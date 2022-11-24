function OpensubMenu(id){
  let dropMenu=document.getElementById(id);
  let sub_Menu= dropMenu.querySelector('.sub_Menu');
  let icon=dropMenu.querySelector('#icone');

  if(sub_Menu.style.display=="block"){
    sub_Menu.style.display="none";
    icon.classList.add("fa-chevron-down")
    icon.classList.remove("fa-chevron-up");

  }else {
    sub_Menu.style.display="block";
    icon.classList.add("fa-chevron-up");
    icon.classList.remove("fa-chevron-down")

 
  }
  
}
/*
function closeSideBar(){
    document.getElementById("sideBar").style.display="none";
  
}
function openSideBar(){
  document.getElementById("sideBar").style.display="block";
  document.getElementById("sideBar").style.width="25%";
  
}*/

function openSousCategorie(id,a){
  let icone_drop=document.getElementById(a);
  
  let sous_categories=document.getElementById(id);
  console.log(sous_categories.style.maxHeight==0);
  if(sous_categories.style.display== "block"){

    icone_drop.classList.add("fa-chevron-down")
    icone_drop.classList.remove("fa-chevron-up")

    sous_categories.style.display= "none";
  
  }else{
    icone_drop.classList.remove("fa-chevron-down")
    icone_drop.classList.add("fa-chevron-up")
    sous_categories.style.display= "block";

  }
    

}



function dropdown(){
  let icone_drop=document.getElementById("icone");

  let dropdonw_content=document.getElementsByClassName("dropdown-content")[0];
  
  if(dropdonw_content.style.display== "block"){

    icone_drop.classList.add("fa-chevron-down")
    icone_drop.classList.remove("fa-chevron-up")

    dropdonw_content.style.display= "none";
  
  }else{
     
    icone_drop.classList.remove("fa-chevron-down")
    icone_drop.classList.add("fa-chevron-up")

    dropdonw_content.style.display= "block";
  }

}

function pwdValidate() { 

      
    let pwd = document.getElementById("pwd").value; 
    let msg=document.getElementById("instuces").querySelectorAll("span");
    let newpd1=document.getElementById("pwd1");
    let compteur=0;
    document.getElementById("instuces").style.display="block";
    if ( pwd.length>=8) {
      msg[0].classList.add("correct")
      compteur++;
    }else msg[0].classList.remove("correct");
    if(pwd.match( /[a-z]/g) ) {
      msg[1].classList.add("correct");
      compteur++;

    }else msg[1].classList.remove("correct");
   

    if(pwd.match( /[A-Z]/g) ){ 
      msg[2].classList.add("correct");
      compteur++;

    }else msg[2].classList.remove("correct");
    
    
    if(pwd.match(/[0-9]/g)){    
      msg[3].classList.add("correct");
      compteur++;

    }else msg[3].classList.remove("correct");
    
    if(compteur==4){
      newpd1.removeAttribute("disabled");
      newpd1.style.cursor="auto";
      
    } else {
      newpd1.setAttribute("disabled",true);
      newpd1.style.cursor="not-allowed";
      
    }
      
    
}


function showPwd(id_pwd,id_eye){
  let pwd=document.getElementById(id_pwd);
  let eye=document.getElementById(id_eye);
  if(pwd.type=="password"){
      pwd.type="text";
      eye.classList.remove('fa-eye');
      eye.classList.add('fa-eye-slash')

  } else{ 
    pwd.type="password";
    eye.classList.add('fa-eye');
    eye.classList.remove('fa-eye-slash')

  }
}

function identicPwd(){
  let newpd=document.getElementById("pwd").value;
  let newpd1=document.getElementById("pwd1").value;
  let button=document.getElementById("but");
  console.log(button);
  let msg_confirmation= document.getElementById("span");

  if(newpd.length==newpd1.length && newpd===newpd1 ){ 
    msg_confirmation.style.display="none";
    button.style.pointerEvents="auto";
    button.style.opacity=1;

  }else {
      msg_confirmation.style.display="block";
      button.style.pointerEvents="none";
      button.style.opacity=0.4;

    
    }
}

function nextStep(id_1,id_2){
  let id1=document.getElementById(id_1);
  let id2=document.getElementById(id_2);
  let content1=id1.querySelector('.content');
  let content2=id2.querySelector('.content');
  id1.querySelector('.header  i').style.color="green";
  content1.style.display="none";
  content2.style.display="block";
}

function previousStep(id_1,id_2){
  let id1=document.getElementById(id_1);
  let id2=document.getElementById(id_2);
  let content1=id1.querySelector('.content');
  let content2=id2.querySelector('.content');
  id1.querySelector('.header  i').style.color="gray";
  content1.style.display="block";
  content2.style.display="none";
}
//Generate Mot de passe auto
/*function makePassword(maxLengthPass) {
 var collectionOfLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 var generatedPassword = "";
 var size = collectionOfLetters.length;
 for (var i = 0; i < maxLengthPass; ++i) {
    generatedPassword = generatedPassword + collectionOfLetters.charAt(Math.floor(Math.random() * size));
 }
 return generatedPassword;
}

function generatePassword(){
let newpd=document.getElementById("pwd");
let newpd1=document.getElementById("pwd1");
newpd.value=makePassword(10);
newpd.type="text";    
newpd1.value=newpd.value;
newpd1.type="text";    
}
*/