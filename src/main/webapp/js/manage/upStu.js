/**
 * Created by Admin on 2017/8/25.
 */
(function ($) {
    // 判断ie版本
    window.parent.changeFrame(0);
    var browser = uaMatch(navigator.userAgent.toLowerCase());
    if (browser.browser.toLowerCase() == 'ie' && Number(browser.version) < 10){
        $('body').append('<div class="wall">上传功能，需IE版本在9以上</div>');
    }
//  监听文件框变化
    var can = false;
    $('#upLoad').css('background','#a9a9a9');
    $(document).on('change','#uploadFile',function () {
        var file = $(this).val();
        if (file != null || file != undefined){ // 不为空
            if (isExcel(file)) {
                can = true;
                $('#upLoad').removeAttr('disabled').css('background','#88bbd6');
                $('#fileName').text(file);
            } else {
                can = false;
                $('#upLoad').removeAttr('disabled').css('background','#a9a9a9');
                $('#fileName').text('请选择excel文件上传');
            }
        } else {
            can = false;
            $('#fileName').text(file);
        }
    });
    // 点击上传
    $('#upLoad').click(function(){
        if (can) {
            if ($('#secondSelect').val() == null ){
                alert('请选择类别');
            } else {
                var formData = new FormData();
                formData.append('file', $('#uploadFile')[0].files[0]);
                //var byteSize  = $('#uploadFile')[0].files[0].size;
                //console.log(byteSize);
                $(this).val('文件上传中...').attr('disabled', 'true').css('background', '#a9a9a9');
                $.ajax({
                    url: '/SSMDemo/admin/addStuBatch.action',
                    type: 'POST',
                    cache: false,
                    data: formData,
                    processData: false,
                    contentType: false,
                    success: function (data) {
                        console.log(data);
                        uploadMsg(data, $('#firstSelect').val(), $('#secondSelect').val());
                    },
                    error: function (data) {
                        alert('上传失败,请稍后重试');
                        $('#upLoad').val('上传文件').removeAttr('disabled').css('background', '#88bbd6');
                    }
                });
            }
        }
    });
    // 选择文件
    $('#choose').click(function () {
        $('#uploadFile').click();
    });
    //
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
    /**
     * ***********************方法
     * ************
     * */
    function uploadMsg(filePath,reserveFive,reserveSix){
        var data = {filePath: filePath,reserveFive:reserveFive,reserveSix: reserveSix};
        data = JSON.stringify(data);
        //console.log(data);
        $.ajax({
            'url': '/SSMDemo/admin/addStuFile.action',
            type:'post',
            dataType: 'JSON',
            data: data,
            contentType: "application/json ;charset=utf-8",
            crossDomain: true,
            success: function (data) {
                alert('上传成功');
                can = false;
                $('#uploadFile').val('');
                $('#fileName').html('选择文件');
                $('#upLoad').val('上传文件');
            },
            error: function (data) {
                alert('发生错误');
                $('#fileName').html('选择文件');
                $('#upLoad').val('上传文件').removeAttr('disabled').css('background','#88bbd6');
            }
        });
        // $.get('/SSMDemo/admin/addStuFile.action?filePath='+filePath+'&reserveFive='+reserveFive+'&reserveSix='+reserveSix,function (data) {
        //     alert('上传成功');
        //     can = false;
        //     $('#uploadFile').val('');
        //     $('#fileName').html('选择文件');
        //     $('#upLoad').val('上传文件');
        // });
    }
    /////
    function addSecond(id) {
        $.get('/SSMDemo/level/selTwo.action?id=' + id, function (data, status) {
            if (status == 'success') { // 成功了
                op = '';
                //console.log(data);
                for (var i = 0; i < data.length; i++) {
                    op += '<option value="' + data[i].id + '" data-id="' + data[i].id + '">' + data[i].name + '</option>';
                }
                $('#secondSelect').html(op);
            } else {
                alert('发生错误');
            }
        });
    }
    // 判断文间类型
    function isExcel(name) {
        var n = name.split('.');
        if (n[n.length - 1] == 'xlsx'|| n[n.length - 1] == 'xls') {
            return true;
        } else {
            return false;
        }
    }
    // 判断版本
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
})($);
