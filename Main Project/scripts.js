window.onload = function () {
    var scr_shelf_one = $(".shelf-one");
    var scr_shelf_two = $(".shelf-two");
    var scr_shelf_three = $(".shelf-three");
    scr_shelf_one.mousedown(function () {
        var startX = this.scrollLeft + event.pageX;
        var startY = this.scrollTop + event.pageY;
        scr_shelf_one.mousemove(function () {
            this.scrollLeft = startX - event.pageX;
            this.scrollTop = startY - event.pageY;
            return false;
        });
    });
    scr_shelf_two.mousedown(function () {
        var startX = this.scrollLeft + event.pageX;
        var startY = this.scrollTop + event.pageY;
        scr_shelf_two.mousemove(function () {
            this.scrollLeft = startX - event.pageX;
            this.scrollTop = startY - event.pageY;
            return false;
        });
    });
    scr_shelf_three.mousedown(function () {
        var startX = this.scrollLeft + event.pageX;
        var startY = this.scrollTop + event.pageY;
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