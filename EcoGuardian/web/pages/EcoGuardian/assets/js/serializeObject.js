//将表单中用户输入的内容转化为对象类型
function serializeObject(obj) {
    //处理结果对象
    var result = {}
    //[{name:'user_id',value:'123'},{name:'user_pwd',value:'123'}]
    //serializeArray
    var params = obj.serializeArray()

    //循环数组，将数组转换为对象类型
    $.each(params,function (index,value) {
        result[value.name] = value.value;

    })
    //返回结果
    return result;
}