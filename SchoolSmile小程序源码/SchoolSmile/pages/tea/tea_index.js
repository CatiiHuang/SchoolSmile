// pages/tea/tea_index.js
var app = getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
    kbqd: app.globalData.url+"/IMGS/kclb.png",
    cjkc: app.globalData.url + "/IMGS/cjkc.png",
    qdqk: app.globalData.url + "/IMGS/qdqk.png",
    zypg: app.globalData.url + "/IMGS/zypg.png",
    hffk: app.globalData.url + "/IMGS/hffk.png",
    more: app.globalData.url + "/IMGS/more.png",
    mode: "scaleToFill",
    arr: [],
    indicatorDots: true,
    autoplay: true,
    interval: 2000,
    duration: 1000,
    animationData: "",
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    app.globalData.template.tabbar("tabBar", 0, this);
    var array = this.data.arr
    for (let i = 1; i < 3; i++) {
      array.push(app.globalData.url+"/IMGS/banner" + i + ".jpg")
    }
    this.setData({ arr: array })
  },
  kbqd:function(){
     wx.navigateTo({
       url: '/pages/tea/cre_kb',
     })},
  cjkc: function () {
    wx.navigateTo({
      url: '/pages/create/create',
    })},
  qdqk:function(){
    wx.navigateTo({
      url: '/pages/tea_ckqd/tea_ckqd',
    })},
  zypg: function () {
    wx.navigateTo({
      url: '/pages/tea_ckzy/list1',
    })},
  ckfk:function(){
    wx.navigateTo({
      url: '/pages/tea_ckfk/list1',
    })},
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