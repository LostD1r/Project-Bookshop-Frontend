window.onload = function () {
    let scr_shelf_one = $(".shelf-one");
    let scr_shelf_two = $(".shelf-two");
    let scr_shelf_three = $(".shelf");
    scr_shelf_one.mousedown(function () {
        let startX = this.scrollLeft + event.pageX;
        let startY = this.scrollTop + event.pageY;
        scr_shelf_one.mousemove(function () {
            this.scrollLeft = startX - event.pageX;
            this.scrollTop = startY - event.pageY;
            return false;
        });
    });
    scr_shelf_two.mousedown(function () {
        let startX = this.scrollLeft + event.pageX;
        let startY = this.scrollTop + event.pageY;
        scr_shelf_two.mousemove(function () {
            this.scrollLeft = startX - event.pageX;
            this.scrollTop = startY - event.pageY;
            return false;
        });
    });
    scr_shelf_three.mousedown(function () {
        let startX = this.scrollLeft + event.pageX;
        let startY = this.scrollTop + event.pageY;
        scr_shelf_three.mousemove(function () {
            this.scrollLeft = startX - event.pageX;
            this.scrollTop = startY - event.pageY;
            return false;
        });
    });
    $(window).mouseup(function () {
        scr_shelf_one.off("mousemove");
    });
    $(window).mouseup(function () {
        scr_shelf_two.off("mousemove");
    });
    $(window).mouseup(function () {
        scr_shelf_three.off("mousemove");
    });
}