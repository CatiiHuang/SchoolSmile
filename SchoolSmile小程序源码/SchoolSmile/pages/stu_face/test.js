var app = getApp()
Page({
  data: { 
    tempFilePaths: '',
    latitude: 29.972880000000007,
    longitude: 106.27679,
    coursecode:"",
    qd_num:"",
    wz:"",
    display:"none",
    face:"",
    dis:"none"
  },
  finish:function(){
    var that = this;
    var face = this.data.face;
    var wz = this.data.wz;
    console.log(face,"+",wz);
    if (this.data.tempFilePaths==""){
      wx.showModal({
        title: '提示',
        content: '还未获取人脸信息',
      });
      return;
    }
    this.mapCtx.moveToLocation();//获取位置
    this.setData({
      display:"blokc"
    });
    this.moveToLocation();
    wx.showLoading({
      title: '获取地理信息中~ 请稍候',
    })
    clearTimeout(timer);
    var timer= setTimeout(function(){
      that.moveToLocation();
      that.getCenterLocation();
    },700);

    
    
    

  },
  /****************************/ 
  onLoad: function (e) {
    this.setData({
      qd_num: e.qd_num
    })
    this.chooseimage();
  },
  onReady: function (e) {
    this.mapCtx = wx.createMapContext('myMap');//创建地图
    this.mapCtx.moveToLocation();//页面加载完成 获取位置
  },
  getCenterLocation: function () {//获取地理位置 并发送
  var that = this;
    
    this.mapCtx.getCenterLocation({
      success: function (res) {

        that.setData({
          latitude: res.latitude,
          longitude: res.longitude
        })
        wx.request({//获取成功后发送位置
          url: 'https://mrbannana.mynatapp.cc/signinstu/createsgnin',
          method: "get",
          data: {
            latitude: res.latitude,
            longitude: res.longitude,
            user: app.data.user,
            verify:that.data.qd_num
          },
          success: function (res) {
            console.log("位置认证？",res)
             wx.request({
               url: 'https://mrbannana.mynatapp.cc/student/signin',
               data:{
                 signinid:res.data.signin
               },
               success:function(res){
                 wx.hideLoading();
                    console.log(res);
                 that.setData({//位置对比成功
                   wz: res.data.result
                 })
                 var face = that.data.face;
                 if (face == "success" && that.data.wz === "success") {
                   wx.showToast({
                     title: '获取成功啦~',   //提示语
                     icon: 'success', //icon: success/loading/none
                     duration: 600   //规定自动关闭的时间
                   });
                   setTimeout(function(){
                     wx.reLaunch({
                       url: '../stu_success/qd_success?text=' + '小主完成签到啦~',
                     })
                   },600)
                 } else if (face == "failed") {
                   wx.showModal({
                     title: '提示',
                     content: '人脸认证失败，请重试！',
                   });
                 } else {
                   wx.showModal({
                     title: '提示',
                     content: '地理位置认证失败，请重试！',
                   });
                 }

               }
             })
             
          }
        });
      }
    })
  },
  moveToLocation: function () {//刷新位置  并调用获取位置
    this.mapCtx.moveToLocation();
  },
  /********************************/ 
  chooseimage: function () {//拍照上传
    var _this = this;
    var user = app.data.user;
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths;//存取照片路径
        //设置照片路径
        _this.setData({
          tempFilePaths:tempFilePaths[0]
        })
        wx.showLoading({
          title: '识别人脸信息中~ 请稍候',
        })
        wx.uploadFile({
          url: 'https://mrbannana.mynatapp.cc/student/faceschool', //仅为示例，非真实的接口地址
          filePath: _this.data.tempFilePaths,
          name: 'file',
          formData: {},
          success: function (res) {
            var data = JSON.parse(res.data);
            var face = JSON.parse(res.data).result;
            console.log("人脸识别回调",res );
           if(face=="success"){
             wx.hideLoading();
                wx.showModal({
                  title: '提示：',
                  content: '人脸识别成功啦，请进行下一步吧~',
                })
             _this.setData({
               dis:"block",
               face: face
             })
             
           }else{
             wx.hideLoading();
             wx.showModal({
               title: '提示：',
               content: data.message+" 请重试！",
             })
             _this.setData({
               tempFilePaths:''
             })
           }

          }
        });
      }
    })
  }
})