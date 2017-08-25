/**
 * Created by Admin on 2017/8/21.
 */
(function ($) {
    var ls = sessionStorage.getItem('isLoad');
    if (ls == null || ls == undefined) {
        widndow.location.href = 'mobileIndex.html';
    }
    $('#submit').click(function () {
        var phone = $('#phoneNumber').val(),pwd = $('#newPassword').val(),
            pwd1 = $('#passwordAgain').val();
        phone = phone.replace(/\s/g,'');
        pwd = pwd.replace(/\s/,'');
        pwd1 = pwd1.replace(/\s/,'');
        if (phone.length == 0) {
            $('#msg').html('电话号码不能为空');
        } else if( pwd.length == 0){
            $('#msg').html('请输入密码');
        } else if (pwd1.length == 0) {
            $('#msg').html('请输入确认密码');
        } else if (!/^1[34578]\d{9}$/.test(phone)) {
            $('#msg').html('请输入正确手机号码');
        }else if (pwd.length > 18){
            $('#msg').html('请控制密码长度在18个字符内.');
        }else if (!isLegal(pwd)) {
            $('#msg').html('密码仅允许为数字和英文字符');
        } else if (pwd1 != pwd) {
            $('#msg').html('两次输入密码不一致');
        } else { // 提交
            $(this).attr('disabled','true');
            $(this).val('提交中...');
            var data = {phone: phone,password:pwd};
            data = JSON.stringify(data);
            $.ajax({
                url:'/SSMDemo/stu/change.action',
                type:'post',
                contentType: "application/json;charset=utf-8",
                data: data,
                crossDomain: true,
                dataType: 'JSON',
                success: function (data) {
                    if (data[2] != undefined) {
                        $('#msg').html('非当前用户手机号。');
                        $('#submit').removeAttr('disabled').val('提交');
                    } else {
                        alert('修改成功，请重新登陆.');
                        $.get('/SSMDemo/index/logout.action',function (data,status,xhr) {
                            if (status == 'success'){
                                sessionStorage.removeItem('isLoad');
                                window.location.href ='personSet.html';
                            } else {
                                $('#msg').html('发生错误.');
                            }
                        });
                    }
                },
                error: function(data) {
                    $('#msg').html('发生错误，状态码:'+data.status);
                    $('#submit').removeAttr('disabled').val('提交');
                }
            });
        }
    });
    /*
     * *****自定义方法
     * */
    function isLegal(str) {
        var p = /[a-z,A-Z,0-9]/;
        for (var i = 0; i < str.length; i++) {
            if (p.test(str[i])){

            } else {
                return false;
            }
        }
        return true;
    }
})($);
