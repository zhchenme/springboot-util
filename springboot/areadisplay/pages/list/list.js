// pages/list/list.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   * 用于回显数据
   */
  onShow: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/springboot/superadmin/listarea',
      method: 'GET',
      data: {},
      success: function(res){
        var list = res.data.areaList;

        if(list == null){
          var toastText = '数据回显失败' + res.data.errMsg;
          wx.showToast({
            title: 'toastText',
            icon: '',
            duration: 2000
          });
        }else{
          that.setData({
            list: list
          });
        }
      }
    })
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
  
  },

  /**
   * 当点击添加区域信息按钮时，跳转页面
   */
  addArea: function(){
    wx.navigateTo({
      url: '../operation/operation',
    })
  },
  
  /**
   * 点击删除按钮时，删除对应的区域信息
   */
  deleteArea: function(e){
    var that = this;
    wx.showModal({
      title: '提示',
      content: '确定要删除[' + e.target.dataset.areaname + ']吗?',
      success: function(sm){
        if(sm.confirm){
          wx.request({ 
            url: 'http://localhost:8080/springboot/superadmin/delarea',
            data: { "areaId": e.target.dataset.areaid},
            method: "GET",
            success: function(res){
              var result = res.data.success;
              var toastText = '删除成功！'
              if(!result){
                toastText = '删除失败！';
              }else{
                that.data.list.splice(e.target.dataset.index, 1)
                that.setData({
                  list: that.data.list
                });
              }

              wx.showToast({
                title: toastText,
                icon: '',
                duration: 2000
              });
            }
          })
        }
      }
    })
  }
})