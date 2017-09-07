/**
 * Created by Admin on 2017/8/25.
 */
(function () {
    var id,show = false;
    window.parent.changeFrame(0);
    // 获得数据
    $.get('/SSMDemo/level/selOne.action',function (data,status) {
        if (status == 'success'){
            var op = '';
            for (var i = 0; i < data.length; i++) {
                id = data[0].id;
                op += '<option value="'+data[i].id+'">'+data[i].name+'</option>';
            }
            $('#first').html(op);
            addSecond(id);
        } else {
            alert('发生错误，请稍后重试.');
        }
    });
    // 显示添加区块
    $('#show').click(function () {
        if (show) {
            show = false;
            $('#cate').css('display','none');
        } else {
            show = true;
            $('#cate').css('display','block');
        }
    });
    // 添加
    $('#add').click(function () {
        var name = $('#name').val().replace(/\s/g,'');
        if (name.length == 0) {
            alert('请输二级入菜单名');
        } else {
            // console.log(encodeURI(name));
            $.get('/SSMDemo/level/addTwo.action?uplevel='+id+'&name='+encodeURI(name),function (data,status) {
                if (status == 'success') {
                    if (data[0] != undefined) {
                        alert('添加成功');
                        addSecond(id);
                        show = false;
                        $('#name').val('');
                        $('#cate').css('display','none');
                    } else {
                        alert('添加失败');
                    }
                }
            });
        }
    });
    // 删除
    $('#delete').click(function () {
        var tid = $('input[name=choose]:checked').attr('data-id');
        if (tid == null || tid == undefined){
            alert('请选择后再删除');
        } else {
            $.get('/SSMDemo/level/delTwo.action?id='+Number(tid),function (data,status) {
                if(status == 'success') {
                    if (data[0] != undefined) {
                        alert('删除成功');
                        addSecond(id);
                    } else {
                        alert('删除失败');
                    }
                } else {
                    alert('发生错误，稍后重试');
                }
            });
        }
    });
    // 监听变化
    $(document).on('change','#first',function () {
        id = Number($('#first').val());
        addSecond(id);
    })
    /// 填充数据
    function addSecond(id) {
        $.get('/SSMDemo/level/selTwo.action?id='+id,function (data,status) {
            if (status == 'success') { // 成功了
                op = '';
                for (var i = 0; i < data.length; i++) {
                    op += '<li><input type="radio" name="choose" data-id="'+data[i].id+'"><span>'+data[i].name+'</span></li>';
                }
                $('#list').html(op);
            } else {
                alert('发生错误');
            }
        });
    }
})($);