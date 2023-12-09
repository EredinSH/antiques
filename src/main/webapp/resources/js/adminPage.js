function userSideBarFunc() {
    var x = document.getElementById("userMenu");
    if (x.className.indexOf("sb-show") === -1) {
        x.className += " sb-show";
        x.previousElementSibling.className += " sb-green";
    } else {
        x.className = x.className.replace(" sb-show", "");
        x.previousElementSibling.className =
            x.previousElementSibling.className.replace(" sb-green", "");
    }
}

function itemSideBarFunc() {
    var x = document.getElementById("itemMenu");
    if (x.className.indexOf("sb-show") === -1) {
        x.className += " sb-show";
        x.previousElementSibling.className += " sb-green";
    } else {
        x.className = x.className.replace(" sb-show", "");
        x.previousElementSibling.className =
            x.previousElementSibling.className.replace(" sb-green", "");
    }
}

function sbOpen() {
    document.getElementById("main").style.marginLeft = "25%";
    document.getElementById("mySidebar").style.width = "25%";
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("openNav").style.display = 'none';
}

function sbClose() {
    document.getElementById("main").style.marginLeft = "0%";
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("openNav").style.display = "inline-block";
}
