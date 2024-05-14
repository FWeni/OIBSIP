// function loadUser(name,surname,e_mail){
//    let firstName = document.getElementById("first-name");
//    firstName.innerHTML = "${name}";

//    let lastName = document.getElementById("last-name");
//    lastName.innerHTML = "${surname}";

//    let e_mail = document.getElementById("email");
//    e_mail.innerHTML = "${email}"
// }
//function postData() {
//     document.getElementById('registration_form').addEventListener('click', function(event) {
//          event.preventDefault();
//
//          let registration = {};
//          let fd = new FormData(registration_form);
//          fd.forEach( (v,k) => {registration[k] = v;});
//          console.log(JSON.stringify(registration));
//
//          const options = {
//          method: 'POST',
//          body: JSON.stringify(registration),
//          headers: { 'Content-Type': 'application/json' }
//          }
//          fetch('/api/users', options)
//               .then(res => res.json())
//               .then(res => console.log(res.json))
//               .catch(err => console.error(err));
//
//
//      });
//}

function updatePage(name,surname,email_address) {
  let section = document.getElementById("trips-section");

  if(section.style.display === "none") {
    section.style.display = "block";
  }

  let userInitial = name.charAt(0).toUpperCase();
  document.getElementById("drop-down").innerText =  userInitial;
}

registration_form.onsubmit = async (e) => {
    e.preventDefault();
    let reg = {};
    let fd = new FormData(registration_form);
    fd.forEach( (v,k) => {reg[k] = v;});
    
    const options = {
    method: 'POST',
    body: JSON.stringify(reg),
    headers: { 'Content-Type': 'application/json' }
    }
    try {
      let response = await fetch('/api/users', options);
      window.location.href = "/home";

      let userData = response.user;
      console,log(userData);
      updatePage(userData.name,userData.lastname,userData.email);
      // data
      console.log(response);
      return response;
    } catch (error) {
      console.log('There was a problem with the fetch operation:', error);
    }

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