/**
 * Created by Admin on 2017/8/8.
 */
(function ($) {
    var nowPage = 0;
    var frame = document.getElementById('frameBox');
    // 试卷管理
    $('#examManager').click(function () {
        if (nowPage != 0) {
            nowPage = 0;
            $('#frameBox').attr('src','examManage.html');
        }
    });
    //随机试卷
    $('#random').click(function () {
        if (nowPage != 1) {
            nowPage = 1;
            $('#frameBox').attr('src','random.html');
        }
    });
    //退出
    $(document).on('click','#out',function () {
        $('.wall').remove();
    })
    // 确认多选题
    $(document).on('click','#sureCase',function () {
        var str = '';
        $('input[name = case]:checked').each(function () {
            var id = $(this).attr('case-id');
            str += id + ',';
        });
        str = str.substr(0,str.length -1);
        $("#frameBox")[0].contentWindow.getCase(str);
        $('.wall').remove();
    })
    // 调用方法，改变iframe高度

})($);
// function
function chooseCase() {
    $('body').append('<div class="wall"><div class="caseBox" id="case"><div class="caseTitle" id="caseT">加载中...<a href="javascript:void(0)" id="out">+</a> </div></div></div>');
    // 载入简答
    $.get('../../../SSMDemo/caseQues/allCase.action',function (data) {
        var str = '';
        for (var i = 0; i < data.length; i++) {
            var ls = '<div class="caseItem"><input type="checkbox" case-id="'+data[i].id+'" name="case"><div class="textBox">'+data[i].content+'</div></div>';
            str += ls;
        }
        str += '<input type="button" class="sureCase" value="确定" id="sureCase">';
        $('#caseT').html('选择简答题<a href="javascript:void(0)" id="out">+</a>');
        $('#case').append(str);
        
    });
}
// change iframe
function changeFrame(height) {
    $("#frameBox").css('height',height+'px');
}