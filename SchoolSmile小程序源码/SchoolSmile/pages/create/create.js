// pages/create/create.js
const app = getApp()

Page({

 
  data: {
   
  },

  onLoad: function () {
    
  },
   /************************************** */
  formsubmit: function (e) {
    var user = app.data.user;
    var param = e.detail.value;
    param.user = user;
    console.log("信息提交", param);
    var kc_names = param.kc_names;
    var people_room = param.people_room;
    var bj_nums = param.bj_nums;
    if (kc_names.length === 0 || people_room.length === 0 || bj_nums.length === 0) {
      wx.showModal({
        title: '提示',
        content: '请将信息填完整！',
      })
      return;
    }
    console.log(param);
    wx.request({
      url: "https://mrbannana.mynatapp.cc/teacher/createCourse",
      data: param,
      success: function (data) {
        console.log("create:::::",data);
        if(data.data.result==true){
          app.data.tea_bj_num = param.bj_nums;
          wx.redirectTo({
           url: '../cre_map/cre_map?coursecode='+data.data.courseid,
         })
        } else if (data.data.result==false){
          wx.showModal({
            title: '提示',
            content: '创建失败',
          })
        }
      },
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