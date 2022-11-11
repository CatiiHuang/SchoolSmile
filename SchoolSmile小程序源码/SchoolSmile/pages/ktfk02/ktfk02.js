// pages/ktfk02.js
var app =getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
     id:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
     console.log(options.id);
     this.setData({
       id: options.id
     })
  },
  formSubmit: function (e) {
    var that = this;
    var text = e.detail.value.text;
    if(text.length<20){
      wx.showModal({
        title: '提示',
        content: '请输入20字以上',
      })
      return;
    }
    else{
      var x = app.data.user;
      wx.showLoading({
        title: '正在上传',
      });
      wx.request({
        url: 'https://mrbannana.mynatapp.cc/comments/create',
        method:"get",
        data:{
          user:x,
          contenet:text,
          courseid:this.data.id
        },
        success:function(res){
           if(res.data.result=="success"){
             wx.hideLoading();
             wx.navigateTo({
               url: '../stu_success/qd_success?text='+'反馈成功~',
             })
           }

        }
      })
    }
   
   
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