/**
 * Created by Admin on 2017/8/23.
 */
(function () {
    var login = false,code = 0, how = 0;
    //var ls = opCookie.get('isLoad');
    var ls = sessionStorage.getItem('isLoad');
    if (ls == 'undefined'|| ls == null) {
        window.location.href = '/SSMDemo/index/first.action';
    } else {
        login = true;
    }
    //alert(login);
    if (!login) {
        $('#user').css('display','none');
        $('#log').html('登录');
    } else {
        $('#user').html(sessionStorage.getItem('loader'));
    }
    // 去具体视频区域
    $(document).on('click','#allVideo li',function () {
        var id = $(this).attr('data-id');
        window.location.href = 'videoPlayer.html?id='+id;
    });
    // 登录或退出
    $('#log').click(function () {
            sessionStorage.removeItem('isLoad');
            logOut();
            window.location.reload('/SSMDemo/inde/first.action');
    });
    // 载入视频列表
    var d = new Date();
    $.get('/SSMDemo/video/allVideo.action?t='+d.getTime().toString(),function(data){
        var str = '';
        console.log(data);
        for(var i = 0;i < data.length; i++) {
            str += '<li data-id="'+data[i].id+'"><div class="imgBox"><img src="/pic/'+data[i].picname+'"></div><div class="nameBox">'+data[i].name+'</div> </li>';
        }
        $('#allVideo').html(str);
    });
    // 退出登录
    function logOut() {
        $.get('/SSMDemo/index/logout.action',function () {
        });
    }
})();
