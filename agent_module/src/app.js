var tid = '';
var fid=  '';
var lst = [];
function reservation(id) {
    var temp = 'r'+id;
    var x = document.getElementById(temp);
    x.style.display='block'
}
function closereservation(id){
    var temp = id.substr(1,id.length);
    var x = 'rr'+temp;
    document.getElementById(x).style.display='none';
    var t = '#rt'+temp;
    $(t).nextAll(".reserve").remove();
}
function review(id){
    var temp = id.substr(1,id.length);
    var x = 'cc'+temp;
    var xt = document.getElementById(x);
    xt.style.display='block';
}
function closereviews(id){
    var temp = id.substr(1,id.length);
    var x = 'cc'+temp;
    var xt = document.getElementById(x);
    xt.style.display="none";
}
function image(id) {
    var temp = 'i'+id;
    var x = document.getElementById(temp);
    x.style.display='block';
}
function closeimage(id){
    var temp = id.substr(1,id.length);
    var x = 'ii'+temp;
    document.getElementById(x).style.display='none'
}
$(document).ready(function(){
$("#fromDate").datepicker();
$("#toDate").datepicker();
});
function addimages(id){
    var temp = id.substr(3,id.length);
    var x = '#div'+temp;
    var d = "#"+id;
    // var str = '<input style=\"display: none\" type=\"file\"  (change)=\"onFileChanged($event)\" #fileInput><button (click)=\"fileInput.click()\" class=\"w3-button w3-circle w3-green\">Select File</button>';
    var str = '<input type=\"file\" (change)=\"onFileChanged($event)\" class=\"w3-button w3-circle w3-green\"/><br/>';
    $(d).after(str);
}
