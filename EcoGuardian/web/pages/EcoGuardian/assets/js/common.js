
    //当页面中有ajax请求发送时触发
    $(document).on('ajaxStart',function () {
    NProgress.start();
})

    //当页面中有ajax请求结束时触发
    $(document).on('ajaxComplete',function () {
    NProgress.done();
})
