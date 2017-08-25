/**
 * Created by Admin on 2017/8/18.
 */
!(function(doc, win) {
    var docEle = doc.documentElement;
        fn = function() {
            var width = docEle.clientWidth;
            width && (docEle.style.fontSize = 100 * (width / 750) + "px");
        };
    doc.addEventListener("DOMContentLoaded", fn, false);
}(document, window));