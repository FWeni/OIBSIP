
function formPopUp() {
  var popup = document.getElementById("formPopup");
  popup.classList.toggle("show");
}

function cancelFormPopup() {
  var cancelPopup = document.getElementById("cancelFormPopup");
  cancelPopup.classList.toggle("show");
}

function openTab(e,tabName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tab-content");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tab-links");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  e.currentTarget.className += " active";
}
