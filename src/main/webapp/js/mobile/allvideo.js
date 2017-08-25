/**
 * Created by Admin on 2017/8/17.
 */
(function ($) {
    var ls = sessionStorage.getItem('isLoad');
    if (ls == null || ls == undefined) {
        window.location.href = 'mobileIndex.html';
    }
    // var data = [1,2,3,4,5,6,7,8,9,10,11]; // 用于计算比例
    // $('#videoList').html(loadVideo(data));
    // 导航条
    $('#nav').click(function (e) {
        var id = e.target.getAttribute('id');
        var d = new Date();
        var t = d.getTime().toString();
        switch (id){
            case 'first': window.location.href = 'mobileIndex.html?t='+t;break;
            case 'video': window.location.href = 'allVideo.html?t='+t;break;
            case 'exam': window.location.href = 'exam.html?t='+t;break;
            case 'set': window.location.href = 'personSet.html?t='+t;break;
        }
    });
    // 获得所有视频列表
    var d = new Date();
    $.get('/SSMDemo/video/allVideo.action?t='+d.getTime().toString(),function(data){
        var str = '';
        for(var i = 0;i < data.length; i++) {
            str += '<div class="oneItem" data-id="'+data[i].id+'"><div class="imgBox"><img src="/pic/'+data[i].picname+'"></div><div class="courseName">'+data[i].name+'</div> </div>';
        }
        $('#videoList').html(str);
    });
    // 去具体视频播放
    $(document).on('click','.oneItem',function(){
        var id = $(this).attr('data-id');
        console.log(id);
        window.location.href = 'videoPlayer.html?id='+id;
    });
    /*
    * ****自定义方法
    * */
})($);
