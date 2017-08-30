/**
 * Created by Admin on 2017/8/10.
 */
(function ($) {
    var str = '<ul>';
    //var ls = opCookie.get('isLoad');
    var ls = sessionStorage.getItem('isLoad');
    if (ls == 'undefined' || ls == null) { //未登录不可访问
        window.location.href = '/SSMDemo/index/first.action';
    }
    //window.history.forward(1);
    $('#user').html(sessionStorage.getItem('loader'));
    // 获取试卷
    var current = 1,size = 20,allRecord = 0,allpage = 0;//页码
    $.get('/SSMDemo/exam/selectAll.action?current='+current+'&pageSize=20',function (data) {
        if (data[1] == '!'){
            alert('登录已失效');
            window.location.href = 'mobileIndex.html';
        } else {
            var str = '';
            //console.log(data);
            if (data.dataList == undefined) {
               str = '当前工种没有可做试卷';
            } else {
                for (var i = 0; i < data.dataList.length; i++) {
                    str += '<li>'+data.dataList[i].name+'<a href="javascript:void(0)" id="goTo" data-ExamId="'+data.dataList[i].id+'">去考试</a></li>';
                }
            }
            $('#listBox').html(str);
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
                        $.get('/SSMDemo/exam/selectAll.action?current='+current+'&pageSize=20',function(data){
                            ///////////////////////////////////////////////////////////
                            for (var i = 0; i < data.length; i++) {
                                str += '<li>'+data[i].name+'<a href="javascript:void(0)" id="goTo" data-ExamId="'+data.dataList[i].id+'">去考试</a></li>';
                            }
                            $('#listBox').html(str);
                        });
                        ///////////////////the end//////////////////
                    }
                });
            }
        }
    });
    $(document).on('click','#goTo',function (e) {
        var theId = e.target.getAttribute('data-ExamId');
        var t = new Date();
        var url = 'sequenceExam.html?type=1&id='+ theId + '&t='+t.getTime().toString();
        window.location.href = url;
    });
    //
    // 退出登录
    $('#log').click(function () {
        //opCookie.remove('isLoad');
        sessionStorage.removeItem('isLoad');
        logOut();
        // window.location.href = '/SSMDemo/index/first.action';
    });
    //// 退出登录
    function logOut() {
        $.get('/SSMDemo/index/logout.action',function () {
            window.location.href = '/SSMDemo/index/first.action';
        });
    }
})($);