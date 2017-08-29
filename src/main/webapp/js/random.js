/**
 * Created by Admin on 2017/8/9.
 */
var caseques = '';
(function ($) {
    var data,
        name,total,passScore,selectOneNum,selectMoreNum,selectJudgeNum,selectOneScore,selectMoreScore,caseScore,selectJudgeScore,submit;
    $('#submit').click(function () {
        name = $('#name').val().replace(/\s/g,'');
        // total  = $('#total').val().replace(/\s/,'');
        passScore = $('#passScore').val().replace(/\s/g,'');
        selectOneNum = $('#selectOneNum').val().replace(/\s/g,'');
        selectMoreNum = $('#selectMoreNum').val().replace(/\s/g,'');
        selectJudgeNum = $('#selectJudgeNum').val().replace(/\s/g,'');
        selectOneScore = $('#selectOneScore').val().replace(/\s/g,'');
        selectMoreScore = $('#selectMoreScore').val().replace(/\s/g,'');
        selectJudgeScore = $('#selectJudgeScore').val().replace(/\s/g,'');
        if (name.length === 0) {
            alert('请输入试卷名称');
        } else if (!checkRate(passScore)) {
            alert('及格线需要为纯数字且为整数');
        } else if (!checkRate(selectOneNum)) {
            alert('单选题数量需要为纯数字且为整数');
        } else if (!checkRate(selectMoreNum)) {
            alert('多选题数量需要为纯数字且为整数');
        } else if (!checkRate(selectJudgeNum)) {
            alert('判断题数量需要为纯数字且为整数');
        } else if (!checkRate(selectOneScore)) {
            alert('单选题分数需要为纯数字且为整数');
        } else if (!checkRate(selectMoreScore)) {
            alert('多选题分数需要为纯数字且为整数');
        } else if (!checkRate(selectJudgeScore)) {
            alert('判断题分数需要为纯数字且为整数');
        } else if (hasCase()){
            alert('简答题分数需要为纯数字且为整数');
        }else if (selectOneNum*selectOneScore + selectJudgeNum*selectJudgeScore + selectMoreScore*selectMoreNum + allCaseScore() != 100) {
            alert(selectOneNum*selectOneScore + selectJudgeNum*selectJudgeScore + selectMoreScore*selectMoreNum + allCaseScore());
            alert('请确保试题总分为100分');
        }else{ // 格式均正确，发送数据到服务端
            // 获取多选题
            if (caseques != '') {
                casequesNum = Number($('#caseScore').val().replace(/\s/g,''));
                data = {
                    name: name, total: total, passScore: passScore,
                    selectOneNum: selectOneNum, selectMoreNum: selectMoreNum,
                    selectJudgeNum: selectJudgeNum, selectOneScore: selectOneScore, selectMoreScore: selectMoreScore,
                    selectJudgeScore: selectJudgeScore,caseques:caseques,casequesNum:casequesNum,
                    reserveFive: $('#firstSelect').val(),reserveSix: $('#secondSelect').val()
                };
            } else {
                data = {
                    name: name, total: total, passScore: passScore,
                    selectOneNum: selectOneNum, selectMoreNum: selectMoreNum,
                    selectJudgeNum: selectJudgeNum, selectOneScore: selectOneScore, selectMoreScore: selectMoreScore,
                    selectJudgeScore: selectJudgeScore,
                    reserveFive: $('#firstSelect').val(),reserveSix: $('#secondSelect').val()
                };
            }
            data = JSON.stringify(data);
            $.ajax({
                url: '/SSMDemo/exam/addExam.action',
                contentType: "application/json ;charset=utf-8",
                type: 'POST',
                crossDomain: true,
                dataType: 'json',
                data: data,
                success: function () {
                    alert("提交成功");
                    window.location.reload(true);
                },
                error: function (msg) {
                    alert('请求错误:，请稍后重试');
                }
            });
        }
    });
    // 在父页面打开
    $('#chooseCase').click(function () {
        window.parent.chooseCase();
    });
    // 获得数据
    $.get('/SSMDemo/level/selOne.action', function (data, status) {
        if (status == 'success') {
            var op = '';
            for (var i = 0; i < data.length; i++) {
                id = data[0].id;
                op += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
            }
            $('#firstSelect').html(op);
            addSecond(id);
        } else {
            alert('发生错误，请稍后重试.');
        }

    });
    // 监听变化
    $(document).on('change','#firstSelect',function () {
        id = Number($('#firstSelect').val());
        addSecond(id);
    })
    /*
    * *****function
    * */
    // 自定义方法
    function checkRate(number) {
        var re = /^[0-9]+.?[0-9]*$/; //判断字符串是否为数字 //判断正整数 /^[1-9]+[0-9]*]*$/
        if (!re.test(number)) {
            return false;
        } else {
            if (number%1 === 0) {
                return true;
            }
            return false;
        }
    }
    // 判断是否需要简答题
    function hasCase() {
        if (caseques == '') {
            return false;
        } else {
            caseScore = $('#caseScore').val().replace(/\s/g,'');
            if (checkRate(caseScore)) {
                return false;
            } else {
                return true;
            }
        }
    }
    // function 获得简答题分数
    function allCaseScore() {
        if (caseques == ''){
            return 0;
        } else {
            var l = caseques.split(',').length;
            caseScore = $('#caseScore').val().replace(/\s/g,'');
            // 返回总分数
            return Number(l*caseScore);
        }
    }
    /////
    function addSecond(id) {
        $.get('/SSMDemo/level/selTwo.action?id=' + id, function (data, status) {
            if (status == 'success') { // 成功了
                op = '';
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    op += '<option value="' + data[i].id + '" data-id="' + data[i].id + '">' + data[i].name + '</option>';
                }
                $('#secondSelect').html(op);
            } else {
                alert('发生错误');
            }
        });
    }
})($);
function getCase(str,st1) {
    caseques = str;
    $('#theChoose').text('已选择：'+st1);
}
