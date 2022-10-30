function popupDescription(){
    document.getElementById('text-box-description').style.display = 'block';
    document.getElementById('text-box-characteristic').style.display = 'none';
    document.getElementById('text-box-reviews').style.display = 'none';
}

function popupCharacteristic(){
    document.getElementById('text-box-description').style.display = 'none';
    document.getElementById('text-box-characteristic').style.display = 'block';
    document.getElementById('text-box-reviews').style.display = 'none';
}

function popupReviews(){
    document.getElementById('text-box-description').style.display = 'none';
    document.getElementById('text-box-characteristic').style.display = 'none';
    document.getElementById('text-box-reviews').style.display = 'flex';
}