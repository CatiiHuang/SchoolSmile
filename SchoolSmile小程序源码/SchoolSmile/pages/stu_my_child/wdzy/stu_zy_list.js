// pages/look_zy/pgzy.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      src:"",
      time:"",
      title:"",
      tea_name:"",
      tea_content:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that =this;
    console.log(options.id)
        wx.request({
          url: 'https://mrbannana.mynatapp.cc/homeworkcomment/getcomment',
          data:{
            homeworkid: options.id
          },
          success:function(res){
              console.log("stu_fk_list",res);
               that.setData({
                 src:"https://mrbannana.mynatapp.cc/"+res.data.homework.url,
                 title: res.data.homework.name,
                 time: res.data.homework.starttime,
               })
            if (res.data.homeworkcomment===null){
               that.setData({
                 tea_content:"老师暂未批改"
               })
            }
            else{
              that.setData({
                tea_content: res.data.homeworkcomment.content,
                tea_name: res.data.homeworkcomment.teachername
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