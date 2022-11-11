// pages/login/login.js// 
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    logo: app.globalData.url +'/image/logo.png'
  },
 
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.clearStorageSync();
  },
  /********************************************************* */
  formsubmit:function(e){
    
    var param = e.detail.value;
    var user = param.user;
    var password = param.password;
    
    console.log("username::::",app.data.username)
    console.log("登录页提交", param);
    if (password.length === 0 || user.length === 0) {
      wx.showModal({
        title: '提示',
        content: '请输入完整信息！',
      })
      return;
      }
    wx.showNavigationBarLoading();
 
    wx.request({
      url: app.globalData.url+'/login',
      data:param,
      success:function(data){
          console.log(data.data);
          /********************* */
         /********************* */
          if(data.data.exist==true && data.data.identity==="student"){
            wx.setStorageSync('user_info', param.user);
            app.data.user = user;
           
            wx.reLaunch({
              url: '/pages/stu/stu_index',
            })
          } else if (data.data.exist == true && data.data.identity === "teacher"){
            wx.setStorageSync('user_info', param.user);
            app.data.user = user;
           
            wx.reLaunch({
              url: '/pages/tea/tea_index',
            })
          }
          else{
            wx.showModal({
              title: '提示',
              content: '账号密码错误！',
            })
          }
      }
    })
  },
  /************************************************/
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