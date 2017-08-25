/**
 * Created by Admin on 2017/8/16.
 */
(function ($) {
    var ls = sessionStorage.getItem('isLoad'),status = 0;
    if (ls == 'undefined' || ls == null) { //未登录不可访问
        window.location.href = '/SSMDemo/index/first.action';
    }
    // 登录或退出
    $('#log').click(function () {
        sessionStorage.removeItem('isLoad');
        logOut();
        window.location.reload('/SSMDemo/inde/first.action');
    });
    //window.history.forward(1);
    $('#user').html(sessionStorage.getItem('loader'));
    // 学生信息
    $('#personMsg').click(function () {
        if (status != 0) {
            status = 0;
            $('#frameBox').attr('src','student/studentMsg.html');
        }
    });
    // 练习历史
    $('#history').click(function () {
        if(status != 2){
            status = 2;
            $('#frameBox').attr('src','student/historyList.html');
        }
    });
    // 修改密码
    $('#change').click(function () {
        if (status != 1) {
            status = 1;
            $('#frameBox').attr('src','student/change.html');
        }
    });
    // 退出登录
    function logOut() {
        $.get('/SSMDemo/index/logout.action',function () {
        });
    }
})($);