// pages/success/success.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    coursecode:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(app.data.tea_bj_num,"successsssssssssssssssssssssssssss")
    console.log("创建成功",options);
    var that= this;
    if (options.coursecode==undefined){
      console.log("no")
    return;
  }
  else{
    console.log("ok")
      that.setData({
        coursecode: options.coursecode
      })
  }
  },
 /*********************************************/
 Looks:function(){
   var coursecode = this.data.coursecode;
   wx.navigateTo({
     url: '../Looks/Looks?verify=' + coursecode,
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