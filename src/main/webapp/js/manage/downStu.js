/**
 * Created by Admin on 2017/8/25.
 */
(function () {
    window.parent.changeFrame(0);
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
    // 下载
    // $('#down').click(function () {
    //     $('#hid').attr('href','/SSMDemo/admin/downStu.action?reserveFive='+$('#firstSelect').val()+'&reserveSix='+$('#secondSelect').val());
    //     $('#hid').click();
    //     // $.get('/SSMDemo/admin/downStu.action?reserveFive='+$('#firstSelect').val()+'&reserveSix='+$('#secondSelect').val(),function (data,status) {
    //     //     if (status == 'success') {
    //     //         console.log(data);
    //     //     } else {
    //     //         alert('发生错误，稍后重试');
    //     //     }
    //     // });
    // });
    /**
     * ***********************方法
     * ************
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
                $('#down').attr('href','/SSMDemo/admin/downStu.action?reserveFive='+$('#firstSelect').val()+'&reserveSix='+$('#secondSelect').val());
            } else {
                alert('发生错误');
            }
        });
    }
})($);