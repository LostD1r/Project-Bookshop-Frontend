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

function makeSearch() {
    let url = new URL(document.location.href);
    let param = document.getElementById('search').value;
    url.searchParams.append('search', param);
    window.location.href = url.origin + url.pathname + url.search;
}