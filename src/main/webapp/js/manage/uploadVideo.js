/**
 * Created by Admin on 2017/8/23.
 */
(function ($) {
    // 判断ie版本
    window.parent.changeFrame(0);
    var browser = uaMatch(navigator.userAgent.toLowerCase());
    if (browser.browser.toLowerCase() == 'ie' && Number(browser.version) < 10){
        $('body').append('<div class="wall">上传功能，需IE版本在9以上</div>');
    }
    var hasVideo = false,hasImg = false,VideoUrl,ImgUrl,status = 0,VideoName,picName;
    // 选择视频
    $('#chooseVideo').click(function () {
            $('#uploadVideo').click();
        }
    );
    // 选择封面
    $('#chooseImg').click(function () {
        $('#uploadImg').click();
    })
    // 上传视频
    $('#upload').click(function () {
        var name = $('#name').val().replace(/\s/g,'');
        var desc = $('#desc').val().replace(/\s/g,'');
        if (!hasVideo){
            $('#msg').html('请选择视频');
        }else if (!hasImg) {
            $('#msg').html('请选择封面图片');
        } else if(name.length == 0 || desc.length == 0) {
            $('#msg').html('课程名称或者描述不能为空');
        } else {
            if (status == 0) {
                upload(name,desc);
            } else {
                upLoadData(name,desc);
            }
        }
    });
    //监听视频文件变化
    $(document).on('change','#uploadVideo',function () {
        var file = $(this).val();
        if(isVideo(file)){
            var size = $('#uploadVideo')[0].files[0].size;
            if (Math.ceil(size/(1024*1024)) < 240){
                //VideoName = getFileName($(this).val());
                hasVideo = true;
                $('#videoMsg').html(file);
            } else {
                hasVideo = false;
                $('#videoMsg').html('请限制视频大小在240MB内');
            }
        }else{
            hasVideo = false;
            $('#videoMsg').html('请选择视频文件');
        }
    });
    //监听图片文件变化
    $(document).on('change','#uploadImg',function () {
        var file = $(this).val();
        if (isImg(file)){
            //picName = getFileName($(this).val());
            hasImg = true;
            $('#imgMsg').html(file);
        }else{
            hasImg = false;
            $('#imgMsg').html('请选择图片文件');
        }
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
    * *******自定义方法********
    * */
    /////
    function addSecond(id) {
        $.get('/SSMDemo/level/selTwo.action?id=' + id, function (data, status) {
            if (status == 'success') { // 成功了
                op = '';
                // console.log(data);
                for (var i = 0; i < data.length; i++) {
                    op += '<option value="' + data[i].id + '" data-id="' + data[i].id + '">' + data[i].name + '</option>';
                }
                $('#secondSelect').html(op);
            } else {
                alert('发生错误');
            }
        });
    }
    // 判断是否为视频
    function isVideo(name){
        var n = name.split('.');
        if (n[n.length - 1] == 'mp4' || n[n.length - 1] == 'webm'||n[n.length - 1] == 'ogg') {
            return true;
        } else {
            return false;
        }
    }
    // 判断图片
    function isImg(name){
        var n = name.split('.');
        if (n[n.length - 1] == 'jpg' || n[n.length - 1] == 'png'||n[n.length - 1] == 'jpeg') {
            return true;
        } else {
            return false;
        }
    }
    // 上传
    function upload(name,desc) {
        if ($('#secondSelect').val() == null ){
            alert('请选择类别');
        } else {
            $('#upload').attr('disabled', 'true').css('background', '#a9a9a9').val('文件上传中...');
            var formData = new FormData();
            formData.append('file', $('#uploadVideo')[0].files[0]);
            formData.append('file', $('#uploadImg')[0].files[0]);
            $.ajax({
                url: '/SSMDemo/video/admin/upVideoAndPic.action',
                type: 'POST',
                cache: false,
                data: formData,
                processData: false,
                contentType: false,
                success: function (data) {
                    status = 1;
                    VideoUrl = data[0];
                    ImgUrl = data[1];
                    VideoName = data[2];
                    picName = data[3];
                    upLoadData(name, desc);
                },
                error: function (data) {
                    alert('上传失败,请稍后重试');
                    $('#upload').val('上传').removeAttr('disabled').css('background', '#88bbd6');
                }
            });
        }
    }
    // 上传数据
    function upLoadData(name,desc) {
        // console.log(VideoName +' '+picName);
        var data = {name:name,content: desc,url:VideoUrl,pic:ImgUrl,reserveOne:VideoName,picname:picName,reserveFive:$('#firstSelect').val(),reserveSix:$('#secondSelect').val()};
        data = JSON.stringify(data);
        console.log(data);
        $.ajax({
            url: '/SSMDemo/video/addVideo.action',
            type: 'POST',
            contentType: "application/json;charset=utf-8",
            data: data,
            crossDomain: true,
            dataType: 'JSON',
            success: function (data) {
                status = 0;
                if (data[1] != undefined){
                    alert('上传成功.');
                    window.location.reload();
                } else {
                    alert('上传失败');
                    $('#upload').val('上传').removeAttr('disabled').css('background','#88bbd6');
                }
            },
            error: function (data) {
                alert('上传失败,请稍后重试');
                $('#upload').val('上传').removeAttr('disabled').css('background','#88bbd6');
            }
        });
    }
    // // 判断版本
// 判断banb
    function uaMatch(ua){
        var rMsie = /(msie\s|trident.*rv:)([\w.]+)/,
            rFirefox = /(firefox)\/([\w.]+)/,
            rOpera = /(opera).+version\/([\w.]+)/,
            rChrome = /(chrome)\/([\w.]+)/,
            rSafari = /version\/([\w.]+).*(safari)/;
        var match = rMsie.exec(ua);
        if(match != null){
            return { browser : "IE", version : match[2] || "0" };
        }
        var match = rFirefox.exec(ua);
        if (match != null) {
            return { browser : match[1] || "", version : match[2] || "0" };
        }
        var match = rOpera.exec(ua);
        if (match != null) {
            return { browser : match[1] || "", version : match[2] || "0" };
        }
        var match = rChrome.exec(ua);
        if (match != null) {
            return { browser : match[1] || "", version : match[2] || "0" };
        }
        var match = rSafari.exec(ua);
        if (match != null) {
            return { browser : match[2] || "", version : match[1] || "0" };
        }
        if (match != null) {
            return { browser : "", version : "0" };
        }
    }
    function getFileName(o){
        var pos=o.lastIndexOf('\\');
        return o.substring(pos+1).split('.')[0];
    }
})($);
