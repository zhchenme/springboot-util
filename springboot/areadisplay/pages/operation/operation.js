// pages/operation/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    areaId: undefined,
    areaName: '',
    priority: '',
    addUrl: 'http://localhost:8080/springboot/superadmin/addarea',
    modifyUrl: 'http://localhost:8080/springboot/superadmin/modifyarea'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    // 页面初始化时，options 为页面跳转所携带的参数
    this.setData({
      areaId: options.areaId,
    });

    if(options.areaId == undefined){
      return;
    }

    wx.request({
      url: 'http://localhost:8080/springboot/superadmin/getarea',
      data: {"areaId": options.areaId},
      method: 'GET',
      success: function(res){
        var area = res.data.area;
        if(area == undefined){
          var toastText = '获取数据失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        }else{
          that.setData({
            areaName: area.areaName,
            priority: area.priority
          });
        }
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
  
  },

  formSubmit: function(e){
    var that = this;
    var formData = e.detail.value;
    var url = that.data.addUrl;

    if(that.data.areaId != undefined){
      formData.areaId = that.data.areaId;
      url = that.data.modifyUrl; 
    }

    wx.request({
      url: url,
      data: JSON.stringify(formData),
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function(res){
        var result = res.data.success;
        var toastText = "操作成功！"
        if(!result){
          toastText = '操作失败' + result.data.errMsg;
        }

        wx.showToast({
          title: toastText,
          icon: '',
          duration: 2000
        });
        
        if(that.data.areaId == undefined){
          wx.redirectTo({
            url: '../list/list',
          })
        }
      }
    })
  }
})