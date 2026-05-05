const userName = document.getElementById("username-input");
const password = document.getElementById("password-input");
const submit = document.getElementById("submitButton");

submit.addEventListener("click", (e)=>{
    e.preventDefault();
    fetch("", {
        method: "POST",
        body: JSON.stringify({username: userName.textContent, password: password.textContent})
    })
    .then(()=>{window.alert("Succesfull registration")})
    .catch((e)=>{window.alert(`Error: ${e}`)});
});