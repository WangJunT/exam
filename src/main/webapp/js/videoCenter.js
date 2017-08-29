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
    });
    // 载入视频列表
    var d = new Date();
    var current = 1,size = 20,allRecord = 0,allpage = 0;//页码
    $.get('/SSMDemo/video/allVideo.action?current='+current+'&pageSize=20',function(data){
        var str = '';
        // console.log(data);
        //data = JSON.parse(data);
        allRecord = data.totalRecord;
        allpage = data.totalPage;
        for(var i = 0;i < data.dataList.length; i++) {
            str += '<li data-id="'+data.dataList[i].id+'"><div class="imgBox"><img src="/pic/'+data.dataList[i].picname+'"></div><div class="nameBox">'+data.dataList[i].name+'</div> </li>';
        }
        $('#allVideo').html(str);
    });
    // 总页数大于1才显示
    if (allpage > 1) {
        $('#paging').pagination({
            currentPage: 1,// 当前页数
            totalPage: 16,// 总页数
            isShow: true,// 是否显示首尾页
            count: 7,// 显示个数
            homePageText: "首页",// 首页文本
            endPageText: "尾页",// 尾页文本
            prevPageText: "上一页",// 上一页文本
            nextPageText: "下一页",// 下一页文本
            callback: function(current) {
                // 回调,current(当前页数)
                $.get('/SSMDemo/video/allVideo.action?current='+current+'&pageSize=20',function(data){
                    //data = JSON.parse(data);
                    var str = '';
                    for(var i = 0;i < data.dataList.length; i++) {
                        str += '<li data-id="'+data.dataList[i].id+'"><div class="imgBox"><img src="/pic/'+data.dataList[i].picname+'"></div><div class="nameBox">'+data.dataList[i].name+'</div> </li>';
                    }
                    $('#allVideo').html(str);
                });
                ///////////////////the end//////////////////
            }
        });
    }

    /*
    * ********自定义方法
    * */
    // 退出登录
    function logOut() {
        $.get('/SSMDemo/index/logout.action',function (data,status) {
            if (status == 'success') {
                window.location.reload('/SSMDemo/inde/first.action');
            } else {
                alert('退出过程发生意外.');
            }
        });
    }
})();
