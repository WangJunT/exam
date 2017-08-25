/**
 * Created by Admin on 2017/8/25.
 */
(function($){
    var ls = sessionStorage.getItem('isLoad');
    if (ls == null || ls == undefined) {
        widndow.location.href = 'mobileIndex.html';
    }
    var id = Number(getQueryString('id'));
    $.get('/SSMDemo/video/watchVideo.action?id='+id,function (data) {
        console.log(data);
        $('#content').html(data.content);
        var flashvars={
            f:'/pic/'+data.reserveOne,
            c:0,
            p:1
        };
        var video=['/pic/'+data.reserveOne];
        CKobject.embed('../../ckplayer/ckplayer.swf','video','ckplayer_a1',$('body').width(),'300',false,flashvars,video);
    });
    //获得url数据
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return decodeURIComponent(r[2]);
        return null;
    }
})($);
