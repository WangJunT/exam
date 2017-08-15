/**
 * Created by Admin on 2017/8/11.
 */
(function () {
    // 样式
    var wall = 'position: fixed;width: 100%; height: 100%; top: 0;z-index: 999;background: rgba(0,0,0,.4); ',
    theBox = 'min-width: 100px; min-height: 90px; background: #fff; border-radius: 5px; position: absolute; top: 50%;left: 50%;transform:translateX(-50%) translateY(-50%);',
    titles = 'width: 100%; height: 30px;line-height: 30px; text-align: center;font-size: 14px;color:#000;',
    contents = 'width: 100%; padding: 5px; height: auto; line-height: 16px; font-size: 14px;color: #999;',
    csBox = 'width: 100%; height: 30px; font-size: 0;border-top: 1px solid #999',
    choose1 = 'display: inline-block; width: 50%; height: 30px;line-height: 30px; text-align:center;color:#000;border-right: 1px #999 solid; font-size: 15px;box-sizing:border-box';
    choose2 = 'display: inline-block; width: 50%; height: 30px;line-height: 30px; text-align:center;color:#000;font-size:15px';
    function Dialog(option) {
        this.yes = option.yes || this.remove;
        this.No= option.No || this.remove;
        this.width = option.width;
        this.height = this.height;
        this.title = option.title || 'dialog';
        this.content = option.content;
        this.init();
    }
    Dialog.prototype.init = function () {
        var lsDiv = document.createElement('div');
        var box = '<div style="'+wall+'" id="dialogWall"><div style="'+theBox+'" id="DialogBox"><div style="'+titles+'">'+this.title+'</div><div style="'+contents+'">'+this.content+'</div><div style="'+csBox+'"><a href="javascript:void(0)" style="'+choose1+'" id="dialogSure">确定</a> <a href="javascript:void(0)" style="'+choose1+'" id="dialogOut">取消</a></div></div></div>';
        lsDiv.innerHTML = box;
        document.getElementsByTagName('body')[0].appendChild(lsDiv.firstElementChild);
        if (this.width != undefined && this.width > 100){
            document.getElementById('DialogBox').style.width = this.width + 'px';
        }
        if (this.height != undefined && this.height > 100){
            document.getElementById('DialogBox').style.height = this.height + 'px';
        }
        document.getElementById('dialogSure').addEventListener('click',this.yes,false);
        document.getElementById('dialogOut').addEventListener('click',this.No,false);
    }
    Dialog.prototype.remove = function () {
        document.getElementById('dialogSure').removeEventListener('click',this.yes,false);
        document.getElementById('dialogOut').removeEventListener('click', this.No,false);
        document.getElementsByTagName('body')[0].removeChild(document.getElementById('dialogWall'));
    }
    Dialog.prototype.No = function () {
        
    }
    Dialog.prototype.yes = function () {
        
    }
    // 私有方法

    window.Dialog = Dialog;
})();
