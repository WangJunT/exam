/**
 * Created by Admin on 2017/8/9.
 */
(function ($) {
    var data,
        name,total,passScore,selectOneNum,selectMoreNum,selectJudgeNum,selectOneScore,selectMoreScore,selectJudgeScore,submit;
    $('#submit').click(function () {
        name = $('#name').val().replace(/\s/,'');
        total  = $('#total').val().replace(/\s/,'');
        passScore = $('#passScore').val().replace(/\s/,'');
        selectOneNum = $('#selectOneNum').val().replace(/\s/,'');
        selectMoreNum = $('#selectMoreNum').val().replace(/\s/,'');
        selectJudgeNum = $('#selectJudgeNum').val().replace(/\s/,'');
        selectOneScore = $('#selectOneScore').val().replace(/\s/,'');
        selectMoreScore = $('#selectMoreScore').val().replace(/\s/,'');
        selectJudgeScore = $('#selectJudgeScore').val().replace(/\s/,'');
        if (name.length === 0) {
            alert('请输入试卷名称');
        } else if (!checkRate(total)) {
            alert('总分因为纯数字');
        } else if (!checkRate(passScore)) {
            alert('及格线需要为纯数字');
        } else if (!checkRate(selectOneNum)) {
            alert('单选题数量需要为纯数字');
        } else if (!checkRate(selectMoreNum)) {
            alert('多选题数量需要为纯数字');
        } else if (!checkRate(selectJudgeNum)) {
            alert('判断题数量需要为纯数字');
        } else if (!checkRate(selectOneScore)) {
            alert('单选题分数需要为纯数字');
        } else if (!checkRate(selectMoreScore)) {
            alert('多选题分数需要为纯数字');
        } else if (!checkRate(selectJudgeScore)) {
            alert('判断题分数需要为纯数字');
        } else { // 格式均正确，发送数据到服务端
            data = {
                name: name, total: total, passScore: passScore,
                selectOneNum: selectOneNum, selectMoreNum: selectMoreNum,
                selectJudgeNum: selectJudgeNum, selectOneScore: selectOneScore, selectMoreScore: selectMoreScore,
                selectJudgeScore: selectJudgeScore
            };
            data = JSON.stringify(data);
            $.ajax({
                url: 'http://192.168.1.120:8080/SSMDemo/exam/addExam.action',
                contentType: "application/json ;charset=utf-8",
                type: 'POST',
                crossDomain: true,
                dataType: 'json',
                data: data,
                success: function () {
                    console.log("请求成功");
                },
                error: function (msg) {
                    alert('请求错误: ' + msg.status);
                }
            });
        }
    });
    // 自定义方法
    function checkRate(number) {
        var re = /^[0-9]+.?[0-9]*$/; //判断字符串是否为数字 //判断正整数 /^[1-9]+[0-9]*]*$/
        if (!re.test(number)) {
            return false;
        } else {
            return true;
        }
    }
})($);