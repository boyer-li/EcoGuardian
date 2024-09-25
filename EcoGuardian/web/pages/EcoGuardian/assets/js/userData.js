// globalData 可以随便定义，调用的时候相同即可
// var uid,token;
// var usre_id,user_name,user_pwd,user_sex;
var userData ={

    /**
     * setUserInfo 方法名
     *  uid 用户id
     *  uname 用户姓名
     *  usex 用户性别
     */
    //多个存储
    setUserInfo:function (a){
        //单个存储
        sessionStorage.setItem("userid",a);
        // sessionStorage.setItem("uname",uname);
    },
    //单个获取
    // getUserUid:function(){
    //     return sessionStorage.getItem("user_id");
    // },
    // getUserUName:function(){
    //     return sessionStorage.getItem("uname");
    // },
    setMaterialInfo:function (b){
        //单个存储
        sessionStorage.setItem("material_id",b);
    },

    getUserId:function(){
        return sessionStorage.getItem("userid");
    },
    getMaterialId:function(){
        return sessionStorage.getItem("material_id");
    },

}

