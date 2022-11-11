// pages/stu/stu_index.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    kcqd: app.globalData.url+"/IMGS/kclb.png",
    ckkb: app.globalData.url + "/IMGS/cjkc.png",
    zysc: app.globalData.url + "/IMGS/zypg.png",
    ktfk: app.globalData.url + "/IMGS/hffk.png",
    tabbar: {},
    mode: "scaleToFill",
    arr: [],
    indicatorDots: true,
    autoplay: true,
    interval: 2000,
    duration: 1000,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
    app.changeTabBar();
    var array = this.data.arr
    for (let i = 1; i < 3; i++) {
      array.push(app.globalData.url+"/IMGS/banner" + i + ".jpg")
    }
    this.setData({ arr: array })
  },
  kcqd:function(){
     wx.navigateTo({
       url: '/pages/kcqd1/stu_qd',
     })
  },
  ckkb: function () {
    wx.navigateTo({
      url: '/pages/stu/stu_kb',
    })
  },
  zysc: function () {
    wx.navigateTo({
      url: '/pages/zysc/zysc',
    })
  },
  ktfk: function () {
    wx.navigateTo({
      url: '/pages/ktfk/list1',
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    /**登录状态判断*/
    var user_info = wx.getStorageSync('user_info');
    console.log(user_info);
    if (!user_info) {
      console.log("无登录状态");
      wx.showToast({
        title: '未登录',
        icon: "loading",
        duration: 1000,
        success: function () {
         setTimeout(function(){
           wx.reLaunch({
             url: '/pages/login/login'
           })
         },1000)
        }
      })
      return;
    }

    if (user_info.length <= 7) {
      setTimeout(function () {
        wx.reLaunch({
          url: '/pages/tea/tea_index'
        })
      }, 1000)
      app.data.user = user_info;
      console.log("保持老师登录状态");
      return;
    }
    app.data.user = user_info;
    console.log("保持学生登录状态");
    /*******************************/
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