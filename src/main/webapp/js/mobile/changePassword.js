/**
 * Created by Admin on 2017/8/21.
 */
(function ($) {

    $('#submit').click(function () {
        var pass1 = $('#nowPassword').val().replace(/\s/g,''),
            pass2 = $('#password').val().replace(/\s/g,'');
        if (pass1 == null || pass1.length == 0 ) {
            alert('请输入密码');
        } else if (pass1 != pass2) {
            alert('两次输入密码不一致');
        } else {

        }
    });
})($);
