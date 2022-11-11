// Component/win.js
var app=getApp();
Component({
  /**
   * 组件的属性列表
   */
  properties: {

  },

  /**
   * 组件的初始数据
   */
  data: {
    plus: app.globalData.url+"/IMGS/plus.png",
    dis: "none",
    n: 0.7,
    weekNum: "1",
    colorArrays: ["#f66595", "#6568f6", "#f6ad65", "#f66c65", "#a965f6", "#f665a9", "#a791f8"],
    wlist: [
      { "xqj": 1, "skjc": 3, "skcd": 2, "kcmc": "大学英语", "room": "7102", "num": "02111701" },
      { "xqj": 2, "skjc": 5, "skcd": 2, "kcmc": "web设计", "room": "2102", "num": "02111701" },
      { "xqj": 3, "skjc": 1, "skcd": 2, "kcmc": "大学物理", "room": "2102", "num": "02111701" },
      { "xqj": 3, "skjc": 7, "skcd": 2, "kcmc": "C语言", "room": "7103", "num": "02111701" },
      { "xqj": 4, "skjc": 5, "skcd": 2, "kcmc": "算法与数据结构", "room": "1102", "num": "02111701" },
      { "xqj": 5, "skjc": 9, "skcd": 2, "kcmc": "电影赏析", "room": "7102", "num": "02111701" },
      { "xqj": 5, "skjc": 3, "skcd": 2, "kcmc": "音乐赏析", "room": "s2102", "num": "02111701" },
    ]

  },

  /**
   * 组件的方法列表
   */
  methods: {
    xz: function () {
      var animation = wx.createAnimation({
        duration: 500,
        timingFunction: 'ease',
      })

      this.animation = animation

      // animation.scale(2, 2).rotate(45).step()

      this.setData({
        animationData: animation.export(),
      })
      var i = this.data.n;
      //连续动画需要添加定时器,所传参数每次+1就行

      // animation.translateY(-60).step()
      console.log(i)
      this.animation.rotate(180 * (i)).step()
      this.setData({
        animationData: this.animation.export(),
      })
      if (i == 0.7) {
        this.setData({
          n: -0.5,
          dis: "block"
        })
      } else {
        this.setData({
          n: 0.7,
          dis: "none"
        })
      }
    },
    changeWeek: function (e) {
      var that = this;
      console.log(e.currentTarget.dataset.week)
      if (e.currentTarget.dataset.week==1){
        that.setData({
          wlist: [
      { "xqj": 1, "skjc": 3, "skcd": 2, "kcmc": "大学英语", "room": "7102", "num": "02111701" },
      { "xqj": 2, "skjc": 5, "skcd": 2, "kcmc": "web设计", "room": "2102", "num": "02111701" },
      { "xqj": 3, "skjc": 1, "skcd": 2, "kcmc": "大学物理", "room": "2102", "num": "02111701" },
      { "xqj": 3, "skjc": 7, "skcd": 2, "kcmc": "C语言", "room": "7103", "num": "02111701" },
      { "xqj": 4, "skjc": 5, "skcd": 2, "kcmc": "算法与数据结构", "room": "1102", "num": "02111701" },
      { "xqj": 5, "skjc": 9, "skcd": 2, "kcmc": "电影赏析", "room": "7102", "num": "02111701" },
      { "xqj": 5, "skjc": 3, "skcd": 2, "kcmc": "音乐赏析", "room": "s2102", "num": "02111701" },
        ]
        })
      }else{
        that.setData({
          wlist:""
        })
        wx.showModal({
          title: '暂时仅第一周有课程数据哦~',
          duration:2000
        })
      }

      that.setData({
        weekNum: e.target.dataset.week
      })

    },
    /**/
  }
})
