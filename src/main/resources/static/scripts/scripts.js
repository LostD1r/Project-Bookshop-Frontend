window.onload = function () {
    let scr_shelf_index = $(".shelf");
    let scr_shelf_author = $(".author-books-shelf");
    scr_shelf_index.mousedown(function () {
        let startX = this.scrollLeft + event.pageX;
        let startY = this.scrollTop + event.pageY;
        scr_shelf_index.mousemove(function () {
            this.scrollLeft = startX - event.pageX;
            this.scrollTop = startY - event.pageY;
            return false;
        });
    });
    scr_shelf_author.mousedown(function () {
        let startX = this.scrollLeft + event.pageX;
        let startY = this.scrollTop + event.pageY;
        scr_shelf_author.mousemove(function () {
            this.scrollLeft = startX - event.pageX;
            this.scrollTop = startY - event.pageY;
            return false;
        });
    });
    $(window).mouseup(function () {
        scr_shelf_index.off("mousemove");
    });
    $(window).mouseup(function () {
        scr_shelf_author.off("mousemove");
    });
}