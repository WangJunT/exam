/**
 * Created by Admin on 2017/8/27.
 */
(function ($) {
    var totalPage = 0, hasShow = false;
    var nowPage = 0, choose = [], nowChoose = [];
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
    $(document).on('change','#secondSelect',function () {
        hasShow = false;
        $('#student').html('');
        $('#page').empty();// 清空子元素
        getStu(1,10);
    });
    // 监听选择
    $(document).on('change','input[name = moreDelete]',function () {
        nowChoose = [];
        $('[name = moreDelete]:checked').each(function () {
            var position = Number($(this).attr('data-position'));
            nowChoose[position] = Number($(this).attr('data-id'));
        });
        choose[nowPage] = nowChoose;
    });
    // 批量删除
    $('#batchDelete').click(function () {
        // console.log(choose);
        var array = [];
        /// 获得需要删除的数据
        for (var i = 0; i < choose.length; i++) {
            if (choose[i] != undefined) {
                for (var j = 0; j < choose[i].length; j++) {
                    if (choose[i][j] != undefined) {
                        array.push(choose[i][j]);
                    }
                }
            }
        }
        //////
        if (array.length == 0) {
            alert('请至少选择一项');
        } else {
            $.get('/SSMDemo/tea/delQuesBatch.action?array=' + array,function (data,status) {
                if (status == 'success') {
                    if (data[0] != undefined){
                        alert(data[0]);
                        //重新载入
                        window.location.reload();
                    } else {
                        alert(data[1]);
                    }
                } else {
                    alert('发生错误，请稍后重试');
                }
            })
        }
    });
    //删除题目
    $(document).on('click','#delete', function () {
        var id = $(this).attr('data-id');
        var that = $(this);
        if (id != undefined) {
            $.get('/SSMDemo/tea/delQues.action?id='+id,function (data,status) {
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
    /**
     * ***********************方法*****************
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
        $.get('/SSMDemo/tea/selQues.action?current='+current+'&pageSize='+size+'&reserveFive='+$('#firstSelect').val()+'&reserveSix='+$('#secondSelect').val(),function (data,status) {
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
                                nowPage = current - 1;
                                if (choose[nowPage] != undefined) {
                                    nowChoose = choose[nowPage];
                                } else {
                                    nowChoose = [];
                                }
                                $.get('/SSMDemo/tea/selQues.action?current='+current+'&pageSize='+10+'&reserveFive='+$('#firstSelect').val()+'&reserveSix='+$('#secondSelect').val(),function (data,status) {
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
        var type ='';
        var str = '';
        for (var i = 0; i < data.length; i++) {
            if (data[i].typeId == 1) {
                type = '单选题';
            } else if (data[i].typeId == 2) {
                type = '多选题';
            } else if (data[i].typeId == 3) {
                type = '判断题';
            }
            var checked = '';
            if (nowChoose[i] != undefined) {
                checked = 'checked';
            }
            str += '<li id="all'+data[i].id+'"><span><input type="checkbox" name="moreDelete" data-id="'+data[i].id+'" data-position="'+i+'" '+checked+'></span><span>'+type+'</span><span title="'+data[i].title+'">'+data[i].title+'</span><span><a href="javascript:void(0)" id="delete" data-id="'+data[i].id+'">删除</a></span></li>';
        }
        $('#student').html(str);
    }
})($);