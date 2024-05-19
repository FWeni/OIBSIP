function updatePage(name,surname,dob,email_address) {
  let section = document.getElementById("trips-section");

  if(section.style.display === "none") {
    section.style.display = "block";
  }

  let userInitial = name.charAt(0).toUpperCase();
  document.getElementById("dropdown-btn").innerText =  userInitial;

  let userName = name;
  document.getElementById("user-name").innerText = userName;

  let userSurname = surname;
  document.getElementById("user-surname").innerText = userSurname;

  let userEmail = email_address;
  document.getElementById("user-email").innerText = userEmail;

  let userDob = dob;
  document.getElementById("user-dob").innerText = userDob;
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

    // fetch('/api/users', options)
    // .then(res => res.json())
    // .then(window.location.href = "/home")
    // .then(res => updatePage(res.name,res.lastname,res.birthdate,res.email))
    // .catch(err => console.log(err));
    try {
      let response = await fetch('/api/users', options);
      window.location.href = "/home";

      let userData = response.json();
      console,log(userData);
      updatePage(userData.name,userData.lastname,user.birthdate,userData.email);
      // data
      console.log(response);
      return response.json();
    } catch (error) {
      console.log('There was a problem with the fetch operation:', error);
    }

}