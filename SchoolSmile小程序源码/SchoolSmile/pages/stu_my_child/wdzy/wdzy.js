
// pages/stu_my_child/wdzy/wdzy.js
var app = getApp();
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
            url: 'https://mrbannana.mynatapp.cc/homework/getstudentwork',
            data:{
              user:app.data.user
            },
            success:function(res){
          
            console.log("child_wdzy/wdzy     ",res)
            that.setData({
              lists:res.data
            })
            }
          })
  },
  turn:function(e){
    console.log(e.currentTarget.dataset.id)
         wx.navigateTo({
           url: '/pages/stu_my_child/wdzy/stu_zy_list?id=' + e.currentTarget.dataset.id,
         })
  },
  back:function(){
    wx.navigateBack({})
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