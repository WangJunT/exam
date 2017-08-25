/**
 * Created by Admin on 2017/8/24.
 */
(function ($) {
    var login = false,code = 0, how = 0;
    //var ls = opCookie.get('isLoad');
    var ls = sessionStorage.getItem('isLoad');
    if (ls == 'undefined'|| ls == null) {
        window.location.href = '/SSMDemo/index/first.action';
    } else {
        login = true;
    }
    $('#user').html(sessionStorage.getItem('loader'));
    var id = Number(getQueryString('id'));
    $.get('/SSMDemo/video/watchVideo.action?id='+id,function (data) {
        console.log(data);
        var flashvars={
            f:'/pic/'+data.reserveOne,
            c:0,
            p:1
        };
        var video=['/pic/'+data.reserveOne];
        CKobject.embed('../ckplayer/ckplayer.swf','video','ckplayer_a1','700','500',false,flashvars,video);
    });
    // 登录或退出
    $('#log').click(function () {
        sessionStorage.removeItem('isLoad');
        logOut();
        window.location.reload('/SSMDemo/inde/first.action');
    });
    /*
    *
    * ******自定义方法
    * */
    //获得url数据
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return decodeURIComponent(r[2]);
        return null;
    }
    // 退出登录
    function logOut() {
        $.get('/SSMDemo/index/logout.action',function () {
        });
    }
})($);
