// pages/stu_my_child/wdfk/wdfk.js
var app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
     lists:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
          wx.request({
            url: 'https://mrbannana.mynatapp.cc/comments/getstudentcom',
            data:{
              user:app.data.user
            },
            success:function(res){
              if (res.data == 0) {
                wx.showToast({
                  title: '暂无课程数据',
                  icon: 'loading',
                  duration: 1000,
                })
              }
             console.log("child/wdfk/wdfk",res)
              that.setData({
                lists:res.data
              })
            }
          })
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
    console.log("下拉刷新");
    setTimeout(function () {
      wx.hideNavigationBarLoading();
      // 停止下拉动作
      wx.stopPullDownRefresh();
    }, 800)
  }
})