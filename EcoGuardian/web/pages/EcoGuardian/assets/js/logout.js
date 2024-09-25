$(function(){
    $('#loginout').click(function (){
        $.ajax({
            type:"post",
            url:"http://localhost:8088/logout",
            data:localStorage.getItem('token'),
            contentType:'application/json',
            beforeSend:function(request){
                request.setRequestHeader('token',localStorage.getItem('token'));
            },
            success(res){
                if(res.code === 0) {
                    localStorage.removeItem("token");
                    window.location = '../auth-sign-in.html';
                }else{
                    alert('未登录不能注销');
                }
            },
            error(){
                alert('出错了');
            }
        })
    })
});