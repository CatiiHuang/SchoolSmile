// pages/look_zy/pgzy.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      data:"",
      tea:"",
      name:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that =this;
    console.log(options.id)
        wx.request({
          url: 'https://mrbannana.mynatapp.cc/recom/getrecom',
          data:{
            commentid: options.id
          },
          success:function(res){
              console.log("stu_fk_list",res);
               that.setData({
                 data:res.data.comment
               })
               if(res.data.recom===null){
                 var tea = "老师暂未回复"
                 that.setData({
                   tea: tea
                 })
               }
               else{
                 that.setData({
                   tea: res.data.recom.teachercontent,
                   name: res.data.recom.teachername
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
  back: function () {
    wx.navigateBack({})
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