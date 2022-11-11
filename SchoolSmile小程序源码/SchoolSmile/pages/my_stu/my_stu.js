// pages/my_stu/my_stu.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tabbar: {},
    stu:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    app.changeTabBar();
    var that = this;
    wx.request({
      url: 'https://mrbannana.mynatapp.cc/student/getone',
      data: {
        user: app.data.user
      },
      success: function (res) {
        console.log("tea_wdxx", res)
        that.setData({
          stu: res.data.student.name
        })
      }
    })
  },
  wdxx: function () { wx.navigateTo({ url: '/pages/my_stu/my_info', })   },
  wdkq: function () { wx.navigateTo({ url: '/pages/stu_my_child/wdkq/wdkq', })   },
  wdkc: function () { wx.navigateTo({ url: '/pages/stu_my_child/wdkc/wdkc', })   },
  wdfk: function () { wx.navigateTo({ url: '/pages/stu_my_child/wdfk/wdfk', })   },
  wdzy: function () { wx.navigateTo({ url: '/pages/stu_my_child/wdzy/wdzy', })   },
  /*
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },
  loginout: function () {
    wx.showModal({
      title: '提示',
      content: '确定要退出吗?',
      success(res) {
        if (res.confirm) {
          app.data.uesr = "";
          wx.reLaunch({
            url: '/pages/login/login',
            success: function () {
              wx.clearStorageSync();
              console.log("退出成功")
            }
          })
        } else if (res.cancel) {
        }
      }
    })
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