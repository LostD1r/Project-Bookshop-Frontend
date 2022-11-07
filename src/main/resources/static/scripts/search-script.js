function makeSearch() {
    let url = new URL(document.location.href);
    let param = document.getElementById('search').value;
    url.searchParams.delete('search');
    url.searchParams.append('search', param);
    window.location.href = url.origin + '/catalog' + url.search;
}