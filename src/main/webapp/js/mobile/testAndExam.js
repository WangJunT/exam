/**
 * Created by Admin on 2017/8/21.
 */
(function () {
    var ls = sessionStorage.getItem('isLoad');
    if (ls == 'undefined'|| ls == null) {
        login = false;
        window.location.href = 'mobileIndex.html';
    } else {
    }
    var tureAns = [],exam=[],type = 'radio',option=['A','B','C','D','E','F','G'],from,examId,url,examData;
    var position = 1,TheChoose = [];//记录用户选项
    var start = 0, length = 10,beginStart = 0;
    var model = '<div class="examItem"><div class="itemTitle">{{item}}，{{title}} <br><a href="javascript:void(0)" id="showAns" data-itemId="{{index}}" data-id="{{id}}" typeId="{{type}}"class="dif">查看答案</a></div> <ul>{{option}}</ul></div>';
    //判断是否登录
    //var ls = opCookie.get('isLoad');
    var ls = sessionStorage.getItem('isLoad');
    if (ls == 'undefined' || ls == null) { //未登录不可访问
        window.location.href = '/SSMDemo/index/first.action';
    }
})($);
