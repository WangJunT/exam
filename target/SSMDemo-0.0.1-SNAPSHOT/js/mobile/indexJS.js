/**
 * Created by Admin on 2017/8/17.
 */
(function ($) {
    var width = $('html').width(),
        ratio = width / 750; // 用于计算比例
    $('html').css('font-size',ratio*20+'px');
})($);