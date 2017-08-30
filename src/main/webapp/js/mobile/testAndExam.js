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
    var position = 1,TheChoose = [],theCase = [],theScore = [];//记录用户选项
    var start = 0, length = 10,beginStart = 0,curlP = 0,time = 0, topicId = 0,nowP = 0;
    var trueAns = 0,falseAns = 0;// 搜集正确个数
    var lastPosition = 0;
    var M ={};// 用于弹窗应用
    /// 确认url
    from = getQueryString('type');
    examId= getQueryString('id');
    if (from == 0) {// 练习
        var d =  new Date();
        url = '/SSMDemo/question/selStuQues.action?t='+d.getTime().toString();
    } else {
        var d =  new Date();
        $('#handIn').text('结束考试');
        url = '/SSMDemo/exam/beginExam.action?id='+ examId+'&t='+d.getTime().toString();
    }
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
                nowP -= 1;
                show(nowP);
            }
        }
    });
    // 点击交卷
    $('#handIn').click(function () {
        if (from == 0){
            var rt = trueAns/(trueAns + falseAns);
            var data = {start: trueAns + falseAns,rate:rt.toFixed(2),time: time,num : lastPosition};
            data = JSON.stringify(data);
            // console.log(data);
            $.ajax({
                url: '/SSMDemo/question/quitPractice.action',
                contentType: "application/json ;charset=utf-8",
                type: 'POST',
                crossDomain: true,
                dataType: 'json',
                data: data,
                success: function () {
                    alert('本次做题数为:'+(trueAns + falseAns));
                    window.location.href = 'exam.html';
                },
                error: function (msg) {
                    alert('请求错误,稍后重试');
                }
            });
        } else { // 考试提交
            var num = 0;
            var finish = 0 ;
            // ........
            for (var i = 0; i < theScore.length; i++) {
                if (theScore[i] != undefined) {
                    num += Number(theScore[i]);
                    finish += 1;
                }
            }
            // 提交数据
            $.get('/SSMDemo/sexam/sorup.action?exampaperId=' + Number(examId) + '&score=' + num, function (data) {
                // 跳转到成绩分析
                window.location.href = 'examResult.html?finish=' + finish + '&all=' + tureAns.length+'&score='+num;
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
        // 处理练习题
        if (from == 0) {
            var name =  $(this).attr('name');
            if ($(this).attr('type') == 'radio') { // 单选题
                $('input[name = ' + name + ']').attr('disabled','true');
                var p = Number($(this).attr('data-examid'));
                // 确认最后完成题目位置
                if (p > lastPosition) {
                    lastPosition = p;
                }
                if (ans == examData[curlP].answer) {
                    trueAns += 1;
                    $('#anMsg').html('恭喜你:<span>答对了!</span>答案为:<span>'+ans+'</span>');
                } else {
                    falseAns += 1;
                    $('#anMsg').html('答错了.正确答案为:<span>'+examData[curlP].answer+'</span>');
                    $('#anMsg span').css('color','#db7d77');
                }
                if (examData[curlP].reserveOne != null) {
                    $('#analyBox').css('display','block');
                    $('#theAnaly').html(examData[curlP].reserveOne);
                }
            } else { // 多选题

            }
        }
    });
    // 多选题确认
    $('#showAns').click(function () {
        var index = $(this).attr('data-index');
        var name =  $(this).attr('data-id');
        $(this).attr('display','none');
        if (from == 0) { // 顺序练习
            var p = Number($('input[name = ' + name + ']').attr('data-examid'));
            // 确认最后完成题目位置
            if (p > lastPosition) {
                lastPosition = p;
            }
            $('input[name = ' + name + ']').attr('disabled','true');
            if (TheChoose[index] == examData[index].answer) {
                trueAns += 1;
                $('#anMsg').html('恭喜你:<span>答对了!</span>答案为:<span>'+TheChoose[index]+'</span>');
            } else {
                falseAns += 1;
                $('#anMsg').html('答错了.正确答案为:<span>'+examData[index].answer+'</span>');
                $('#anMsg span').css('color','#db7d77');
            }
            if (examData[index].reserveOne != null) {
                $('#analyBox').css('display','block');
                $('#theAnaly').html(examData[index].reserveOne);
            }
        }
    });
    // 获取数据
    $.get(url,function (data){
        // 时间框
        ///////////////////
        if (from == 0) {
            //统计时间
            setInterval(function () {
                time = time + 1;
            },1000);
            /////////////////////////
            if (data[1] == 'undefined' || data[1] == '!') {
                alert('登录已失效,或账号已在其他设备登录');
                $('#log').click();
            }
            //
            var start = data[0];
            examData = data[1];
            if (start <= data[1].length)
                curlP = start;
            else
                curlP = data[1].length;
            var type = 0;
            if (data[1][start].typeId == 1) {
                type = 0;
                showExam(data[1][start],start,type,0);
            } else if (data[1][start].typeId == 2) {
                type = 1;
                showExam(data[1][start],start,type,0);
            } else if (data[1][start].typeId == 3) {
                type = 2;
                showExam(data[1][start],start,type,0);
            }
            // else {
            //     LinkCase(data[1][0],0,0);
            // }
        } else if (from == 1){ // 考试模块
            // 载入小区块
            // loadMenu(data);
            // 获取所有题目答案
            getAns(data);
            ////////
            examData = data;
            // console.log(data[1]);
            if (data[1] == 'undefined' || data[1] == '!') {
                alert('登录已失效,或账号已在其他设备登录');
                window.location.href='mobileIndex.html';
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
    * *********自定义方法***********************
    * **********
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
        $('#showAnsBox').css('display','none');
        if (type == 0 ){
            theType = 'radio';
            $('#itemType').html('单选题');
        } else if (type == 1){
            theType = 'checkbox';
            $('#itemType').html('多选题');
            if (from == 0) {
                $('#showAnsBox').css('display','block');
                $('#showAns').attr({'data-id' : data.id, 'data-index' : index});
            }
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
        $('#analyBox').css('display','none');
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
                        op += '<li><div class="check"><input name="' + data.id + '" value="' + option[j] + '" type="'+ theType+'" data-score = "'+score+'" class="sign" checked data-topicId="'+index+'" data-ExamId="'+index+'"></div><div class="theOption" >'+option[j]+'.'+data[sx]+'</div> </li>';
                    } else {
                        op += '<li><div class="check"><input name="' + data.id + '" value="' + option[j] + '" type="'+ theType+'" data-score = "'+score+'" class="sign" data-topicId="'+index+'" data-ExamId="'+index+'"></div><div class="theOption" >'+option[j]+'.'+data[sx]+'</div> </li>';
                    }
                } else {
                    op += '<li><div class="check"><input name="'+ data.id + '" value="' + option[j]+'" type="'+ theType+'" data-score = "'+score+'" class="sign" data-topicId="'+index+'" data-ExamId="'+index+'"></div><div class="theOption" >'+option[j]+'.'+data[sx]+'</div> </li>';
                }
                // 载入
            }
        }
        $('#option').html(op);
        //
        if (from == 0) {
            if (TheChoose[index] == examData[index].answer) {
                // 包含解析就解析
                if (examData[index].reserveOne != null) {
                    $('#analyBox').css('display','block');
                    $('#theAnaly').html(examData[index].reserveOne);
                }
                // 按钮不显示
                $('#showAnsBox').css('display','none');
                $('input[name = ' + data.id + ']').attr('disabled','true');
                $('#anMsg').html('恭喜你:<span>答对了!</span>答案为:<span>'+ TheChoose[index] + '</span>');
            } else if (TheChoose[index] != undefined){
                // 包含解析就解析
                if (examData[index].reserveOne != null) {
                    $('#analyBox').css('display','block');
                    $('#theAnaly').html(examData[index].reserveOne);
                }
                // 按钮不显示
                $('#showAnsBox').css('display','none');
                $('input[name = ' + data.id + ']').attr('disabled','true');
                $('#anMsg').html('答错了.正确答案为:<span>' + examData[index].answer + '</span>');
                $('#anMsg span').css('color','#db7d77');
            }
        } else {
            if (TheChoose[index] == undefined){
                $('#menu li ').eq(index).css('background','#dddddd');
            }
            $('#menu li ').eq(index).css('border','#f60 1px solid');
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
})($);
