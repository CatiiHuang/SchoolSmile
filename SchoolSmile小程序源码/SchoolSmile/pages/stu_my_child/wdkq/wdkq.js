// pages/stu_my_child/wdkq/wdkq.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bg:"",
    data:[],
    ok:[],
    no:[]
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
      this.setData({
        bg:"https://mrbannana.mynatapp.cc/image/icon/yqd_bg.png"
      })
      wx.request({
        url: 'https://mrbannana.mynatapp.cc/course/getsignin',
        data:{
          user:app.data.user
        },
        success:function(res){
            console.log("我的考勤",res);
          
            for(var i=0;i<res.data.length;i++){
              if(res.data[i].issignin==true){
                that.setData({
                  ok: that.data.ok.concat(res.data[i])
                });
              }else{
                that.setData({
                  no: that.data.no.concat(res.data[i])
                });
              }
            }
          //已签到始数据处理  
          var arr = that.data.ok;
          var new_arr = [];
          for (var i = arr.length - 1; i >= 0; i--) {
            new_arr.push(arr[i]);
          }
          console.log(new_arr);
           that.setData({
             data: new_arr,
             ok:new_arr
           })
           //未签到数据处理
          var _arr = that.data.no;
          var _new_arr = [];
          for (var i = _arr.length - 1; i >= 0; i--) {
            _new_arr.push(_arr[i]);
          }
          console.log(_new_arr);
          that.setData({
            no: _new_arr
          })
        }
      })
  },
  left:function(){
    this.setData({
      bg: "https://mrbannana.mynatapp.cc/image/icon/yqd_bg.png",
      data: this.data.ok
    })
  },
  right:function(){
    this.setData({
      bg: "https://mrbannana.mynatapp.cc/image/icon/wqd_bg.png",
      data: this.data.no
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