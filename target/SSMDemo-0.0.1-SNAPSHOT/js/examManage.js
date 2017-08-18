/**
 * Created by Admin on 2017/8/8.
 */
(function ($,window) {
// 获得所有试卷
    getList();
    var choose = [];
    $(document).on('click','#delete',function () {
        $('input[name="option"]:checked').each(function () {
            var num = Number($(this).attr('exam-id'));
            choose.push(num);
        });
        if (choose.length === 0) {
            alert('请至少选择一项，进行操作');
        }else{
            console.log(choose);
            $.get('/SSMDemo/exam/delExam.action?intarray='+choose,function (data) {
                if( data[0]!= undefined ){
                    alert(data[0]);
                    // 刷新数据
                    getList();
                } else if (data[1] != undefined) {
                    alert(data[1]);
                }
            });
        }
    });
    /*
    *
    * ****************function
    * */
 // 自定义方法
    function getList() {
        $.get('/SSMDemo/exam/selectAll.action',function(data){
            var all ='';
            for (var i = 0; i < data.length; i++) {
                var ls = '<li><input type="checkbox" exam-id="'+data[i].id+'" name="option"></li><li>'+data[i].name+'</li><li>XX</li><li>XXXX</li><li>XXX</li><li>XXX</li><li>xxx</li>';
                var str = '<div class="item"><ul>'+ls+'</ul></div>';
                all += str;
            }
            $('#examList').html(all);
            window.parent.changeFrame($(document).height()+20);
        });
    }
})($,window);
