/**
 * Created by Admin on 2017/8/25.
 */
(function () {
    var data = [{ name: '建筑特种工',second:['a','b','c']},
        {name: '三类',second:['f','b','c']}
        ,{name: '安监',second:['b','b','c']}
        ,{name: '七大员',second:['g','j','h']}];
    var op = '';
    for (var i = 0; i < data.length; i++) {
        op += '<option value="'+i+'">'+data[i].name+'</option>';
    }
    $('#firstSelect').html(op);
    op ='';
    for (var i = 0; i < data[0].second.length; i++) {
        op += '<option value="'+i+'">'+data[0].second[i]+'</option>';
    }
    $('#secondSelect').html(op);
    $(document).on('change','#firstSelect',function () {
        var id = $('#firstSelect').val();
        op ='';
        for (var i = 0; i < data[id].second.length; i++) {
            op += '<option value="'+i+'">'+data[id].second[i]+'</option>';
        }
        $('#secondSelect').html(op);
    })
})($);