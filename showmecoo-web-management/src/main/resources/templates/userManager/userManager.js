$(function(){
	var arr = [{username:"1",password:"2",phone:"3",email:"4",roleid:"5"}
		,{username:"11",password:"12",phone:"13",email:"14",roleid:"15"}
		,{username:"21",password:"22",phone:"23",email:"24",roleid:"25"}
		,{username:"21fda",password:"224132",phone:"vc23",email:"2r4",roleid:"25f"}];

	var table = TABLE_STATIC.get("userTable");
	if(table){
		table.setData(arr);
		var data = table.getDataByRowIndex(2);
	}

	
	//jQuery('#userTable').bind("mousemove",test1);
	//jQuery('#userTable').bind("click",test2);
	//test
	$('#useInfoModal').on('hide.bs.modal',function(){

	})

	//模态页面加载完成后回调事件
	$('#useInfoModal').on('shown.bs.modal',function(){
		debugger;
		operatorNui({},"clear",["modal_username","modal_phone","modal_email","modal_roleid"]);

		var table = TABLE_STATIC.get("userTable");
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

			var pNode = table.element.parentNode;
			for(var i=0,len=pNode.childNodes.length;i<len;i++){
				var c = pNode.childNodes[i];
				if(c == table.element){
					alert(0);
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