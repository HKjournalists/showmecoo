$(function(){
	var arr = [{rolename:"1",roledesc:"2",createuserid:"3",createdate:"4",modifyuserid:"5",modifyuserid:""}
		,{rolename:"11",roledesc:"12",createuserid:"13",createdate:"14",modifyuserid:"15",modifyuserid:""}
		,{rolename:"21",roledesc:"22",createuserid:"23",createdate:"24",modifyuserid:"25",modifyuserid:""}
		,{rolename:"21fda",roledesc:"224132",createuserid:"vc23",createdate:"2r4",modifyuserid:"25f",modifyuserid:""}];

	var table = TABLE_STATIC.get("roleTable");
	if(table){
		table.setData(arr);
		var data = table.getDataByRowIndex(2);
	}

	//模态页面加载完成后回调事件
	$('#roleInfoModal').on('shown.bs.modal',function(){
		debugger;
		operatorNui({},"clear",["modal_rolename","modal_roledesc"]);

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
	var data = getFieldsValue(["modal_rolename","modal_roledesc"],-1);

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