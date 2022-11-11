// pages/register/register.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    img:"",
    msg:"(请仔细核对未本人哦)"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
  img:function(){
    var that = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success(res) {
        // tempFilePath可以作为img标签的src属性显示图片
        const tempFilePaths = res.tempFilePaths
        console.log(res)
          that.setData({
            img: res.tempFilePaths[0],
            msg: res.tempFilePaths[0]
          })
        console.log("选中成功",that.data.img)
      }
    })
  },
  formsubmit:function(e){
    var that = this;
    var data=e.detail.value;
    console.log(data);
    var user = data.user;
    var name = data.name;
    var bj_num = data.bj_num;
    var password = data.password;
    var password_ed = data.password_ed;
    if (name == "" || user == "" || bj_num == "" || password == "" || password_ed == ""){
      wx.showModal({
        title: '提示',
        content: '请将信息填写完整'
      })
    }else if(password.length<6){
      wx.showModal({
        title: '提示',
        content: '密码需6位以上，请重新输入'
      })
    }
    else if(password!==password_ed){
      wx.showModal({
        title: '提示',
        content: '两次输入的密码不同，请重新输入'
      })
    }else if(that.data.img==""){
      wx.showModal({
        title: '提示',
        content: '请选择需要上传的图片'
      })
    }else{
      wx.uploadFile({
        url: app.globalData.url+'/face/add', // 仅为示例，非真实的接口地址
        filePath: that.data.img,
        name: 'file',
        formData: {
          name:name,
          snumber:user,
          password:password,
          gradeid:bj_num
        },
        success(res) {
          console.log(res);
          if (res.data == '{"result":"success"}'){
            wx.showModal({
              title: '提示',
              content: '注册成功，请登录'
            })
            wx.navigateTo({
              url: '/pages/login/login',
            })
          }
        }
      })
    }
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