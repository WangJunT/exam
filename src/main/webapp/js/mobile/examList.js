/**
 * Created by Admin on 2017/8/21.
 */
(function ($) {
    var ls = sessionStorage.getItem('isLoad');
    if (ls == 'undefined'|| ls == null) {
        window.location.href = 'mobileIndex.html';
    } else {
    }
    // 获取试卷
    var current = 1,size = 20,allRecord = 0,allpage = 0;//页码
    getList(1);
    // 去考试
    $(document).on('click','#goTo',function (e) {
        var theId = e.target.getAttribute('data-ExamId');
        var url = 'testAndExam.html?type=1&id='+theId;
        window.location.href = url;
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
    /**
     * ***************function
     * *****
     * **/
    function getList(current) {
        $.get('/SSMDemo/exam/selectAll.action?current='+current+'&pageSize=20',function(data, status){
            if (status == 'success') {
                // console.log(data);
                allRecord = data.totalRecord;
                allpage = data.totalPage;
                now = data.currentPage;
                var str = '';
                for(var i = 0;i < data.dataList.length; i++) {
                    str += '<li>'+data.dataList[i].name+'<input type="button" id="goTo" data-ExamId="'+data.dataList[i].id+'" value="去考试"></li>';
                }
                $('#allBox').append(str);
            } else {
                alert('发生意外，请稍后重试');
            }
        });
    }
})($);
