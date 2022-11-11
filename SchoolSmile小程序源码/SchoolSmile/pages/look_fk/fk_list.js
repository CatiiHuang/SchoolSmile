// pages/stu_my_child/wdfk/wdfk.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    lists:''

  },
  look_fk:function(e){
    console.log(e)
    wx.navigateTo({
      url: '/pages/look_fk/look_fk?id=' + e.target.dataset.id + '&name=' + e.target.dataset.name + '&content=' + e.target.dataset.content + '&coursename=' + e.target.dataset.coursename + '&num=' + e.target.dataset.num + '&time=' + e.target.dataset.time,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    console.log(options);
    var cid = options.cid;
    console.log(cid)
        wx.request({
          url: 'https://mrbannana.mynatapp.cc/comments/getcomments',
          data:{
            courseid:cid
          },
          success:function(res){
                 console.log("fl_list",res);
                 that.setData({
                   lists:res.data
                 })
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