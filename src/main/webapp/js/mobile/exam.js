/**
 * Created by Admin on 2017/8/17.
 */
(function () {
    // 导航条
    $('#nav').click(function (e) {
        var id = e.target.getAttribute('id');
        var d = new Date();
        var t = d.getTime().toString();
        switch (id){
            case 'first': window.location.href = 'mobileIndex.html?t='+t;break;
            case 'video': window.location.href = 'allVideo.html?t='+t;break;
            case 'set': window.location.href = 'personSet.html?t='+t;break;
        }
    });
})($);