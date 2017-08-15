/**
 * Created by Admin on 2017/8/10.
 */
(function ($) {
    var str = '<ul>';
    var ls = opCookie.get('isLoad');
    console.log(ls);
    if (ls == 'undefined') { //未登录不可访问
        window.location.href = '/SSMDemo/index/first.action';
    }
    window.history.forward(1);
    $('#user').html(opCookie.get('loader'));
    // 获取试卷
    $.get('/SSMDemo/exam/selectAll.action',function (data) {
        var con='';
        for (var i = 0; i < data.length; i++) {
            con += '<li>'+data[i].name+'<a href="javascript:void(0)" id="goTo" data-ExamId="'+data[i].id+'">去考试</a></li>';
        }
        str += con+'</ul>';
        $('#listBox').html(str);
    });
    $(document).on('click','#goTo',function (e) {
        var theId = e.target.getAttribute('data-ExamId');
        var url = 'sequenceExam.html?type=1&id='+theId;
        window.location.href = url;
    });
    //
    // 退出登录
    $('#log').click(function () {
        opCookie.remove('isLoad');
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