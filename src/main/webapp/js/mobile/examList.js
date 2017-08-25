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
    $.get('/SSMDemo/exam/selectAll.action',function (data) {
        if (data[1] == '!'){
            alert('登录已失效');
            window.location.href = 'mobileIndex.html';
        } else {
            var con='';
            var str ='';
            for (var i = 0; i < data.length; i++) {
                con += '<li>'+data[i].name+'<input type="button" id="goTo" data-ExamId="'+data[i].id+'" value="去考试"></li>';
            }
            str += con+'</ul>';
            $('#allBox').html(str);
        }
    });
    // 去考试
    $(document).on('click','#goTo',function (e) {
        var theId = e.target.getAttribute('data-ExamId');
        var url = 'testAndExam.html?type=1&id='+theId;
        window.location.href = url;
    });
})($);
