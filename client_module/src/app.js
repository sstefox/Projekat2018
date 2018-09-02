function openTab(evt, cityName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("selectionTab");
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
     tablinks[i].className = tablinks[i].className.replace(" w3-border-red", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.firstElementChild.className += " w3-border-red";
}

$(document).ready(function () {
  $("#checkInDate").datepicker();
  $("#checkOutDate").datepicker();
});
function openTab(evt, cityName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("selectionTab");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" w3-border-red", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.firstElementChild.className += " w3-border-red";
}
function book(id) {
  var temp = id.substr(1, id.length);
  var x = 'bb'+temp;
  var xt = document.getElementById(x);
  xt.style.display="block";
}
function viewImages(id) {
  var temp = id.substr(1, id.length);
  var x = 'ii'+temp;
  var xt = document.getElementById(x);
  xt.style.display="block";
}
function rate(id) {
  var temp = id.substr(1, id.length);
  var x = 'rr'+temp;
  var xt = document.getElementById(x);
  xt.style.display="block";
}
function contact(id){
  var temp = id.substr(1, id.length);
  var x = 'mm'+temp;
  var xt = document.getElementById(x);
  xt.style.display="block";
}
function closebook(id){
  var temp = id.substr(2, id.length);
  var x = 'bb'+temp;
  var xt = document.getElementById(x);
  xt.style.display="none";
}
function closeimages(id){
  var temp = id.substr(2, id.length);
  var x = 'ii'+temp;
  var xt = document.getElementById(x);
  xt.style.display="none";
}
function closeratings(id){
  var temp = id.substr(2, id.length);
  var x = 'rr'+temp;
  var xt = document.getElementById(x);
  xt.style.display="none";
}
function closemessages(id){
  var temp = id.substr(2, id.length);
  var x = 'mm'+temp;
  var xt = document.getElementById(x);
  xt.style.display="none";
}