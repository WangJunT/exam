/**
 * Created by Admin on 2017/8/22.
 */
(function () {
    var browser = uaMatch(navigator.userAgent.toLowerCase());
    var depend = ['../../js/plugin/dialog.js','../../js/sequenceExam1.js'];
    console.log(browser.browser);
    if (browser.browser.toLowerCase() == 'ie'){
        var script = document.createElement('script');
        script.src ='../../js/jquery.min.js';
        document.body.appendChild(script);
        loadDepend(depend);
    } else {
        var script = document.createElement('script');
        script.src ='../../js/jquery-3.2.1.min.js';
        document.body.appendChild(script);
        loadDepend(depend);
    }
    //加载所有script
    function loadDepend(all) {
        for (var i = 0 ; i < all.length; i++) {
            var script = document.createElement('script');
            script.src = all[i];
            document.body.appendChild(script);
        }
    }
    // 判断版本
    function uaMatch(ua){
        var rMsie = /(msie\s|trident.*rv:)([\w.]+)/,
            rFirefox = /(firefox)\/([\w.]+)/,
            rOpera = /(opera).+version\/([\w.]+)/,
            rChrome = /(chrome)\/([\w.]+)/,
            rSafari = /version\/([\w.]+).*(safari)/;
        var match = rMsie.exec(ua);
        if(match != null){
            return { browser : "IE", version : match[2] || "0" };
        }
        var match = rFirefox.exec(ua);
        if (match != null) {
            return { browser : match[1] || "", version : match[2] || "0" };
        }
        var match = rOpera.exec(ua);
        if (match != null) {
            return { browser : match[1] || "", version : match[2] || "0" };
        }
        var match = rChrome.exec(ua);
        if (match != null) {
            return { browser : match[1] || "", version : match[2] || "0" };
        }
        var match = rSafari.exec(ua);
        if (match != null) {
            return { browser : match[2] || "", version : match[1] || "0" };
        }
        if (match != null) {
            return { browser : "", version : "0" };
        }
    }
})();
