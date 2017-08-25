/**
 * Created by Admin on 2017/8/23.
 */
(function () {
    var manage = sessionStorage.getItem('manageLoader');
    if (manage == undefined) {
        window.location.href = 'loginManage.html';
    }
    var nowPage = 0;
    $('.contentBox').height($('body').height() - 44);
    // 试卷管理
    $('#examManager').click(function () {
        if (nowPage != 0) {
            nowPage = 0;
            $('#frameBox').attr('src','../examManage.html');
        }
    });
    //随机试卷
    $('#random').click(function () {
        if (nowPage != 1) {
            nowPage = 1;
            $('#frameBox').attr('src','../random.html');
        }
    });
    // 上传学生信息
    $('#upStudent').click(function () {
        if (nowPage != 2) {
            nowPage = 2;
            $('#frameBox').attr('src','../upload.html');
        }
    });
    // 导出学生信息
    $('#downStudent').click(function () {
        if (nowPage != 3) {
            nowPage = 3;
            $('#frameBox').attr('src','downStu.html');
        }
    });
    // 上传视频
    $('#uploadVideo').click(function () {
        if (nowPage != 4) {
            nowPage = 4;
            $('#frameBox').attr('src','uploadVideo.html');
        }
    });
    // 上传试题
    $('#uploadExam').click(function () {
        if (nowPage != 5) {
            nowPage = 5;
            $('#frameBox').attr('src','upExam.html');
        }
    });
    // 下载试题
    $('#downExam').click(function () {
        if (nowPage != 6) {
            nowPage = 6;
            $('#frameBox').attr('src','downExam.html');
        }
    })
    // 类别管理
    $('#category').click(function () {
        if (nowPage != 7) {
            nowPage = 7;
            $('#frameBox').attr('src','category.html');
        }
    });
    // 退出后台管理
    $('#outManage').click(function () {
        $.get('/SSMDemo/index/logout.action',function () {
            sessionStorage.removeItem('manageLoader');
            window.location.href = 'loginManage.html';
        });
    });
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
    //退出选择多选题
    $(document).on('click','#out',function () {
        $('.wall').remove();
    })
    // 调用方法，改变iframe高度
    /*
    * ******自定义方法***由子区块调用
    * */

})($);
// 由子区块调用
function chooseCase() {
    $('body').append('<div class="wall"><div class="caseBox" id="case"><div class="caseTitle" id="caseT">加载中...<a href="javascript:void(0)" id="out">+</a> </div></div></div>');
    // 载入简答
    $.get('/SSMDemo/caseQues/allCase.action',function (data) {
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
