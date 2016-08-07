$(function(){
	var arr = [{link_name:"1",phone:"2",show_addr:"3",show_date:"4",show_fee:"5"}
		,{link_name:"11",phone:"12",show_addr:"13",show_date:"14",show_fee:"15"}
		,{link_name:"21",phone:"22",show_addr:"23",show_date:"24",show_fee:"25"}
		,{link_name:"21fda",phone:"224132",show_addr:"vc23",show_date:"2r4",show_fee:"25f"}];

	var table = TABLE_STATIC.get("roleTable");
	if(table){
		table.setData(arr);
		var data = table.getDataByRowIndex(2);
	}

	//模态页面加载完成后回调事件
	$('#orderInfoModal').on('shown.bs.modal',function(){
		debugger;
		operatorNui({},"clear",["modal_show_addr","modal_show_date","modal_show_fee","modal_request_mark"]);

		var table = TABLE_STATIC.get("roleTable");
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
	var data = getFieldsValue(["modal_username","modal_phone","modal_email","modal_roleid"],-1);

	bsui.ajax({
		url:'test.txt',
		data:{},
		type:'POST',
		async:false,
		success:function(data){
			//alert(bsui.encode(data));
		}
	});
}