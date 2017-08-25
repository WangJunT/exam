/**
 * Created by Admin on 2017/8/17.
 */
(function ($) {
    var data = [1,2,3,4,5,6,7,8,9,10,11]; // 用于计算比例
    $('#videoList').html(loadVideo(data));
    // 导航条
    $('#nav').click(function (e) {
        var id = e.target.getAttribute('id');
        var d = new Date();
        var t = d.getTime().toString();
        switch (id){
            case 'first': window.location.href = 'mobileIndex.html?t='+t;break;
            case 'exam': window.location.href = 'exam.html?t='+t;break;
            case 'set': window.location.href = 'personSet.html?t='+t;break;
        }
    });
    /*
    * ****自定义方法
    * */
    function loadVideo(data){
        var str = '',all = [];
        for (var i = 0; i < data.length; i++) {

            all.push('<div class="oneItem item2"></div>');
        }
        return all.join('');
    }
})($);
