/**
 * Created by Admin on 2017/8/28.
 */
(function ($) {
    getStu(1,10);
   /*
   * **************获得练习历史记录
   * */
    function getStu(current,size) {
        $.get('/SSMDemo/tea/selStuQues.action?current='+ current + '&pageSize='+ size,function (data,status) {
            if (status == 'success') {
                 console.log(data);
                totalPage = data.totalPage;
                if (data.dataList != undefined) {
                    showList(data.dataList);
                }
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
                            $.get('/SSMDemo/tea/selStuQues.action?current='+current+'&pageSize='+10,function (data,status) {
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
            } else {
                alert('发生错误，请稍后重试.');
            }
        });
    }
    /// 显示列表
    function showList(data) {
        // console.log(data);
        var str = '';
        for (var i = 0; i < data.length; i++) {
            var time = getTime(data[i].time);
            str += '<li><span >'+data[i].stuName+'</span><span>'+data[i].first+'</span><span >'+data[i].total+'</span><span>'+data[i].rate*100+'%</span><span title="'+time+'">'+time+'</span></li>';
        }
        $('#student').html(str);
        window.parent.changeFrame($('html').height() + 40);
    }
    //获取时间
    // 时间
    function getTime(time) {
       if (0 < time && time < 60) {
            return time+'秒';
        } else if ( 59 < time && time < 60*60) {
            var miu ,sec;
            miu = parseInt(time/60);
            sec = time - miu*60;
            return miu + "分" + sec + '秒';
        } else {
            var hour,miu, sec;
            hour = parseInt(time/3600);
            miu = parseInt((time - hour*3600)/60);
            sec = time - hour*3600 - min*60;
            return hour + '小时' + miu + '分' + sec+'秒';
        }
    }
})($);
