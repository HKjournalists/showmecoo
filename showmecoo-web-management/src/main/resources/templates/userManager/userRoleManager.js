$(function(){
	var arr = [{username:"1",nickname:"2",rolename:"3",email:"4",createdate:"5"}
		,{username:"11",nickname:"12",rolename:"13",email:"14",createdate:"15"}
		,{username:"21",nickname:"22",rolename:"23",email:"24",createdate:"25"}
		,{username:"21fda",nickname:"224132",rolename:"vc23",email:"2r4",createdate:"25f"}];

	var table = TABLE_STATIC.get("userRoleTable");
	if(table){
		table.setData(arr);
		var data = table.getDataByRowIndex(2);
	}

	//模态页面加载完成后回调事件
	$('#userRoleInfoModal').on('shown.bs.modal',function(){
		debugger;
		operatorNui({},"clear",["modal_username","modal_nickname","modal_rolename"]);

		var table = TABLE_STATIC.get("userRoleTable");
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
	var data = getFieldsValue(["modal_username","modal_nickname","modal_rolename"],-1);

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