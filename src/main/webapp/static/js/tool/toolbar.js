function loginPage() {
    $("#loginPage").css("display", "");
    $("#register").css("display", "none");
}

$(".toollogin").on("click", loginPage);

function registerPage() {
    $("#loginPage").css("display", "none");
    $("#register").css("display", "");
}

$(".toolregister").on("click", registerPage);