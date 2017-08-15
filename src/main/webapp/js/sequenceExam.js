/**
 * Created by Admin on 2017/8/10.
 */
(function ($,window) {
    var tureAns = [],exam=[],type = 'radio',option=['A','B','C','D','E','F','G'],from,examId,url,examData;
    var position = 1,TheChoose = [];//记录用户选项
    var start = 0, length = 10;
    var model = '<div class="examItem"><div class="itemTitle">{{item}}，{{title}} <br><a href="javascript:void(0)" id="showAns" data-itemId="{{index}}" data-id="{{id}}" typeId="{{type}}"class="dif">查看答案</a></div> <ul>{{option}}</ul></div>';
    //判断是否登录
    var ls = opCookie.get('isLoad');
    if (ls == 'undefined') { //未登录不可访问
        window.location.href = '/SSMDemo/index/first.action';
    }
    window.history.forward(1);
    $('#user').html(opCookie.get('loader'));
    // 解析url
    from = getQueryString('type');
    examId= getQueryString('id');
    if (from == 0) {// 练习
        url = '/SSMDemo/question/selectLimit.action?start='+start+'&size='+length;
    } else {
        url = '/SSMDemo/exam/beginExam.action?id='+ examId;
    }
    window.history.forward(1);
    if(from == 0) {
        $('#title').html('顺序练习');
    } else {
        $('#title').html('模拟考试');
    }
    // 导航栏点击
    $('#navBox a').click(function () {
        var navId = $(this).attr('id');
        if (from == 0) {
            var dia = new Dialog({
                title: '提示',
                content: '正在练习中，是否退出?',
                width: 250,
                height: 160,
                yes: function () {
                    skip(navId);
                    this.remove();
                },
                No: function () {
                    this.remove();
                }
            });
        } else {
            var dia = new Dialog({
                title: '提示',
                content: '正在考试中，是否退出?',
                width: 250,
                height: 160,
                yes: function () {
                    skip(navId);
                    dia.remove();
                },
                No: function () {
                    dia.remove();
                }
            });
        }
    });
    // 获得数据
    $.get(url,function (data){
        examData = data;
        // console.log(data);
        if (from == 0) {
            sequence(data);
        } else if (from == 1){
            showExam(data);
        }
        if (from == 1) {
            $('.dif').css('display','none');
        }
    });
    // 答题模式显示答案
    $(document).on('click','#showAns',function (e) {
        var id = Number(e.target.getAttribute('data-itemId'));
        var examId = Number(e.target.getAttribute('data-id'));
        var type =e.target.getAttribute('typeId');
        var check = '';
        if (type === 'radio') {
            check= $('input[name='+examId+']:checked ').val();
        } else if (type === 'checkbox') {
            $('input:checkbox[name='+examId+']:checked').each(function() { //
                check += $(this).val();  // 每一个被选中项的值
            });
        }
        if (check === undefined || check === '') {
            e.target.innerHTML= '请做题后再查看答案' ;
            (function (e) {
                setTimeout(function () {
                    e.target.innerHTML= '查看答案' ;
                },1400);
            })(e);
        } else {
            e.target.innerHTML= '正确答案：' + tureAns[id];
        }
    });
    // 退出登录
    $('#log').click(function () {
        opCookie.remove('isLoad');
        logOut();
        // window.location.href = '/SSMDemo/index/first.action';
    });
    // 下一页
    $(document).on('click','#next',function () {
        if (!isOver()) {
            alert('当前页有题目未完成!');
            return;
        }
        // console.log(TheChoose);
        start = start + length;
        exam = [];
        tureAns = [];
        url = '/SSMDemo/question/selectLimit.action?start='+start+'&size='+length;
        $.get(url,function (data){
            examData = data;
            sequence(data);
            $('#last').css('display','inline-block');
            document.body.scrollTop = 0;
        });
    });
    // 上一页
    $(document).on('click','#last',function () {
        position = position - 20;
        start = start - length;
        exam = [];
        tureAns = [];
        url = '/SSMDemo/question/selectLimit.action?start='+start+'&size='+length;
        $.get(url,function (data){
            examData = data;
            sequence(data);
            if (start === 0) {
                $('#last').css('display','none');
            } else {
                $('#last').css('display','inline-block');
            }
            document.body.scrollTop = 0;
        });
    });
    // 提交试卷
    $(document).on('click','#submitExam',function () {
        console.log(tureAns);
        console.log(examData);
         if (!isOver()) {
             var dia = new Dialog({
                 title: '提示',
                 content: '有题未完成，是否交卷?',
                 width: 250,
                 height: 160,
                 yes: function () {
                     //dia.remove();
                     dia.changeContent('正在提交分数...');
                     getResult(dia);
                     // alert('分数已提交,本次得分:'+getResult());
                     // window.location.href = 'examList.html';
                      //dia.content = '本次得分:'+getResult();
                 },
                 No: function () {
                     dia.remove();
                 }
             });
            // alert('请完成所以题目再交卷!');
         }else{
             var dia = new Dialog({
                 title: '提示',
                 content: '确认交卷?',
                 width: 250,
                 height: 160,
                 yes: function () {
                     dia.remove();
                     console.log(tureAns);
                     getResult(dia);
                     // alert('分数已提交,本次得分:'+getResult());
                     // window.location.href = 'examList.html';
                 },
                 No: function () {
                     dia.remove();
                 }
             });
         }
    });
    // 自定义方法
    //获得url数据
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return decodeURIComponent(r[2]);
        return null;
    }
    // 显示试题
    function showExam(data){
        //console.log(data);
        examData = [];
        var all ='';
        var ls = '';
        if (data[0] != undefined ) {
            ls ='';
            ls ='<div class="examType">单选题</div>';
            ls += linkExam(data[0] ,1,data[4]);
            examData = examData.concat(data[0]);
            all += ls;
        }
        if (data[1] != undefined) {
            ls = '';
            ls ='<div class="examType">多选题</div>';
            ls += linkExam(data[1] ,2,data[5]);
            examData = examData.concat(data[1]);
            all += ls;
        }
        if (data[2] != undefined) {
            ls ='';
            ls ='<div class="examType">判断题</div>';
            ls += linkExam(data[2] ,1,data[6]);
            examData = examData.concat(data[2]);
            all += ls;
        }
        if (data[3] != undefined) {
            ls = '';
            ls = '<div class="examType">简答题</div>';
            ls += linkCase(data[3],1,data[7]);
            for (var i =0; i < data[3].length; i++) {
                examData = examData.concat(data[3][i].list);
            }
            // examData = examData.concat(data[3]);
            all += ls;
        }
        all += '<div class="submitExam"><a href="javascript:void(0)" id="submitExam">交卷</a></div>';
        $('#allExam').html(all);
    }
    // 拼接当个试题
    function linkExam(data,type,score) {
        var theType,examItem = [];
        if (type == 1) {
            theType ='radio';
        } else if(type == 2) {
            theType = 'checkbox';
        }
        for (var i = 0; i < data.length; i++) {
            tureAns.push(data[i].answer);
            // 确定选项个数
            var op = '';
            for (var j =0;j < option.length; j++) {
                var sx = 'an'+option[j];
                if (!data[i][sx]){
                    break;
                } else {
                    op += '<li><div class="check"><input name="'+data[i].id+'" value="'+option[j]+'" type="'+theType+'" score = "'+score+'"></div><div class="theOption">'+option[j]+'.'+data[i][sx]+'</div> </li>';
                }
            }
            //console.log(op);
            var str = model.replace(/\{\{type\}\}/g,type).replace(/\{\{item\}\}/,position).replace(/\{\{index\}\}/,tureAns.length - 1).replace(/\{\{title\}\}/,data[i].title).replace(/\{\{id\}\}/g,data[i].id).replace(/\{\{option\}\}/g,op);
            position++;
            //return str;
            examItem.push(str);
             // tureAns.push(data[i].answer);
        }
        return examItem.join('');
    }
    // 拼接简答题
    function linkCase(data,type,score) {
        var theType, examItem = [];
        if (type == 1) {
            theType = 'radio';
        } else if (type == 2) {
            theType = 'checkbox';
        }
        for (var x = 0; x < data.length; x++){
            var str = '';
            for (var i = 0; i < data[x].list.length; i++) {
                tureAns.push(data[x].list[i].answer);
                if (data[x].list[i].answer.length > 1) {
                    theType = 'checkbox';
                    data[x].list[i].typeId = 2;
                } else {
                    data[x].list[i].typeId = 1;
                }
                // 确定选项个数
                var op = '';
                for (var j = 0; j < option.length; j++) {
                    var sx = 'an' + option[j];
                    if (!data[x].list[i][sx]) {
                        break;
                    } else {
                        var theScore =score / data[x].list.length;
                        theScore = theScore.toFixed(2); //取两位小数
                        op += '<li><div class="check"><input name="' + data[x].list[i].id + '" value="' + option[j] + '" type="' + theType + '" score="'+theScore+'"></div><div class="theOption">' + option[j] + '.' + data[x].list[i][sx] + '</div> </li>';
                    }
                }
                str += model.replace(/\{\{type\}\}/g, type).replace(/\{\{item\}\}/,i+1).replace(/\{\{index\}\}/,tureAns.length - 1).replace(/\{\{title\}\}/, data[x].list[i].content).replace(/\{\{id\}\}/g, data[x].list[i].id).replace(/\{\{option\}\}/g, op);
                //return str;
            }
            str = '<div class="examItem"><div class="caseTitle">'+position+','+data[x].jsCase.content+'</div> '+str+'</div>';
            examItem.push(str);
            position++;
        }
        return examItem.join('');
    }
    // 顺序练习
    function sequence(data) {
        var type_id = 1;
        for (var i = 0; i < data.length; i++) {
            if (type_id === 1) {
                type ='radio';
            } else if(type_id ===2) {
                type = 'checkbox';
            }
            // 确定选项个数
            var op = '';
            var checkId = TheChoose[position - 1];
            var checked = option.indexOf(checkId); // 获得已选中的选项
            for (var j =0;j < option.length; j++) {
                var sx = 'an'+option[j];
                if (!data[i][sx]){
                    break;
                } else {
                    if (checked == j){
                        op += '<li><div class="check"><input name="'+data[i].id+'" value="'+option[j]+'" type="'+type+'" checked></div><div class="theOption">'+option[j]+'.'+data[i][sx]+'</div> </li>';
                    } else {
                        op += '<li><div class="check"><input name="'+data[i].id+'" value="'+option[j]+'" type="'+type+'"></div><div class="theOption">'+option[j]+'.'+data[i][sx]+'</div> </li>';
                    }
                }
            }
            //console.log(op);
            var str = model.replace(/\{\{type\}\}/g,type).replace(/\{\{item\}\}/,position).replace(/\{\{index\}\}/,i).replace(/\{\{title\}\}/,data[i].title).replace(/\{\{id\}\}/g,data[i].id).replace(/\{\{option\}\}/g,op);
            position++;
            exam.push(str);
            tureAns.push(data[i].answer);
        }
        var all = exam.join('')+'<div class="seqbox"><a href="javascript:void(0)" id="last">上一页</a> <a href="javascript:void(0)">结束练习</a> <a href="javascript:void(0)" id="next">下一页</a></div>';
        $('#allExam').html(all);
        $('#last').css('display','none');
    }
    // 判断当前题目是否做完
    function isOver() {
        for (var i = 0; i < examData.length; i++) {
            var TYPEID = examData[i].typeId;
            if (TYPEID == 1 || TYPEID == 3){// 单选题目
                var choose = $('input[name=' + examData[i].id + ']:checked').val();
                if (choose == undefined || choose == null) { //有未做题目
                    return false;
                } else {
                    TheChoose[start*1 + i] = choose;
                }
            } else if (TYPEID == 2) { //多选题目
                var cstr = '';
                // console.log(examData[i].id);
                $('[name='+examData[i].id+']:checked').each(function () {
                    cstr += $(this).val();
                });
                if (cstr == '') {
                    return false;
                } else {
                    TheChoose[start*1 + i] = cstr;
                }
            }

        }
        return true;
    }
    // 获取分数
    function getResult(dialog) {
        var num = 0;
        TheChoose = [];
        for (var i =0; i < examData.length; i++) {
            var TYPE = examData[i].typeId;
            if (TYPE == 1 || TYPE == 3 ){
                var choose = $('input[name=' + examData[i].id + ']:checked').val();
                if (choose == undefined || choose == null) {// 题目未做
                    TheChoose.push(0);
                } else {
                    TheChoose.push(choose);
                    var score = Number($('input[name=' + examData[i].id + ']:checked').attr('score'));
                    if (choose == tureAns[TheChoose.length - 1]) { // 答题正确
                        num += score;
                    }
                    // TheChoose.push(choose);
                }
            } else { // 多选题
                var cstr = '';
                var score;
                // console.log(examData[i].id);
                $('[name='+examData[i].id+']:checked').each(function () {
                    cstr += $(this).val();
                    score = Number($(this).attr('score'));
                });
                if (cstr == '') {
                    TheChoose.push(0);
                } else {
                    TheChoose.push(cstr);
                    if (cstr == tureAns[TheChoose.length - 1]) { // 做对
                        num += score;
                    }
                }
            }
        }
        // 判断分数
        // for (var i = 0; i < TheChoose.length; i++) {
        //     if (TheChoose[i] == tureAns[i]){
        //         num += 1;
        //     }
        // }
        // return num;
        // alert('分数已提交,本次得分:'+getResult());
        // window.location.href = 'examList.html';
        $.get('/SSMDemo/sexam/sorup.action?exampaperId='+Number(examId)+'&score='+num,function (data) {
            dialog.remove();
            alert('分数已提交,本次得分:'+num);
            window.location.href = 'examList.html';
        });
    }
    // 确认跳转 
    function skip(id) {
        switch (id) {
             case 'toFirst':window.location.href = '/SSMDemo/index/first.action'; break;
        }
    }
    //// 退出登录
    function logOut() {
        $.get('/SSMDemo/index/logout.action',function (data) {
            window.location.href = '/SSMDemo/index/first.action';
        });
    }
})($,window);