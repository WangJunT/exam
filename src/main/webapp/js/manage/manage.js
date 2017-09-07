/**
 * Created by Admin on 2017/8/23.
 */
(function () {
    var manage = sessionStorage.getItem('manageLoader');
    var headMenu = ['管理试卷'],nowMenu = 0,frameId=['examManager'];
    if (manage == undefined) {
        window.location.href = 'loginManage.html';
    }
    var nowPage = 0;
    //$('.contentBox').height($('body').height());
    $('#list1').show();
    // 头部标题点击
    $(document).on('click','#headMenu span',function () {
        $('#headMenu span').removeClass('chooseMenu');
        $(this).addClass('chooseMenu');
        //nowMenu =
        var src = $(this).attr('data-src');
        //console.log(src);
        $('#'+src).click();
    });
    // 删除头部标题
    $(document).on('click','#headMenu span > a',function (e) {
        e.stopPropagation();
        if (headMenu.length > 1) {
            var change = false;
            var po = Number($(this).attr('data-position'));
            if (nowMenu > po) {
                nowMenu -= 1;
            } else if (nowMenu == po) {
                change = true;
                if (nowMenu == headMenu.length - 1) {
                    nowMenu -= 1;
                }
            }
            headMenu.splice(po,1);
            frameId.splice(po,1);
            var str = '';
            for (var i = 0; i < headMenu.length; i++) {
                str += '<span data-src="' + frameId[i] + '">' + headMenu[i] + '<a href="javascript:void(0)" data-position="' + i + '">+</a> </span>';
            }
            $('#headMenu').html(str);
            $('#headMenu span').eq(nowMenu).addClass('chooseMenu');
            if (change) {
                $('#'+frameId[nowMenu]).click();
            }
        }
    })
    // 菜单点击效果
    $('.menuTitle').click(function () {
        var id = $(this).attr('data-id').replace(/[^0-9]/g,'');
        $('#menu ul').slideUp(300);
        $('#list'+ id).slideDown(300);
    });
    // 试卷管理
    $('#examManager').click(function () {
        if (nowPage != 0) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 0;
            $('#frameBox').attr('src','../examManage.html');
        }
    });
    //随机试卷
    $('#random').click(function () {
        if (nowPage != 1) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 1;
            $('#frameBox').attr('src','../random.html');
        }
    });
    // 上传学生信息
    $('#upStudent').click(function () {
        if (nowPage != 2) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 2;
            $('#frameBox').attr('src','../upload.html');
        }
    });
    // 导出学生信息
    $('#downStudent').click(function () {
        if (nowPage != 3) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 3;
            $('#frameBox').attr('src','downStu.html');
        }
    });
    // 上传视频
    $('#uploadVideo').click(function () {
        if (nowPage != 4) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 4;
            $('#frameBox').attr('src','uploadVideo.html');
        }
    });
    // 上传试题
    $('#uploadExam').click(function () {
        if (nowPage != 5) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 5;
            $('#frameBox').attr('src','upExam.html');
        }
    });
    // 下载试题
    $('#downExam').click(function () {
        if (nowPage != 6) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 6;
            $('#frameBox').attr('src','downExam.html');
        }
    })
    // 类别管理
    $('#category').click(function () {
        if (nowPage != 7) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 7;
            $('#frameBox').attr('src','category.html');
        }
    });
    // 上传简答题
    $('#uploadCase').click(function () {
        if(nowPage != 8) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 8;
            $('#frameBox').attr('src','upCase.html');
        }
    });
    // 学生信息查看
    $('#showStu').click(function () {
        if (nowPage != 9) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 9;
            $('#frameBox').attr('src','showStu.html');
        }
    });
    // 查看试题
    $('#showTopic').click(function () {
        if (nowPage != 10) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 10;
            $('#frameBox').attr('src','showTopic.html');
        }
    });
    // 查看视频课程
    $('#showVideo').click(function () {
        if (nowPage != 11) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 11;
            $('#frameBox').attr('src','showVideo.html');
        }
    });
    // 做题历史信息
    $('#showHistory').click(function () {
        if (nowPage != 12) {
            pushHead($(this).text(),$(this).attr('id'));
            nowPage = 12;
            $('#frameBox').attr('src','showHistory.html');
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
        var str = '',st1= '';
        $('input[name = case]:checked').each(function () {
            var id = $(this).attr('case-id');
            var choose = $(this).attr('data-chooseId');
            str += id + ',';
            st1 += choose + ',';
        });
        str = str.substr(0,str.length -1);
        st1 = st1.substr(0,st1.length - 1);
        $("#frameBox")[0].contentWindow.getCase(str, st1);
        $('.wall').remove();
    });
    //退出选择多选题
    $(document).on('click','#out',function () {
        $('.wall').remove();
    });
    // 调用方法，改变iframe高度
    /*
    * ******自定义方法***由子区块调用
    * */
    // 添加子区块\
    function pushHead(name,id) {
        var index = headMenu.indexOf(name);
        if (index > -1) { // 存在
            $('#headMenu span').removeClass('chooseMenu');
            $('#headMenu span').eq(index).addClass('chooseMenu');
            nowMenu = index;
        } else {
            if(headMenu.length < 5){
                headMenu.push(name);
                frameId.push(id);
                nowMenu = headMenu.length - 1;
                $('#headMenu span').removeClass('chooseMenu');
                $('#headMenu').append('<span class="chooseMenu" data-src="'+id+'">'+name+'<a href="javascript:void(0)" data-position="'+nowMenu+'">+</a> </span>');
            } else {
                headMenu[nowMenu] = name;
                frameId[nowMenu] = id;
                $('#headMenu span').eq(nowMenu).attr('data-src',id).html(name + '<a href="javascript:void(0)" data-position="'+nowMenu+'">+</a>');
            }
        }
    }
})($);
// 由子区块调用
function chooseCase() {
    $('body').append('<div class="wall"><div class="caseBox" id="case"><div class="caseTitle" id="caseT">加载中...<a href="javascript:void(0)" id="out">+</a> </div></div></div>');
    // 载入简答
    $.get('/SSMDemo/caseQues/allCase.action',function (data) {
        var str = '';
        for (var i = 0; i < data.length; i++) {
            var ls = '<div class="caseItem"><input type="checkbox" case-id="'+data[i].id+'" name="case" data-chooseId="'+(i+1)+'"><div class="textBox">'+(i + 1)+','+data[i].content+'</div></div>';
            str += ls;
        }
        str += '<input type="button" class="sureCase" value="确定" id="sureCase">';
        $('#caseT').html('选择简答题<a href="javascript:void(0)" id="out">+</a>');
        $('#case').append(str);
    });
}
//改变子区块
function changeFrame(height) {
    if (height < $(window).height() - 130) {
        height = $(window).height() - 130;
    }
    console.log(height);
    $('#frameBox').height(height);
    $('#menu').height($('.frameBox').height());
}
