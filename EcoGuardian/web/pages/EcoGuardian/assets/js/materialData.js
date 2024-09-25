var materialData ={

    //存储material数据
    setMaterialInfo:function (b){
        //单个存储
        sessionStorage.setItem("material_id",b);
    },

    getMaterialId:function(){
        return sessionStorage.getItem("material_id");
    },

}