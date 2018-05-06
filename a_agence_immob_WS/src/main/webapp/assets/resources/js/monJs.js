$(document).ready(function () {
    $(".text").hide();
    $(".truc").hide();
});

function show(){
    $("#1").toggle();
}

function show2(){
    $("#2").toggle();
}


//Get the modal
var modal = document.getElementById('id01');

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
 if (event.target == modal) {
     modal.style.display = "none";
 }
}
