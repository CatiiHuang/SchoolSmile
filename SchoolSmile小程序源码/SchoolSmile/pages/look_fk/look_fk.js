// pages/look_zy/pgzy.js
var app =getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
      name:"",
      content:"",
      id:"",
    coursename:"",
    time:"",
    num:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
        console.log(options)
        this.setData({
          name: options.name,
          content: options.content,
          id: options.id,
          coursename: options.coursename,
          num:options.num,
          time:options.time
        })
  },
  formSubmit:function(e){
    console.log(e);
    var that = this;
     wx.request({
       url: 'https://mrbannana.mynatapp.cc/recom/create',
       data:{
          user:app.data.user,
          commentid:that.data.id,
         teachercontent: e.detail.value.teachercontent
       },
       success:function(res){
        console.log(res)
         if (res.statusCode==200){
            wx.navigateTo({
              url: '/pages/tea_success/success?text='+'回复反馈成功啦~',
            })
        }
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