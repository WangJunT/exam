/**
 * Created by Admin on 2017/8/8.
 */
(function ($) {
    var nowPage = 0;
    // 试卷管理
    $('#examManager').click(function () {
        if (nowPage != 0) {
            nowPage = 0;
            $('#frameBox').attr('src','examManage.html');
        }
    });
    //随机试卷
    $('#random').click(function () {
        if (nowPage != 1) {
            nowPage = 1;
            $('#frameBox').attr('src','random.html');
        }
    });
})($);