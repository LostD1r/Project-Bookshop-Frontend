let expanded = false;

function showCheckboxesGenres() {
    let checkboxes = document.getElementById("boxes-genres");
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
    let checkboxes = document.getElementById("boxes-publishing");
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
    let checkboxes = document.getElementById("boxes-authors");
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