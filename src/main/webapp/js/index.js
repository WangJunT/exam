/**
 * Created by Admin on 2017/8/9.
 */
(function ($) {
    var login = false,code = 0;
    if (!login) {
        $('#user').css('display','none');
        $('#log').html('登录');
    }
    // 登录或退出
    $('#log').click(function () {
        if (!login) {
            $('#wall').remove();
            var wall = '<div class="wall" id="wall"><div class="theLoginBox"><div class="title">登录<a href="javascript:void(0)" class="close" id="close">+</a> </div><form class="formBox"> <div class="inputBox">' +
                '<div class="leftIcon"><i class="fa fa-mobile" aria-hidden="true"></i></div><input type="text" class="theInput" placeholder="请输入电话号码" id="phoneNmber">'+'</div> <div class="inputBox">' +
                '<div class="leftIcon"><i class="fa fa-lock" aria-hidden="true"></i></div><input type="text" class="theInput" placeholder="请输入验证码" id="yzm">'+'</div><div class="nextAutoBox"><input type="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;下次自动登录<a href="javascript:void(0)" class="getYzm" id="getCode">获取验证码</a> </div> <input type="button" class="submitBox" id="submit" value="登录"></form></div></div>';

            $('body').append(wall);
        } else { //退出登录

        }
    });
    // 取消登录
    $(document).on('click','#close', function () {
        $('#wall').remove();
    });
    // 确认登录
    $(document).on('click','#submit', function () {
        var phone = $('#phoneNmber').val().replace(/\s/,'');
        var yzm = $('#yzm').val().replace(/\s/,'');
        if (phone.length === 0 || yzm.length === 0) {
            alert('电话号码或者验证码不能为空');
        } else {
            Submit(phone,yzm);
        }
    });
    // 获取验证码
    $(document).on('click','#getCode', function () {
        if (code === 0) {
            var phone = $('#phoneNmber').val().replace(/\s/,'');
            if (phone.length === 0 ) {
                alert('电话号码不能为空');
            } else {
                if (/^1[34578]\d{9}$/.test(phone)) { // 号码格式正确
                    // 请求验证码
                    getTheCode(phone);
                    code = 60;
                    $(this).html('60s后重新获取');
                    var t = setInterval(function () {
                        code -- ;
                        $('#getCode').html(code+'s后重新获取');
                        if (code === 0) {
                            $('#getCode').html('获取验证码');
                            clearInterval(t);
                        }
                    },1000);
                } else { // 号码格式错误
                    alert('请输入正确电话号码格式');
                }
            }
        }
    });
    // 自定义方法
    function  getTheCode(phone) {
        var url = 'http://192.168.1.120:8080/SSMDemo/login/doLogin.action'+'?phone=' + phone;
        $.get(url ,function () {
            console.log('获取验证码成功');
        });
    }
    // 提交数据
    function Submit(phone, yzm) {
        var data = {phoneNumber: phone, code: yzm};
        data = JSON.stringify(data);
        $.ajax({
            url: '',
            contentType : "application/json ; charset=utf-8",
            data: data,
            success: function (data) {

            }
        });
    }
})($);
