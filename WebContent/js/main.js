var modal = document.getElementById("myModal");


var btn = document.getElementById("myBtn");


var span = document.getElementsByClassName("close")[0];


btn.onclick = function() {
  modal.style.display = "block";
}

span.onclick = function() {
  modal.style.display = "none";
}


window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
//modal1(edit)=================================================================================================================================

var modal1 = document.getElementById("myModal1");


var btn1 = document.getElementById("myBtn1");


var span = document.getElementsByClassName("close1")[0];


btn1.onclick = function() {
  modal1.style.display = "block";
}


span.onclick = function() {
  modal1.style.display = "none";
}


window.onclick = function(event) {
  if (event.target == modal1) {
    modal1.style.display = "none";
  }
}
//modal2(delete)========================================================================================================================
var modal2 = document.getElementById("myModal2");


var btn = document.getElementById("myBtn2");


var span = document.getElementsByClassName("close2")[0];


btn.onclick = function() {
  modal2.style.display = "block";
}


span.onclick = function() {
  modal2.style.display = "none";
}


window.onclick = function(event) {
  if (event.target == modal) {
    modal2.style.display = "none";
  }
}
//editcolom------------------------------------------------------------------------------------------------------------------------------------------
var a = document.getElementsByClassName("cancel")[0];
a.onclick=function()
{
  modal1.style.display="none";
}
var a = document.getElementsByClassName("cancel-add")[0];
a.onclick=function()
{
  modal.style.display="none";
}
//delete colom------------------------------------------------------------------------------------------------------------------------------
var btn = document.getElementById("cancel");
btn.onclick=function()
{
  modal2.style.display="none";
}
//=====================================================================================================================================================
function resFunction() {
  document.getElementById("edit").reset();
}

function newFunction() {
  document.getElementById("add").reset();
}
//click check functionality==================================================================================================================================================

function selects() 
{
  var elements = this.form.getElementsByTagName('input');
  for (var i = elements.length; i--; ) 
  {
      if (elements[i].type == 'checkbox') 
      {
          elements[i].checked = this.checked;
      }
  }
}

         