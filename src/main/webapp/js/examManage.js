/**
 * Created by Admin on 2017/8/8.
 */
var data = [['XX','xx','随机考题','建筑立面设计','2017-07-28','低压电工'],['XX','xx','随机考题','建筑立面设计','2017-07-28','低压电工']];
var str = '';
for (var i = 0; i < data.length; i++) {
    var ls = '<div class="item"><ul><li><input type="checkbox" name="exam"></li>';
    for (var j = 0; j < data[i].length; j++) {
        ls += '<li>' + data[i][j] + '</li>';
    }
    ls += '<li><a href="javascript:void(0)" class="boderRight">修改</a> <a href="javascript:void(0)">删除</a> </li></ul></div>';
    str += ls;
}
$('#content').append(str);