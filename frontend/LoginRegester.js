const userName = document.getElementById("username-input");
const password = document.getElementById("password-input");
const registerButton = document.getElementById("registerButton");
const loginButton = document.getElementById("loginButton");

registerButton.addEventListener("click", (e)=>{
    e.preventDefault();
    register(userName.value, password.value);
});
loginButton.addEventListener("click", (e)=>{
    e.preventDefault();
    if(login(userName.value, password.value)){
        window.location.href = "../Main Page/main.html"
    }
});

function register(username, password){
    let isSuccess = false;
    fetch("https://dice-game-m9fk.onrender.com/api/users/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({username: username, password: password})
    })
    .then((res)=>{
        console.log(res);
        if (res.status >= 300) {
            throw new Error(res.statusText);
        }
        console.log(res);
        window.alert("Succesfull registration");
        isSuccess = true;
    })
    .catch((e)=>{window.alert(`${e}`)});
    return isSuccess;
}

function login(username, password){
    let isSuccess = false;
    fetch("https://dice-game-m9fk.onrender.com/api/users/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({username: username, password: password})
    })
    .then((res)=>{
        console.log(res);
        
        if (res.status >= 300) {
            throw new Error(res.statusText);
        }
        console.log(res);
        window.alert("Succesfull login");
        isSuccess = true;
    })
    .catch((e)=>{window.alert(`${e}`)});
    return isSuccess;
}