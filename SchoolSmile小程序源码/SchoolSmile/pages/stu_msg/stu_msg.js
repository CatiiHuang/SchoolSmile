// pages/stu_msg/stu_msg.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    stu:"",
    xx:app.globalData.url+"/IMGS/xx.png",
    tx: app.globalData.url + "/IMGS/tx.png",
    daokelv:""
  },
  back:function(){
    wx.navigateBack({
      
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
     
    var that = this;
    wx.request({
      url: app.globalData.url+'/student/getone',
      data: {
        user:options.snumber
      },
      success: function (res) {
        var x = res.data.signin + res.data.unsignin;
        var y = (Math.round(res.data.signin / x * 10000)/ 100.00 + "%");
        console.log("tea_wdxx", res)
        that.setData({
          stu: res.data,
          daokelv: y
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

  }
})