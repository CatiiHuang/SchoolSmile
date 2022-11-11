// pages/zysc02.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    pic1:"",
    pic2:"",
    pic3: "",
    images:"",
    cid:'',
    name:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
        cid:options.cid
    })
    
  },
  ljsc:function(e){
    console.log(e)
    this.setData({
      name: e.detail.value.name
    })
   
 
    var user = app.data.user;
    var cid = this.data.cid;
    var files = this.data.images;
    var name = this.data.name;
    wx.showLoading({
      title: '正在上传',
    })
    console.log(name, "nameeeeeeeeeeeeeeeeeeeeeeeeeeee");
      wx.uploadFile({
        url: 'https://mrbannana.mynatapp.cc/homework/cteate', //仅为示例，非真实的接口地址
        filePath: files,
        name: 'file',
        formData: {
          name:name,
          user:user,
          courseid:cid
        },
        success: function (res) {
          console.log(res);
          var msg = JSON.parse(res.data)
          console.log(msg);
          if (msg.result=="success"){
            wx.hideLoading();
            wx.navigateTo({
              url: '/pages/stu_success/qd_success?text='+"作业上传成功啦~",
            })
          }
        }
      })
    
    

  },
  rest:function(){
      this.setData({
        pic1: "",
        pic2: "",
        pic3: "",
        images: ""
      })
  },
  pic1:function(){
    var _this = this;
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        var img = res.tempFilePaths[0];
         console.log(img);
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        _this.setData({
          pic1: "none"
        });
        _this.setData({
          images:img
        });
      }
    })
  },
 
  /*************************************
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