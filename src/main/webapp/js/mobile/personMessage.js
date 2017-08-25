/**
 * Created by Admin on 2017/8/21.
 */
(function () {
    var ls = sessionStorage.getItem('isLoad');
    var login = false;
    if (ls == 'undefined'|| ls == null) {
        login = false;
        window.location.href = 'personSet.html';
    } else {
        login = true;
        $('#userName').html(sessionStorage.getItem('loader'));
    }
    // 修改密码
    $('#change').click(function () {
        window.location.href = 'changePassword.html';
    });
    // 获取个人信息
    $.get('/SSMDemo/stu/myself.action',function (data) {
        $('#account').html(data.phone);
        $('#cardId').html(data.idcard);
    });
    // 退出登录
    $('#signOut').click(function () {
        sessionStorage.removeItem('isLoad');
        $.get('/SSMDemo/index/logout.action',function () {
            window.location.href = 'personSet.html';
        });
    });
})($);
