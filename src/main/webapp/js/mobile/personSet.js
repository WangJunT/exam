/**
 * Created by Admin on 2017/8/18.
 */
(function () {

    //////////////////////////////////////////////
    var login = false,
        code = 0,
        how = 0,
        ls = sessionStorage.getItem('isLoad'),
        addCSS = false;
    if (ls == 'undefined'|| ls == null) {
        login = false;
    } else {
        $('#msg').html(sessionStorage.getItem('loader'));
        login = true;
    }
    // 跳转个人具体信息页面
    $('#personMessage').click(function (e) {
        e.stopPropagation();
        if (login) {
            window.location.href = 'personMessage.html';
        } else {
            initLogin();
        }
    });
    // 导航条
    $('#nav').click(function (e) {
        var id = e.target.getAttribute('id');
        var d = new Date();
        var t = d.getTime().toString();
        switch (id){
            case 'first': window.location.href = 'mobileIndex.html?t='+t;break;
            case 'exam': window.location.href = 'exam.html?t='+t;break;
            case 'video': window.location.href = 'allVideo.html?t='+t;break;
        }
    });
    // 全局点击事件
    $(document).click(function () {
        $('.wall').remove();
    });
    // 获得练习历史
    if (login) {
        getHistory();
    }
    /*
    * ******自定义方法*********
    * */
    // 获得历史】
    function getHistory() {
        $.get('/SSMDemo/sexam/selDone.action',function (data,status,xhr) {
            if (status == 'success'){ // 请求成功
                var str = '';
                for (var i = 0 ; i < data.length; i++) {
                    str += '<li><span>'+data[i].name+'</span><span>'+data[i].score+'分</span></li>';
                }
                $('#history').append(str);
            } else {
                alert('请求错误，类型:'+status+'状态:'+xhr.status);
            }
        });
    }
    // 初始化登录
    function initLogin() {
        if (addCSS){

        } else {
            addCSS = true;
            var link = document.createElement('link');
            link.rel = 'stylesheet';
            link.href = '../../css/mobile/login.css';
            document.getElementsByTagName("head")[0].appendChild(link);
        }
        var str = '<div class="wall"><div class="loginBox"><div class="loginHead"><a href="javascript:void(0)" id="mobileLogin">手机号登录</a> <a href="javascript:void(0)" id="otherLogin">账号登录</a></div>' +
            '<div class="loginCurst" id="curst"></div> <form class="loginForm"><div class="inputBox">' +
            '<div class="loginIcon1"></div><input type="text" id="account" placeholder="请输入手机号"></div><div class="inputBox"><div class="loginIcon2"></div><input type="text" id="password" placeholder="请输入验证码"><a href="javascript:void(0)" class="getCode" id="getCode">获取验证码</a> </div> ' +
            '</form><input type="button" class="loginSubmit" value="登录" id="submit"></div></div>';
        $('body').append(str);
        $('.loginBox').children().click(function (e) {
            e.stopPropagation();
        });
        // 以手机号登录
        $('#mobileLogin').click(function () {
            $('#curst').css('transform','translateX(0rem)');
            $('#getCode').css('display','block');
            $('#password').attr({'type':'text','placeholder':'请输入验证码'}).val('');
            $('#account').attr('placeholder','请输入手机号');
            how = 0;
        });
        // 以账号登录
        $('#otherLogin').click(function(){
            $('#curst').css({'transform':'translateX(2.5rem)'});
            $('#getCode').css('display','none');
            $('#password').attr({'type':'password','placeholder':'请输入密码'}).val('');
            $('#account').attr('placeholder','请输入账号');
            how = 1;
        });
        // 获取验证码
        $('#getCode').click(function () {
            if (code === 0) {
                var phone = $('#account').val().replace(/\s/,'');
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
        //确认登录
        $('#submit').click(function () {
            var phone = $('#account').val().replace(/\s/g,'');
            var yzm = $('#password').val().replace(/\s/g,'');
            $(this).attr("disabled", true);
            $(this).val('登录中...');
            // 以验证码登录
            if (how == 0) {
                if (phone.length === 0 || yzm.length === 0) {
                    alert('电话号码或者账号不能为空');
                    $(this).removeAttr("disabled");
                    $(this).val('登录');
                } else {
                    Submit(phone,yzm);
                }
            } else if (how == 1){
                if (phone.length === 0 || yzm.length === 0) {
                    alert('验证码或者密码不能为空');
                    $(this).removeAttr("disabled");
                    $(this).val('登录');
                } else {
                    sub(phone,yzm);
                }
            }
        });
    }
    // 自定义方法
    function  getTheCode(phone) {
        var url = '/SSMDemo/index/beforeLogin.action?phone='+phone;
        $('#getCode').html('发送中...');
        $.get(url ,function (data) {
            if (data[0] === undefined) {
                alert('号码不存在,请确认号码');
                $('#getCode').html('获取验证码.');
            } else {
                code = 60;
                $('#getCode').html('60s后重新获取');
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
                $('#submit').removeAttr("disabled");
                $('#submit').val('登录');
            }else if (data[2] != undefined) {
                alert('登录失败，验证码错误');
                $('#submit').removeAttr("disabled");
                $('#submit').val('登录');
            }else if(data[3] != undefined){
                alert('登录失败，号码不存在');
                $('#submit').removeAttr("disabled");
                $('#submit').val('登录');
            }else{
                if (data[0] != undefined) {
                    $('.wall').remove();
                    //保存一天登录状态
                    getHistory();
                    login = true;
                    //opCookie.add({loader:phone,isLoad: 'success'},24);
                    sessionStorage.setItem('loader',phone);
                    sessionStorage.setItem('isLoad','success');
                    $('#msg').html(phone);
                }
            }
        });
    }
    // 以账号密码登录
    function sub(phone,yzm) {
        // var pData = {username:phone,pass:yzm};
        var url = '/SSMDemo/index/login.action?username=' +encodeURI(phone)+'&pass='+ yzm;
        $.get(url,function (data) {
            if (data[0] != undefined){
                $('.wall').remove();
                //保存一天登录状态
                getHistory();
                login = true;
                //opCookie.add({loader:phone,isLoad: 'success'},24);
                sessionStorage.setItem('loader',phone);
                sessionStorage.setItem('isLoad','success');
                $('#msg').html(phone);
            } else if (data[1] != undefined) {
                alert('密码错误');
                $('#submit').removeAttr("disabled");
                $('#submit').val('登录');
            } else if (data[2] != undefined) {
                alert('用户不存在，请输入正确账号');
                $('#submit').removeAttr("disabled");
                $('#submit').val('登录');
            }
        });

    }
})($);