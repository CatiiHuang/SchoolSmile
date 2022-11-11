// pages/stu/stu_kb.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    weekNum: "1",
    colorArrays: ["#f66595", "#6568f6", "#f6ad65", "#f66c65", "#a965f6", "#f665a9", "#a791f8"],
    wlist: [
      { "xqj": 1, "skjc": 3, "skcd": 2, "kcmc": "大学英语", "room": "7102", "num": "02111701" },
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
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})