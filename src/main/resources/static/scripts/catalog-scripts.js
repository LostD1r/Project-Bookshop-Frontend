// function dropdownOpen(){
//     document.getElementById("dropdown-items").classList.add("show");
// }
//
// window.onclick = function (event){
//     if(!event.target.matches('.dropdown-main-button')){
//         let dropdowns = document.getElementsByClassName("dropdown-content");
//         let i;
//         for(i = 0; i < dropdowns.length; i++){
//             let openDropdown = dropdowns[i];
//             if(openDropdown.classList.contains("show")){
//                 openDropdown.classList.remove("show");
//             }
//         }
//     }
// }

let expanded = false;

function showCheckboxesGenres() {
    let checkboxes = document.getElementById("checkboxes-genres");
    if (!expanded)
    {
        checkboxes.style.display = "block";
        expanded = true;
    }
    else
    {
        checkboxes.style.display = "none";
        expanded = false;
    }
}

function showCheckboxesPublishing() {
    let checkboxes = document.getElementById("checkboxes-publishing");
    if (!expanded)
    {
        checkboxes.style.display = "block";
        expanded = true;
    }
    else
    {
        checkboxes.style.display = "none";
        expanded = false;
    }
}
function showCheckboxesAuthors() {
    let checkboxes = document.getElementById("checkboxes-authors");
    if (!expanded)
    {
        checkboxes.style.display = "block";
        expanded = true;
    }
    else
    {
        checkboxes.style.display = "none";
        expanded = false;
    }
}
