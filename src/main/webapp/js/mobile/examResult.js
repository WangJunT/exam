/**
 * Created by Admin on 2017/8/17.
 */
(function () {
    // 登录验证
    var ls = sessionStorage.getItem('isLoad');
    if (ls == null || ls == undefined) {
        window.location.href = 'mobileIndex.html';
    }
    history.forward(1);
    var width = $('html').width(),
        ratio = width / 750,// 用于计算比例
        canvas = document.getElementById('static'),
        context = canvas.getContext('2d');
    var all = Number(getQueryString('all')), finish = Number(getQueryString('finish')),angle = 0,score=Number(getQueryString('score'));
    angle = Math.PI*2*( 1 - finish/all) - Math.PI/2;
    // $('html').css('font-size',ratio*20+'px');
    $('#score').html('你的总得分为:&nbsp;'+score+'分');
    // 开始绘制
    $('#last').click(function () {
        window.location.href = 'examList.html';
    });
    // 导航条
    $('#nav').click(function (e) {
        var id = e.target.getAttribute('id');
        console.log(id);
        var d = new Date();
        var t = d.getTime().toString();
        switch (id){
            case 'first': window.location.href = 'mobileIndex.html?t='+t;break;
            case 'video': window.location.href = 'allVideo.html?t='+t;break;
            case 'set': window.location.href = 'personSet.html?t='+t;break;
        }
    });
    var curst = 1,one = Math.PI/180,begin = -Math.PI/2,ls = 0 ;
    // 定时器绘制图案;
    var t = setInterval(function () {
            ls = ls + one;
            curst = parseInt((ls/(Math.PI*2))*all);
            begin = begin - one;
            if (begin > (angle - Math.PI*2)) {
                draw(begin,curst);
            } else if (begin <= (angle - Math.PI*2)){
                draw(begin,finish);
                clearInterval(t);
            }
    },7);
    // 载入熟练度
    var star = '',limit = Math.ceil((finish/all)*5);
    for (var i = 1; i < 6; i++){
        if (limit >= i) {
            star += '<label class="all"></label>';
        } else {
            star += '<label class="harf"></label>';
        }
    }
    $('#star').html(star);
    if (finish/all < 0.6) {
        $('#summery').text('表现不太好哦，下次加油');
    } else if (finish/all >= 0.6 && finish/all <0.8) {
        $('#summery').text('表现可以哦，再接再厉');
    } else {
        $('#summery').text('恭喜你，你已超神');
    }
    /*
    * ****自定义方法****
    * */
    function draw(angle,t) {
        canvas.width = ratio*20*12.5;
        canvas.height = ratio*20*12.5;
        // canvas画圆环
        context.clearRect(0, 0, canvas.width, canvas.height);
        context.beginPath();
        context.lineWidth = parseInt(15*ratio);
        context.strokeStyle = '#88bbd6';
        context.arc(canvas.width/2,canvas.width/2,(canvas.width - 10)/2,-Math.PI/2,angle,true);
        context.lineCap = 'round';
        context.stroke();
        if (t<100) {
            var size = (60 / 20) * (ratio * 20);
            context.font = size + "px Verdana";
            context.textAlign = 'end';
            context.fillStyle = '#88bbd6';
            context.fillText(t, canvas.width / 2, canvas.width / 2 + size / 2);
            var size2 = (30 / 20) * (ratio * 20);
            context.font = size2 + "px Verdana";
            context.textAlign = 'start';
            context.fillStyle = '#4d4d4d';
            context.fillText('/' + all, canvas.width / 2, canvas.width / 2 + size - size2);
        }else{
            var size = (70 / 20) * (ratio * 20);
            context.font = size + "px Verdana";
            context.textAlign = 'center';
            context.fillStyle = '#88bbd6';
            context.fillText(t, canvas.width / 2, canvas.width / 2 + size / 2);
        }
    }
    //获得url数据
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return decodeURIComponent(r[2]);
        return null;
    }
})($);
