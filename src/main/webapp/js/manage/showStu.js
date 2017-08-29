/**
 * Created by Admin on 2017/8/27.
 */
(function ($) {
    var totalPage = 0, hasShow = false,stuData = [],changeId=0,positionId=0;
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
    // 显示学生信息
    // getStu(1,10);
    // 删除学生
    $(document).on('click','#delete',function () {
        var id = $(this).attr('data-id');
        var that = $(this);
        if (id != undefined) {
            $.get('/SSMDemo/tea/delStu.action?id='+id,function (data,status) {
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
    // 修改学生信息
    $(document).on('click','#change',function () {
        var id = changeId = $(this).attr('data-id');
        positionId = $(this).attr('data-position');
        showChange();
    });
    ///// 取消点击事件
    $(document).on('click','#outChange',function () {
        $('.wall').remove();
    });
    ///// 确认点击事件
    $(document).on('click','#sureChange',function () {
       var name = $('#userName').val().replace(/\s/g,''),
           phone = $('#phone').val().replace(/\s/g,''),
           card = $('#idCard').val().replace(/\s/g,'');
       if (name == stuData[positionId].username && phone == stuData[positionId].phone && card == stuData[positionId].idcard) {
           $('#msg').html('请修改信息后再提交');
       } else if (name.length == 0 || phone.length == 0 || card.length == 0) {
           $('#msg').html('字段不可为空');
       } else if (!/^1[34578]\d{9}$/.test(phone)) {
           $('#msg').html('请输入正确格式手机号');
       } else if (!/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(card)) {
           $('#msg').html('请输入正确格式身份证');
       } else {
           stuData[positionId].username = name;
           stuData[positionId].phone = phone;
           stuData[positionId].idcard = card;
           stuData[positionId].reserveFive = $('#firstSelect').val();
           stuData[positionId].reserveSix = $('#secondSelect').val();
           $.ajax({
               url: '/SSMDemo/tea/upStuInfo.action',
               contentType: "application/json ;charset=utf-8",
               type: 'POST',
               crossDomain: true,
               dataType: 'json',
               data: JSON.stringify(stuData[positionId]),
               success: function () {
                   alert("提交成功");
                   $('#name'+changeId).html(name);
                   $('#phone'+changeId).html(phone);
                   $('#card'+changeId).html(card);
                   $('.wall').remove();
               },
               error: function (msg) {
                   alert('请求错误,稍后重试');
               }
           });
       }
    });
    /**
     * ***********************方法
     * ************
     * */
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
                getStu(1,10);
            } else {
                alert('发生错误');
            }
        });
    }
    // 获得学生信息
    function getStu(current,size) {
       $.get('/SSMDemo/tea/selStu.action?current='+current+'&pageSize='+size+'&reserveFive='+$('#firstSelect').val()+'&reserveSix='+$('#secondSelect').val(),function (data,status) {
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
                               $.get('/SSMDemo/tea/selStu.action?current='+current+'&pageSize='+10+'&reserveFive='+$('#firstSelect').val()+'&reserveSix='+$('#secondSelect').val(),function (data,status) {
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
        stuData = data;
        var str = '';
        for (var i = 0; i < data.length; i++) {
            str += '<li><span id="name'+data[i].id+'">'+data[i].username+'</span><span id="phone'+data[i].id+'">'+data[i].phone+'</span><span id="real'+data[i].id+'">'+data[i].realname+'</span><span id="card'+data[i].id+'">'+data[i].idcard+'</span><span><a href="javascript:void(0)" class="left" id="change" data-id="'+data[i].id+'" data-position="'+i+'">修改</a> <a href="javascript:void(0)" id="delete" data-id="'+data[i].id+'">删除</a></span></li>';
        }
        $('#student').html(str);
    }
    // 显示修改界面
    function showChange() {
        var wall = '<div class="wall"><div class="changeBox"><div class="titleBox">用户名</div><input type="text" id="userName"><div class="titleBox">手机号</div><input type="text" id="phone"><div class="titleBox">身份证号</div><input type="text" id="idCard"><div class="msg" id="msg"></div><div class="submitBox"><a href="javascript:void(0)" id="sureChange">确认</a> <a href="javascript:void(0)" id="outChange">取消</a></div></div></div>';
        $('body').append(wall);
        $('#userName').val(stuData[positionId].username);
        $('#phone').val(stuData[positionId].phone);
        $('#idCard').val(stuData[positionId].idcard);
    }
})($);
