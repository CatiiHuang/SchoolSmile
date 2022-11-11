// pages/look_zy/pgzy.js
var app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    src: '',
    name:"",
    id:"",
    data:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
        console.log(options)
        wx.request({
          url: 'https://mrbannana.mynatapp.cc/homework/getwork',
          data: {
            homeworkid:options.id,
            studentid:options.userid
          },
          success: function(res) {
            console.log("look_zy.\/pgzy",res.data.result)
             that.setData({
               src: "https://mrbannana.mynatapp.cc"+res.data.result.url,
               name: res.data.result.name,
               id: res.data.result.id,
               data: res.data.result
             })
          }
        })
  },
  img:function(event){
    var url = this.data.src
    var src = event.currentTarget.dataset.src;
    wx.previewImage({
      current:src, // 当前显示图片的http链接
      urls: [url] // 需要预览的图片http链接列表
    })
  },
  formSubmit:function(e){
    var that = this;
    console.log(e.detail.value.content);
    wx.request({
      url: 'https://mrbannana.mynatapp.cc/homeworkcomment/creat',
      data:{
        content: e.detail.value.content,
        user:app.data.user,
        homeworkid:that.data.id,
        studentname: that.data.name
      },
      success:function(res){
        console.log(res);
        if(res.data.result=="success"){
          wx.navigateTo({
            url: '/pages/tea_success/success?text='+'批改成功啦~',
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