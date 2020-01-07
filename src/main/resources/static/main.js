$.ajax({
    url: "http://localhost:8080/bouffe/titre"
}).then(function (data) {
    console.log(data)
    document.getElementById("titreProjet").textContent = data;
});
// contient la liste de tous les people reçue par l'api starwars
var listJour = [];
var listPlat = [];

//Charger Jour
$(document).ready(function () {
  $.ajax({
    url: "http://localhost:8080/semaine/jourList"
  }).then(function (data) {
    listJour = data;
    console.log(listJour);  
    chargerMenu();
  });
});

//Charger Plat
$(document).ready(function () {
  $.ajax({
    url: "http://localhost:8080/bouffe/montrelesplats"
  }).then(function (data) {
    listPlat = data;
    console.log(listPlat);

  });
});



/**
 * remplit le dropdown menu avec les jours de la liste
 */
function chargerMenu() {
  listJour.forEach(function (item) {
    let newMenuItem = document.createElement('button');
    newMenuItem.className = "dropdown-item";
    newMenuItem.type = "button";
    newMenuItem.textContent = item.jour;
    console.log(item.jour);
    document.getElementById("dropdown-list").appendChild(newMenuItem);
    newMenuItem.addEventListener('click', function (event) {
      // l'action à effectuer lorsqu'on clique sur un element du dropdown
      chargerPlat(item);
    }); 

  });
}

//charge le plat et l'image correspondante
function chargerPlat(item) {
  console.log(item);
  $(".card-title").remove();//efface la carte quand elle a fini de charger
  let idPlat = item.id;
  console.log(item.id);
  plat1=listPlat.find(x => x.id == item.id).platDuMidi;
  plat2=listPlat.find(x1 => x1.id == item.id).platDuSoir;
  console.log(plat1);
  console.log(plat2);
  //$("#titrePlatMidi").textContent()=plat1;
  imgSrc = "./images/"+plat1+".jpg";
  $("#image").attr("src", imgSrc);
  //$("#titrePlatSoir").textContent()=plat2;
  imgSrc2 = "./images/"+plat2+".jpg";
  $("#image1").attr("src", imgSrc2);
}


// function rechercheId(){
//   $( "#envoyer" ).on(click, function( event ){
//   id= $("#rechercheParId").val();
//   console.log(id);
//   $.ajax({
//             url: "http://localhost:8080/bouffe/objetPlat/?id=" + id,
//             success: (chargerPlat),
//             error: (error)
//         })
// });}







