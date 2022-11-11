// pages/Looks/Looks.js
var app =getApp(); 
Page({
  
  /**
   * 页面的初始数据
   */
  data: {
    lisit:"",
    time:"",
    zs:"",
    success:""
  },
  toch:function(e){
     console.log(e);
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var time = new Date();
    time.toLocaleString();
    this.setData({
      time:time.toLocaleString()
    })
    console.log("looks",options);
    var verify = options.verify;
    var bj_num=app.data.tea_bj_num;
    console.log(verify,bj_num)
      wx.request({
        url: 'https://mrbannana.mynatapp.cc/teacher/getlist',
        data: {
          gradename:bj_num,
          verify:verify
          },
        success: function(res) {
          console.log(res);
          that.setData({
            list:res.data.jsonarray,
            zs: res.data.signin + res.data.unsignin,
            success: res.data.signin
          })
          
          
        },

      })
  },
  back:function(){
    wx.reLaunch({
      url: '/pages/tea/tea_index'
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