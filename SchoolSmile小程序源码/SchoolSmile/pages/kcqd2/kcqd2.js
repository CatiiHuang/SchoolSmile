// pages/kcqd2/kcqd2.js 
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    timer:"",
    countDownNum: '0'
  },

  /**
   * 生命周期函数--监听页面加载
   ************************************************************/
  countDown: function () {
    let that = this;
    let countDownNum = that.data.countDownNum;//获取倒计时初始值
    //如果将定时器设置在外面，那么用户就看不到countDownNum的数值动态变化，所以要把定时器存进data里面
    that.setData({
      timer: setInterval(function () {//这里把setInterval赋值给变量名为timer的变量
        //每隔一秒countDownNum就减一，实现同步
        countDownNum--;
        //然后把countDownNum存进data，好让用户知道时间在倒计着
        that.setData({
          countDownNum: countDownNum
        })
        //在倒计时还未到0时，这中间可以做其他的事情，按项目需求来
        if (countDownNum == 0) {
          //这里特别要注意，计时器是始终一直在走的，如果你的时间为0，那么就要关掉定时器！不然相当耗性能
          //因为timer是存在data里面的，所以在关掉时，也要在data里取出后再关闭
          clearInterval(that.data.timer);
          wx.showModal({
            title: '提示',
            content: '签到时间已过！',
          })
          //关闭定时器之后，可作其他处理codes go here
        }
      }, 1000)
    })
  },
  
  onLoad: function (options) {
    var that = this;
    var nowtime = Date.parse(new Date());
    nowtime = nowtime/1000;
    console.log("now");
    console.log(nowtime);
    var cretime = options.createtime/1000;
    console.log(cretime);
    var x = nowtime - cretime;//已经国庆的时间
    if(x<60*2){//时间
      that.setData({
        countDownNum:60*2-x
      })
    this.countDown();//定时器开启
    }
    else{
      that.setData({
        countDownNum:0
      });
      wx.showModal({
        title: '提示',
        content: '签到时间已过！',
        success:function(){
          wx.navigateBack({});
        }
      });
    }
  },
  formsubmit:function(e){
    var qd_num = e.detail.value.qd_num;
    if(this.data.countDownNum<=0){
      wx.showModal({
        title: '提示',
        content: '签单时间已过！',
      })
      return;
    }
    else if(qd_num.length===0){
      wx.showModal({
        title: '提示',
        content: '请输入签到码！',
      })
    return;
  }
  else{//定位及拍照方法在此中运行并发送
      console.log("签到码:", qd_num);
     wx.request({
       url: 'https://mrbannana.mynatapp.cc/student/courseverify?tdsourcetag=s_pcqq_aiomsg',
       data:{
         vertify:qd_num
       },
       success:function(res){
         if (res.data.result=="failed"){
           console.log(res.data.result);
           wx.showModal({
             title: '提示',
             content: '课程码错误',
           })
         } else if (res.data.result == "success"){
           console.log(res)
           wx.showModal({
             title: '验证成功',
             content: '即将开启人脸签到',
             success:function(){
               wx.navigateTo({
                 url: '../stu_face/test?qd_num=' + qd_num,
               })
             }
           })
            
          }
       }
     })
  }
   
    
  },
  /**************************************************************
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /********
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    clearInterval(this.data.timer);
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    clearInterval(this.data.timer);
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