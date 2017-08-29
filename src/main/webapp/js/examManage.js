/**
 * Created by Admin on 2017/8/8.
 */
(function ($) {
    var totalPage = 0, hasShow = false;
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
        hasShow = false;
        $('#student').html('');
        $('#page').empty();// 清空子元素
        addSecond(id);
    });
    // 删除试卷
    $(document).on('click','#delete',function (e) {
        var id = $(this).attr('data-id');
        var that = $(this);
        if (id != undefined) {
            $.get('/SSMDemo/tea/delExam.action?id='+id,function (data,status) {
                if (status == 'success') {
                    if (data[0] != undefined) {
                        alert('删除成功');
                        that.parent().parent().remove();
                    } else {
                        alert('删除失败.');
                    }
                } else {
                    alert('删除出错，稍后重试。');
                }
            });
        }
    });
    // 显示学生信息
    // getStu(1,10);
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
                getStu(1,10);
            } else {
                alert('发生错误');
            }
        });
    }
    // 获得学生信息
    function getStu(current,size) {
        $.get('/SSMDemo/tea/selExam.action?current='+current+'&pageSize='+size+'&reserveFive='+$('#firstSelect').val()+'&reserveSix='+$('#secondSelect').val(),function (data,status) {
            if (status == 'success') {
                // console.log(data);
                totalPage = data.totalPage;
                if (data.dataList != undefined) {
                    showList(data.dataList);
                }
                if (hasShow){

                } else {
                    hasShow = true;
                    // 总页数大于1才显示
                    if (totalPage > 1) {
                        $('#page').pagination({
                            currentPage: 1,// 当前页数
                            totalPage: totalPage,// 总页数
                            isShow: true,// 是否显示首尾页
                            count: size,// 显示个数
                            homePageText: "首页",// 首页文本
                            endPageText: "尾页",// 尾页文本
                            prevPageText: "上一页",// 上一页文本
                            nextPageText: "下一页",// 下一页文本
                            callback: function(current) {
                                // 回调,current(当前页数)
                                $.get('/SSMDemo/tea/selExam.action?current='+current+'&pageSize='+10+'&reserveFive='+$('#firstSelect').val()+'&reserveSix='+$('#secondSelect').val(),function (data,status) {
                                    if (status == 'success') {
                                        showList(data.dataList);
                                    } else {
                                        alert('发生错误，请稍后重试.');
                                    }
                                });
                                ///////////////////the end//////////////////
                            }
                        });
                    }
                }
            } else {
                alert('发生错误，请稍后重试.');
            }
        });
    }
    // 显示列表
    function showList(data) {
        // console.log(data);
        var str = '';
        for (var i = 0; i < data.length; i++) {
            str = '<li><span>'+data[i].name+'</span><span><a href="javascript:void(0)" id="delete" data-id="'+data[i].id+'">删除</a> </span></li>';
        }
        $('#student').html(str);
    }
})($);
