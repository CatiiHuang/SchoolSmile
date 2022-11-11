
//初始化数据

function tabbarinit() { 
 return [
      { "current":0,
        "pagePath": "/pages/tea/tea_index",
     "iconPath": "https://mrbannana.mynatapp.cc/IMGS/index01.png",
     "selectedIconPath": "https://mrbannana.mynatapp.cc/IMGS/index02.png",
        "text": "首页"
      },
      
      {
        "current": 0,
        "pagePath": "/pages/my/my",
        "iconPath":"https://mrbannana.mynatapp.cc/IMGS/my01.png",
        "selectedIconPath": "https://mrbannana.mynatapp.cc/IMGS/my02.png",
        "text": "我的",
        
      }
    ]

}

/**
 * tabbar主入口
 * @param  {String} bindName 
 * @param  {[type]} id       [表示第几个tabbar，以0开始]
 * @param  {[type]} target   [当前对象]
 */
function tabbarmain(bindName = "tabdata", id, target) {
  var that = target;
  var bindData = {};
  var otabbar = tabbarinit();
  otabbar[id]['iconPath'] = otabbar[id]['selectedIconPath']//换当前的icon
  otabbar[id]['current'] = 1;
  bindData[bindName] = otabbar
  that.setData({ bindData });
}


module.exports = {
  tabbar: tabbarmain
}