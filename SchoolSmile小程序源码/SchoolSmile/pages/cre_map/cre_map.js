var app = getApp();
Page({
  data: { 
    latitude: 29.972880000000007,
    longitude: 106.27679,
    coursecode:""
  },
  onLoad: function (e) {//获取课程码  并设置在data中 供下文获取
    var x = e.coursecode;
    this.setData({
      coursecode:x
    })
    app.data.coursecode = x;
    console.log(this.data.coursecode)
    
  },
  onReady: function (e) {
    this.mapCtx = wx.createMapContext('myMap');

  },
  getCenterLocation: function () {
    console.log("创建。。。。。。")
    wx.showLoading({
      title: '创建中',
    })
    var x = this.data.coursecode;
    this.mapCtx.getCenterLocation({
      success: function (res) {
        //获取成功后发送
        wx.request({
          url: 'https://mrbannana.mynatapp.cc/courselocation/create',
          method:"get",
          data:{
            courseid:x,
            latitude: res.latitude,
            longitude: res.longitude,
            teacherid:app.data.user
          },
          success: function(res) {
            console.log("cre_map**************************************************");
            console.log(res);
            if (res.data.result==true){
              wx.hideLoading();
                  wx.showModal({
                    title: '提示',
                    content: "创建成功"
                  });
              
                  wx.navigateTo({
                    url: '../cre_success/success?coursecode='+res.data.classcode,
                  })
            }
          }
        })
      }
    })
  },
  moveToLocation: function () {
    console.log("move....")
    this.mapCtx.moveToLocation()
  },
  
  translateMarker: function () {
    this.mapCtx.translateMarker({
      markerId: 1,
      autoRotate: true,
      duration: 1000,
      destination: {
        latitude: 23.10229,
        longitude: 113.3345211,
      },
      animationEnd() {
        console.log('animation end')
      }
    })
  },
  includePoints: function () {
    this.mapCtx.includePoints({
      padding: [10],
      points: [{
        latitude: 23.10229,
        longitude: 113.3345211,
      }, {
        latitude: 23.00229,
        longitude: 113.3345211,
      }]
    })
  }
})
