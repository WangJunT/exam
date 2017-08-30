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
    var current = 1,now = 1,allRecord = 0,allpage = 0;//页码
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
    // 获得视频列表
   getVideo(1);
    // 去具体视频播放
    $(document).on('click','.oneItem',function(){
        var id = $(this).attr('data-id');
        // console.log(id);
        window.location.href = 'videoPlayer.html?id='+id;
    });
    // 监听滚动条
    $(document).scroll(function () {
        var top = $(window).scrollTop();
        var height = $(window).height();
        if (height*1 + top >= $('body').height() - 20) {
            // console.log('到达底部');
            if (now < allpage ){
                now += 1;
                getVideo(now);
            }
        }
    });
    /*
    * ****自定义方法
    * */
    function getVideo(current) {
        $.get('/SSMDemo/video/allVideo.action?current='+current+'&pageSize=20',function(data, status){
            if (status == 'success') {
                console.log(data);
                allRecord = data.totalRecord;
                allpage = data.totalPage;
                now = data.currentPage;
                var str = '';
                if (current == 1 && data.dataList == undefined){
                    str = '<div style="font-size: 0.36rem;text-align: center">当前工种没有视频课程.</div>';
                } else {
                    for(var i = 0;i < data.dataList.length; i++) {
                        str += '<div class="oneItem" data-id="'+data.dataList[i].id+'"><div class="imgBox"><img src="/pic/'+data.dataList[i].picname+'"></div><div class="courseName">'+data.dataList[i].name+'</div> </div>';
                    }
                }
                $('#videoList').append(str);
            } else {
                alert('发生意外，请稍后重试');
            }
        });
    }
})($);
