/**
 * Created by Admin on 2017/8/21.
 */
(function ($) {
    var tureAns = [],exam = [],type = 'radio',option=['A','B','C','D','E','F','G'],from,examId,url,examData;
    var position = 1,TheChoose = [];//记录用户选项
    var theCase = [],theScore = [];// 记录多选题
    var start = 0, curlP = 0,beginStart = 0,time = 0,
        topicId = 0,nowP = 0 ;// 题目id
    var ls = sessionStorage.getItem('isLoad');
    var M ={};// 用于弹窗应用
    if (ls == 'undefined' || ls == null) { //未登录不可访问
        window.location.href = '/SSMDemo/index/first.action';
    }
    //window.history.forward(1);
    $('#user').html(sessionStorage.getItem('loader'));
    // 解析url
    from = getQueryString('type');
    examId= getQueryString('id');
    if (from == 0) {// 练习
        var d =  new Date();
        url = '/SSMDemo/question/selAll.action?t='+d.getTime().toString();
        $('#handIn').html('结束练习');
        $('#leftBox').css('display','none');
    } else {
        var d =  new Date();
        url = '/SSMDemo/exam/beginExam.action?id='+ examId+'&t='+d.getTime().toString();
    }
    if(from == 0) {
        $('#title').html('顺序练习');
    } else {
        $('#title').html('模拟考试');
    }
    // 退出登录
    $('#log').click(function () {
        sessionStorage.removeItem('isLoad');
        //opCookie.remove('isLoad');
        logOut();
        // window.location.href = '/SSMDemo/index/first.action';
    });
    // 下一题
    $('#next').click(function () {
        if (from == 0 ) {
            if(curlP < examData.length - 1 ) {
                curlP += 1;
                var type = 0;
                if (examData[curlP].typeId == 1) {
                    type = 0;
                } else if (examData[curlP].typeId == 2) {
                    type = 1;
                } else if (examData[curlP].typeId == 3) {
                    type = 2;
                }
                showExam(examData[curlP], curlP, type, 0);
            }
        } else {
            if (nowP < exam.length) {
                $('#menu li ').css('border','#dddddd 1px solid');
                nowP += 1;
                show(nowP);
            }
        }
    });
    // 上一题
    $('#last').click(function () {
        if (from == 0) {
            if(curlP > 0) {
                curlP -= 1;
                var type = 0;
                if (examData[curlP].typeId == 1) {
                    type = 0;
                } else if (examData[curlP].typeId == 2) {
                    type = 1;
                } else if (examData[curlP].typeId == 3) {
                    type = 2;
                }
                showExam(examData[curlP], curlP, type, 0);
            }
        } else {
            if (nowP > 0) {
                $('#menu li ').css('border','#dddddd 1px solid');
                nowP -= 1;
                show(nowP);
            }
        }
    });
    // 点击跳转到指定题目
    $(document).on('click','#menu li',function (e) {
        var id = $(this).attr('data-id');
        $('#menu li').css('border','#dddddd 1px solid');
        nowP = Number(id);
        show(nowP);
    });
    // 点击交卷
    $('#handIn').click(function () {
        if (from == 0){
            window.location.href = '/SSMDemo/index/first.action';
        } else { // 考试提交
            var num = 0;
            // ........
            for (var i = 0; i < theScore.length; i++) {
                if (theScore[i] != undefined) {
                    num += Number(theScore[i]);
                }
            }
            // 提交数据
            $.get('/SSMDemo/sexam/sorup.action?exampaperId=' + Number(examId) + '&score=' + num, function (data) {
                // 弹窗
                M.dialog2 = jqueryAlert({
                    'title': '成绩',
                    'content': '本次得分为:' + num + '分',
                    'modal': true,
                    'width': 200,
                    'isModalClose': true,
                    'buttons': {
                        '确定': function () {
                            M.dialog2.close();
                            window.location.href = 'examList.html';
                        }
                    }
                });
            });
        }
    });
    // 监听按钮变化
    $(document).on('change','.sign',function (e) {
        var num = Number($(this).attr('data-topicId')),score = 0,ans ='';
        if (from == 0) {
            num = curlP;
        }
        if ($(this).attr('type') == 'radio') {
            TheChoose[num] = ans = $(this).val();
            $('#menu li ').eq(Number($(this).attr('data-ExamId'))).css('background','#88bbd6');
            if (TheChoose[num] == tureAns[num]) {
                theScore[num] = Number($(this).attr('data-score'));
            }
        } else {
            // 统计多选题
            $('#menu li ').eq(Number($(this).attr('data-ExamId'))).css('background','#88bbd6');
            var name = $(this).attr('name'),str ='';
            $('[name='+name+']:checked').each(function () {
                str += $(this).val();
                // score = Number($(this).attr('score'));
            });
            TheChoose[num] = ans = str;
            if (TheChoose[num] == tureAns[num]) {
                theScore[num] = Number($(this).attr('data-score'));
            }
        }
        //console.log(TheChoose[nowP]);
        // 处理练习题
        if (from == 0) {
            if (ans == examData[curlP].answer) {
                $('#anMsg').html('恭喜你:<span>答对了!</span>答案为:<span>'+ans+'</span>');
            } else {
                $('#anMsg').html('答错了.正确答案为:<span>'+examData[curlP].answer+'</span>');
                $('#anMsg span').css('color','#db7d77');
            }
        }
    });
    // 获取数据
    $.get(url,function (data){
        // 时间框
        ///////////////////
        if (from == 0) {
            $('#timeTitle').html('正在顺序练习');
            //
            if (data[1] == 'undefined' || data[1] == '!') {
                alert('登录已失效,或账号已在其他设备登录');
                $('#log').click();
            }
            //
            examData = data;

            var type = 0;
            if (data[0].typeId == 1) {
                type = 0;
                showExam(data[0],0,type,0);
            } else if (data[0].typeId == 2) {
                type = 1;
                showExam(data[0],0,type,0);
            } else if (data[0].typeId == 3) {
                type = 2;
                showExam(data[0],0,type,0);
            }
            // else {
            //     LinkCase(data[1][0],0,0);
            // }
        } else if (from == 1){ // 考试模块
            // 载入小区块
            loadMenu(data);
            // 获取所有题目答案
            getAns(data);
            setInterval(function () {
                time = time + 1;
                $('#time').html(getTime(time));
            },1000);
            ////////
            examData = data;
            // console.log(data[1]);
            if (data[1] == 'undefined' || data[1] == '!') {
                alert('登录已失效,或账号已在其他设备登录');
                $('#log').click();
            }
            if (data[0] != undefined) {
                showExam(data[0][0],0,0,data[4]);
            } else if (data[1] != undefined) {
                showExam(data[1][0],0,1,data[5]);
            } else if (data[2] != undefined) {
                showExam(data[2][0],0,2,data[6]);
            } else if (data[3] != undefined) {
                LinkCase(data[3][0],0,data[7]);
            }
        }
        if (from == 1) {
            $('.dif').css('display','none');
        }
    });
    /*
    * *******自定义方法
    * */
    //获得url数据
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return decodeURIComponent(r[2]);
        return null;
    }
    // 显示试题
    function showExam(data,index,type,score){
        var theType = '';
        if (type == 0 ){
            theType = 'radio';
            $('#itemType').html('单选题');
        } else if (type == 1){
            theType = 'checkbox';
            $('#itemType').html('多选题');
        } else if (type == 2) {
            theType = 'radio';
            $('#itemType').html('判断题');
        } else if (type == 3) {
            $('#itemType').html('简答题');
            score = score / data.list.length;
        }
        $('#itemTitle').html((index + 1)+'. '+data.title);
        $('#itemTitle').css('background','#fff');
        $('#minItem').html('');
        $('#anMsg').html('');
        // 加载选项
        // 确定选项
        var theOP = [];
        if (TheChoose[index] != undefined) {
            for (var i = 0; i < TheChoose[index].length; i++) {
                theOP.push(TheChoose[index][i]);
            }
        }
        var op = '';
        for (var j =0;j < option.length; j++) {
            var sx = 'an'+option[j];
            if (!data[sx]){
                break;
            } else {
                if (TheChoose[index] != undefined) {
                    if (theOP.indexOf(option[j]) > -1) {
                        op += '<li><div class="check"><input name="'+data.id+'" value="'+option[j]+'" type="'+theType+'" data-score = "'+score+'" class="sign" checked data-topicId="'+index+'" data-ExamId="'+index+'"></div><div class="theOption" >'+option[j]+'.'+data[sx]+'</div> </li>';
                    } else {
                        op += '<li><div class="check"><input name="'+data.id+'" value="'+option[j]+'" type="'+theType+'" data-score = "'+score+'" class="sign" data-topicId="'+index+'" data-ExamId="'+index+'"></div><div class="theOption" >'+option[j]+'.'+data[sx]+'</div> </li>';
                    }
                } else {
                    op += '<li><div class="check"><input name="'+data.id+'" value="'+option[j]+'" type="'+theType+'" data-score = "'+score+'" class="sign" data-topicId="'+index+'" data-ExamId="'+index+'"></div><div class="theOption" >'+option[j]+'.'+data[sx]+'</div> </li>';
                }
                // 载入
            }
        }
        $('#option').html(op);
        //
        if (from == 0) {
            if (TheChoose[index] == examData[index].answer) {
                $('#anMsg').html('恭喜你:<span>答对了!</span>答案为:<span>'+TheChoose[index]+'</span>');
            } else if (TheChoose[index] != undefined){
                $('#anMsg').html('答错了.正确答案为:<span>'+examData[index].answer+'</span>');
                $('#anMsg span').css('color','#db7d77');
            }
        } else {
            if (TheChoose[index] == undefined){
                $('#menu li ').eq(index).css('background','#dddddd');
            }
            $('#menu li ').eq(index).css('border','#f60 1px solid');
            changeLeftBox();
        }
    }
    // 载入简答题区块
    function LinkCase(data,index,score) {
        var demo = '<div><div class="minTitle">{{minTitle}}</div><div class="optionBox"><ul>{{option}}</ul></div> </div>';
        $('#itemType').html('简答题');
        score = score / data.list.length;
        $('#itemTitle').html((index + 1)+'. '+data.jsCase.content);
        $('#itemTitle').css('background','#ccc');
        $('#option').html('');
        var str = '';
        // 确定选项
        for (var i = 0; i < data.list.length; i++) {
            var theType = '';
            if (data.list[i].answer.length == 1) {
                theType = 'radio';
            } else {
                theType = 'checkbox';
            }
            var theOP = [];
            // 确定简答题题目标识
            var L = theCase.indexOf(index);
            var lt = 0;
            for (var n = 0; n < L; n++) {
                lt += exam[theCase[n]].list.length;
            }
            lt += theCase[0];
            if (TheChoose[lt + i] != undefined) {
                for (var x = 0; x < TheChoose[lt].length; x++) {
                    theOP.push(TheChoose[lt + i][x]);
                }
            }
            var op = '';
            // 选项确定
            for (var j = 0;j < option.length; j++) {
                var sx = 'an'+ option[j];
                if (!data.list[i][sx]){
                    break;
                } else {
                    if (TheChoose[lt + i] != undefined) {
                        if (theOP.indexOf(option[j]) > -1) {
                            op += '<li><div class="check"><input name="'+data.list[i].id+'" value="'+option[j]+'" type="'+theType+'" data-score = "'+score+'" class="sign" checked data-topicId="'+(lt+i)+'" data-ExamId="'+index+'"></div><div class="theOption" >'+option[j]+'.'+data.list[i][sx]+'</div> </li>';
                        } else {
                            op += '<li><div class="check"><input name="'+data.list[i].id+'" value="'+option[j]+'" type="'+theType+'" data-score = "'+score+'" class="sign" data-topicId="'+ (lt+i)+'" data-ExamId="'+index+'"></div><div class="theOption" >'+option[j]+'.'+data.list[i][sx]+'</div> </li>';
                        }
                    } else {
                        op += '<li><div class="check"><input name="'+data.list[i].id+'" value="'+option[j]+'" type="'+theType+'" data-score = "'+score+'" class="sign" data-topicId="'+(lt+i)+'" data-ExamId="'+index+'"></div><div class="theOption" >'+option[j]+'.'+data.list[i][sx]+'</div> </li>';
                    }
                    // 载入
                }
            } // 选项判断结束
            var ls = demo.replace(/\{\{minTitle\}\}/g,(i+1)+'. '+data.list[i].content).replace(/\{\{option\}\}/g,op);
            str += ls;
        }
        $('#minItem').html(str);
        // 总for 循环结束
        // 确定多选区块是否已做
        for (var i = 0; i < data.list.length; i ++) {
           if (TheChoose[index + i] != undefined) {
               break;
           } else if (i == data.list.length -1) {
               $('#menu li ').eq(index).css('background','#dddddd');
           }
        }
        $('#menu li ').eq(index).css('border','#f60 1px solid');
        changeLeftBox();
    }
    // 显示题目逻辑
    function show(nowP) {
        if (exam[nowP].typeId != undefined) {
            var type = 0, score =0;
            if (exam[nowP].typeId == 1) {
                type = 0;
                score = examData[4];
            } else if (exam[nowP].typeId == 2) {
                type = 1;
                score = examData[5];
            } else if (exam[nowP].typeId == 3) {
                type = 2;
                score = examData[6];
            }
            showExam(exam[nowP],nowP,type, score);
        } else if (exam[nowP].list != undefined) {
            LinkCase(exam[nowP],nowP,examData[7]);
        }
    }
    // 载入小区块
    function loadMenu(data) {
        var len = 0;
        if (data[0] != undefined) {
            len += data[0].length;
        }
        if (data[1] != undefined) {
            len += data[1].length;
        }
        if (data[2] != undefined) {
            len += data[2].length;
        }
        if (data[3] != undefined) {
            len += data[3].length;
        }
        var str = '';
        for (var i =0; i< len;i++) {
            str += '<li data-id="' + i + '">' + (i + 1) + '</li>';
        }
        $('#menu').html(str);
    }
    // 时间
    function getTime(time) {
        if (time < 10){
            return '00:0'+time;
        } else if (9 < time && time < 60) {
            return '00:'+ time;
        } else if ( 59 < time && time < 60*60) {
            var miu ,sec;
            miu = parseInt(time/60);
            sec = time - miu*60;
            if ( 0 < miu && miu <10) {
                miu = 0+''+miu;
            }
            if (0 < sec && sec < 10){
                sec = 0+''+sec;
            }
            return miu +":"+ sec;
        } else {
            return '超时';
        }
    }
    // 获得所有试题和答案
    function getAns(data) {
        // 单选题
        if (data[0] != undefined) {
            for (var i = 0 ; i < data[0].length; i++) {
                exam.push(data[0][i]);
                tureAns.push(data[0][i].answer);
            }
        }
        // 多选题
        if (data[1] != undefined) {
            for (var i = 0 ; i < data[1].length; i++) {
                exam.push(data[1][i]);
                tureAns.push(data[1][i].answer);
            }
        }
        // 判断题
        if (data[2] != undefined) {
            for (var i = 0 ; i < data[2].length; i++) {
                exam.push(data[2][i]);
                tureAns.push(data[2][i].answer);
            }
        }
        // 简答题
        if (data[3] != undefined) {
            for (var i = 0 ; i < data[3].length; i++) {
                exam.push(data[3][i]);
                theCase.push(exam.length - 1);
                for (var j = 0; j < data[3][i].list.length; j++) {
                    tureAns.push(data[3][i].list[j].answer);
                }
            }
        }
        // the end------
    }
    //// 退出登录
    function logOut() {
        $.get('/SSMDemo/index/logout.action',function (data) {
            window.location.href = '/SSMDemo/index/first.action';
        });
    }
    // 改变左边区块的成绩
    function changeLeftBox() {
        var height = $('#rightBox').height();
        if (height > $('#menu').height()) {
            $('#leftBox').height(height);
        }
    }
})($);
