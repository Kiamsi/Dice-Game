const userName = document.getElementById("username-input");
const password = document.getElementById("password-input");
const submit = document.getElementById("submitButton");

submit.addEventListener("click", (e)=>{
    e.preventDefault();
    fetch("https://dice-game-m9fk.onrender.com/api/users/register", {
        method: "POST",
        body: JSON.stringify({username: userName.textContent, password: password.textContent})
    })
    .then((res)=>{
        console.log(res);
        
        if (res.status != 200) {
            throw new Error(res.statusText);
        }
        console.log(res);
        window.alert("Succesfull registration");
    })
    .catch((e)=>{window.alert(`${e}`)});
});