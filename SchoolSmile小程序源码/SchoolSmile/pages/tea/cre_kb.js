//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    weekNum: "1",
    
    colorArrays: ["#f66595", "#6568f6", "#f6ad65", "#f66c65", "#a965f6", "#f665a9", "#a791f8"],
    wlist: [
      { "xqj": 1, "skjc": 3, "skcd": 2, "kcmc": "大学英语", "room": "7102", "num": "02111701"},
      { "xqj": 2, "skjc": 5, "skcd": 2, "kcmc": "web设计", "room": "2102", "num": "02111701" },
      { "xqj": 3, "skjc": 1, "skcd": 2, "kcmc": "大学物理", "room": "2102", "num": "02111701" },
      { "xqj": 3, "skjc": 7, "skcd": 2, "kcmc": "C语言", "room": "7103", "num": "02111701" },
      { "xqj": 4, "skjc": 5, "skcd": 2, "kcmc": "算法与数据结构", "room": "1102", "num": "02111701" },
      { "xqj": 5, "skjc": 9, "skcd": 2, "kcmc": "电影赏析", "room": "7102", "num": "02111701" },
      { "xqj": 5, "skjc": 3, "skcd": 2, "kcmc": "音乐赏析", "room": "s2102", "num": "02111701" },
    ]
  },
  changeWeek: function (e) {
    var that = this;
    console.log(e.target.dataset.week)
    if (e.target.dataset.week==1){
      that.setData({
        wlist: [
          { "xqj": 1, "skjc": 3, "skcd": 2, "kcmc": "大学英语", "room": "7102", "num": "02111701" },
          { "xqj": 2, "skjc": 5, "skcd": 2, "kcmc": "web设计", "room": "2102", "num": "02111701" },
          { "xqj": 3, "skjc": 1, "skcd": 2, "kcmc": "大学物理", "room": "2102", "num": "02111701" },
          { "xqj": 3, "skjc": 7, "skcd": 2, "kcmc": "C语言", "room": "7103", "num": "02111701" },
          { "xqj": 4, "skjc": 5, "skcd": 2, "kcmc": "算法与数据结构", "room": "1102", "num": "02111701" },
          { "xqj": 5, "skjc": 9, "skcd": 2, "kcmc": "电影赏析", "room": "7102", "num": "02111701" },
          { "xqj": 5, "skjc": 3, "skcd": 2, "kcmc": "音乐赏析", "room": "s2102", "num": "02111701" },
        ]
      })
    }else{
      that.setData({
        wlist:""
      })
    }
    that.setData({
      weekNum: e.target.dataset.week
    })

  },
  bindS: function (e) {
    console.log(e, "课表", app.globalData.url);
    var data = e.currentTarget.dataset;
    data.user = app.data.user;
    data.miaoshu="";
    var tea_bj_num = data.bj_nums;
    console.log(data);
    wx.showModal({
      title: '提示',
      content: '确定创建此课程签到吗~',
      success(res) {
        if (res.confirm) {
          wx.request({
            url: app.globalData.url+"/teacher/createCourse",
            data: data,
            success: function (data) {
              console.log("create:::::", data);
              if (data.data.result == true) {
                app.data.tea_bj_num = tea_bj_num;
                wx.redirectTo({
                  url: '../cre_map/cre_map?coursecode=' + data.data.courseid,
                })
              } else if (data.data.result == false) {
                wx.showModal({
                  title: '提示',
                  content: '创建失败',
                })
              }
            },
          })/**/
        } else if (res.cancel) {
             console.log("取消！")
        }
      }
    })
    
  },
  onLoad: function () {
    console.log('onLoad')
  }
})
