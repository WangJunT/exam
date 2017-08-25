/**
 * Created by Admin on 2017/8/23.
 */
(function ($) {
    var manage = sessionStorage.getItem('manageLoader');
    if (manage != undefined) {
        window.location.href = 'allManage.html';
    }
    // 登录页面
   $('#login').click(function(){
       var user = $('#user').val().replace(/\s/g,'');
       var pwd = $('#pwd').val().replace(/\s/g,'');
       $(this).css('background','#a9a9a9').attr('disabled','true').val('登录中...');
       if (user.length == 0 || pwd.length == 0){
           $('#msg').html('输入账户和密码后,登录');
           $('#login').css('background','#88bbd6').removeAttr("disabled").val('登录');
       } else {
           // var pData = {username:phone,pass:yzm};
           var url = '/SSMDemo/index/login.action?username=' +encodeURI(user)+'&pass='+ pwd;
           $.get(url,function (data) {
               if (data[0] != undefined){
                   if (data[0] == 'teacher'){
                       login = true;
                       //opCookie.add({loader:phone,isLoad: 'success'},24);
                       sessionStorage.setItem('manageLoader',user);
                       // 跳转到管理页面
                       window.location.href = 'allManage.html';
                   } else {
                       $('#msg').html('当前用户非管理员用户');
                       $('#login').css('background','#88bbd6').removeAttr("disabled").val('登录');
                   }
               } else if (data[1] != undefined) {
                   $('#msg').html('密码错误');
                   $('#login').css('background','#88bbd6').removeAttr("disabled").val('登录');
               } else if (data[2] != undefined) {
                   $('#msg').html('用户不存在，请输入正确账号');
                   $('#login').css('background','#88bbd6').removeAttr("disabled").val('登录');
               }
           });
           ///////
       }
   });
})($);
