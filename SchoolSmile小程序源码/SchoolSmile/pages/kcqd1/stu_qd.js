// pages/kcqd/kcqd.js
const app = getApp()
Page({
 
  /**
   * 页面的初始数据
   */
  data: {
    lists: "",
    list: "",
    src1:"https://mrbannana.mynatapp.cc/image/jt02.png",
    src2:"https://mrbannana.mynatapp.cc/image/jt01.png"
  },
 
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("首次加载")
    var that = this;
    var x = app.data.user;
    wx.request({
      url: 'https://mrbannana.mynatapp.cc/student/getcourse',
      data: {
        user: x
      },
      success: function (res) {
        if (res.data == 0) {
          wx.showToast({
            title: '暂无课程数据',
            icon: 'loading',
            duration: 1000,
          })
        }
        console.log(res);
        that.setData({
          lists: res.data,
          list: res.data.splice(0, 1)
        })

      },
    })
    app.globalData.template.tabbar("tabBar", 0, this);

  },
  
  change: function (e) {
    var that = this;
    var id = e.target.dataset.url;
 
    that.setData({
      clickId: e.currentTarget.id,
    })
    setTimeout(function () {
      that.setData({
        clickId: -1
      })
      wx.navigateTo({
        url: '../kcqd2/kcqd2?createtime=' + that.data.list[0].createtime,
      })
    }, 200)

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

  },
  onPullDownRefresh: function () {
    // 显示顶部刷新图标
    var that = this;
    wx.showNavigationBarLoading();
    that.onLoad();
    console.log("123123");
    setTimeout(function(){
      wx.hideNavigationBarLoading();
      // 停止下拉动作
      wx.stopPullDownRefresh();
    },800)
  }
})