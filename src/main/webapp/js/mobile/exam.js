/**
 * Created by Admin on 2017/8/17.
 */
(function () {
    var ls = sessionStorage.getItem('isLoad');
    if (ls == null || ls == undefined) {
        window.location.href = 'mobileIndex.html';
    }
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
    //去练习
    $('#toTest').click(function (e) {
        e.stopPropagation();
        var d = new Date();
        window.location.href = 'testAndExam.html?type=0&t='+d.getTime().toString();
    });
    // 去考试
    $('#toExam').click(function(e){
        e.stopPropagation();
        var d = new Date();
        window.location.href = 'examList.html?t='+d.getTime().toString();
    });
})($);