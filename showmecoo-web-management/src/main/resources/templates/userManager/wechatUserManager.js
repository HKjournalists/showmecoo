$(function(){
  var arr = [{nickname:"1",sex:"2",language:"3",city:"4",country:"5",province:"3",subscribe_time:"4",remark:"5"}
    ,{nickname:"1a",sex:"2a",language:"3a",city:"4a",country:"5a",province:"3a",subscribe_time:"4a",remark:"5a"}
    ,{nickname:"1b",sex:"2b",language:"3b",city:"4b",country:"5b",province:"3b",subscribe_time:"4b",remark:"5b"}
    ,{nickname:"1c",sex:"2c",language:"3c",city:"4c",country:"5c",province:"3c",subscribe_time:"4c",remark:"5c"}];

  var table = TABLE_STATIC.get("wechatUserTable");
  if(table){
    table.setData(arr);
    var data = table.getDataByRowIndex(2);
  }

  //模态页面加载完成后回调事件
  $('#wechartUseInfoModal').on('shown.bs.modal',function(){
    operatorNui({},"clear",["nickname","sex","city","country","province","language"
      ,"subscribe_time","remark"]);
    if(table){
      var row = table.getSelectRows();
      if(row && row[0]){
        var modal = "#modal_";
        var data = row[0]["data"];
        for(var c in data){
          if(data.hasOwnProperty(c)){
            var _id = modal + c;
            if($(_id))
              $(_id).val(data[c]);
          }
        }
      }
    }
  })

  //上一页
  jQuery('.previous').bind("click",function(e){
  
  })
  //下一页
  jQuery('.next').bind("click",function(e){

  })
});

//修改保存
function closeModal(){
  var data = getFieldsValue(["nickname","sex","city","country","province","language"
      ,"subscribe_time","remark"],-1);
}