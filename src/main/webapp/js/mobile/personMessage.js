/**
 * Created by Admin on 2017/8/21.
 */
(function () {
    var ls = sessionStorage.getItem('isLoad');
    if (ls == 'undefined'|| ls == null) {
        login = false;
        window.location.href = 'personSet.html';
    } else {
        $('#userName').html(sessionStorage.getItem('loader'));
    }
    // 修改密码
    $('#change').click(function () {
        window.location.href = 'changePassword.html';
    });
    // 导航条
    $('#nav').click(function (e) {
        var id = e.target.getAttribute('id');
        var d = new Date();
        var t = d.getTime().toString();
        switch (id){
            case 'first': window.location.href = 'mobileIndex.html?t='+t;break;
            case 'exam': window.location.href = 'exam.html?t='+t;break;
            case 'video': window.location.href = 'allVideo.html?t='+t;break;
        }
    });
    // 退出登录
    $('#signOut').click(function () {
        sessionStorage.removeItem('isLoad');
        $.get('/SSMDemo/index/logout.action',function () {
            window.location.href = 'personSet.html';
        });
    });
})($);
