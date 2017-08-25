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

        }
    });
    // 退出登录
    function logOut() {
        $.get('/SSMDemo/index/logout.action',function () {
        });
    }
})($);