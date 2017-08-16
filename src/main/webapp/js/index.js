/**
 * Created by Admin on 2017/8/9.
 */
(function ($) {
    var login = false,code = 0, how = 0;
    //var ls = opCookie.get('isLoad');
    ls = sessionStorage.getItem('isLoad');
    var ip = returnCitySN.cip;//获得ip
    if (ls == 'undefined'|| ls == null) {
        login = false;
    } else {
        login = true;
    }
    //alert(login);
    if (!login) {
        $('#user').css('display','none');
        $('#log').html('登录');
    }
    $('#user').html(sessionStorage.getItem('loader'));
    // 登录或退出
    $('#log').click(function () {
        if (!login) {
            $('#wall').remove();
            var wall = '<div class="wall" id="wall"><div class="theLoginBox"><div class="title">登录<a href="javascript:void(0)" class="close" id="close">+</a> </div><form class="formBox"> <div class="inputBox">' +
                '<div class="leftIcon"><i class="fa fa-mobile" aria-hidden="true"></i></div><input type="text" class="theInput" placeholder="请输入电话号码或账号" id="phoneNmber">'+'</div> <div class="inputBox">' +
                '<div class="leftIcon"><i class="fa fa-lock" aria-hidden="true"></i></div><input type="password" class="theInput" placeholder="请输入验证码或密码" id="yzm">'+'</div><div class="nextAutoBox"><input type="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;下次自动登录<a href="javascript:void(0)" class="getYzm" id="getCode">获取验证码</a> </div> <input type="button" class="submitBox" id="submit" value="登录"></form></div></div>';

            $('body').append(wall);
            $('#getCode').css('display','none');
        } else { //退出登录
        	sessionStorage.removeItem('isLoad');
            logOut();
            // opCookie.remove('isLoad');
            window.location.reload(true);
        }
    });
    //监听输入账户框
    $(document).on('input propertychange','#phoneNmber',function () {
        var number = $('#phoneNmber').val();
        if (/^1[34578]\d{9}$/.test(number)) { // 号码格式正确
            how = 1;
            $('#getCode').css('display','block');
        } else {
            how = 0;
            $('#getCode').css('display','none');
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
        if (how === 0) { // 账号密码登录
            $('#yzm').attr('type','password');
            if (phone.length === 0 || yzm.length === 0) {
                alert('账号或者密码不能为空');
            } else {
                sub(phone,yzm);
            }
        } else if (how === 1) { // 电话号码登录
            $('#yzm').attr('type','text');
            if (phone.length === 0 || yzm.length === 0) {
                alert('电话号码或者验证码不能为空');
            } else {
                Submit(phone,yzm);
            }
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
                } else { // 号码格式错误
                    alert('请输入正确电话号码格式');
                }
            }
        }
    });
    // 去顺序练习
    $('#goTest').click(function () {
        if (!login) {
            $('#log').click();
        } else {
            //window.location.replace('../page/exam/sequenceExam.html?type='+ 0);
            window.location.href = '../page/exam/sequenceExam.html?type='+ 0;
        }
    });
    // 去考试
    $('#goExam').click(function () {
        if (!login) {
            $('#log').click();
        } else {
        	//window.location.replace('../page/exam/examList.html');
            window.location.href = '../page/exam/examList.html';
        }
    });
    // 自定义方法
    function  getTheCode(phone) {
        // var url = 'http://192.168.1.120:8080/SSMDemo/login/doLogin.action'+'?phone=' + phone;
        var url = '/SSMDemo/index/beforeLogin.action?phone='+phone;
        $('#getCode').html('验证码发送中...');
        $.get(url ,function (data) {
            if (data[0] === undefined) {
                alert('号码不存在,请确认号码');
                $('#getCode').html('获取验证码.');
            } else {
                code = 60;
                $(this).html('60s后重新获取');
                var t = setInterval(function () {
                    code -- ;
                    $('#getCode').html(code+'s后重新获取');
                    if (code === 0) {
                        $('#getCode').html('获取验证码');
                        clearInterval(t);
                    }
                },1000)
            }

        });
    }
    // 提交数据
    function Submit(phone, yzm) {
        var url = '/SSMDemo/index/doLogin.action?phone='+phone+'&chenk_code='+yzm;
        $.get(url,function (data) {
            if (data[1] != undefined) {
                alert('登录失败，验证码已失效');
            }else if (data[2] != undefined) {
                alert('登录失败，验证码错误');
            }else if(data[3] != undefined){
                alert('登录失败，号码不存在');
            }else{
                if (data[0] != undefined) {
                    $('#wall').remove();
                    //保存一天登录状态
                    login = true;
                    //opCookie.add({loader:phone,isLoad: 'success'},24);
                    sessionStorage.setItem('loader',phone);
                    sessionStorage.setItem('isLoad','success');
                    $('#user').css('display','block');
                    $('#log').html('退出');
                }
            }
        });
    }
    // 以账号密码登录
    function sub(phone,yzm) {
        // var pData = {username:phone,pass:yzm};
        var url = '/SSMDemo/index/login.action?username=' +encodeURI(phone)+'&pass='+ yzm;
         // pData = JSON.stringify(pData);
        //console.log(pData);
        $.get(url,function (data) {
            if (data[0] != undefined){
                $('#wall').remove();
                //保存一天登录状态
                login = true;
                //opCookie.add({loader:phone,isLoad: 'success'},24);
                sessionStorage.setItem('loader',phone);
                sessionStorage.setItem('isLoad','success');
                $('#user').css('display','block');
                $('#user').html(phone);
                $('#log').html('退出');
            } else if (data[1] != undefined) {
                alert('密码错误');
            } else if (data[2] != undefined) {
                alert('用户不存在，请输入正确账号');
            }
        });

    }
    //获得url数据
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return decodeURIComponent(r[2]);
        return null;
    }
    // 退出登录 
    function logOut() {
        $.get('/SSMDemo/index/logout.action',function () {

        });
    }
})($);
