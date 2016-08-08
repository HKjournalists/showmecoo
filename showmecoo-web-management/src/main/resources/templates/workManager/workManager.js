$(function(){
	var arr = [{work_name:"1",recommend_level:"2",picture_name:"3",visit_num:"4",roleid:"5"}
		,{work_name:"11",recommend_level:"12",picture_name:"13",visit_num:"14",roleid:"15"}
		,{work_name:"21",recommend_level:"22",picture_name:"23",visit_num:"24",roleid:"25"}
		,{work_name:"21fda",recommend_level:"224132",picture_name:"vc23",visit_num:"2r4",roleid:"25f"}];

	var table = TABLE_STATIC.get("workTable");
	if(table){
		table.setData(arr);
		var data = table.getDataByRowIndex(2);
	}

	//模态页面加载完成后回调事件
	$('#workInfoModal').on('shown.bs.modal',function(){
		debugger;
		operatorNui({},"clear",["modal_work_name","modal_recommend_level","modal_visit_num"]);

		var table = TABLE_STATIC.get("workTable");
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

	//菜单测试数据
	var a = {menus:[{name:"用户管理",childMenus:[
	  {name:"用户管理",href:"../userManager/userManager.html"},
	  {name:"微信用户管理",href:"../userManager/wechatUserManager.html"},
	  {name:"角色管理",href:"../userManager/roleManager.html"},
	  {name:"用户角色管理",href:"../userManager/userRoleManager.html"}]},
	  {name:"艺人管理",childMenus:[{name:"艺人管理",href:"../actorManager/actorManager.html"}]},
	  {name:"作品管理",childMenus:[{name:"作品管理",href:"../workManager/workManager.html"}]},
	  {name:"订单管理",childMenus:[{name:"订单管理",href:"../orderManager/orderManager.html"}]}
	  ]};
	var options = {data:a,parentId:"nav-content",mainPage:"workManager.html"}
	var b = new Nav(options);
});

//修改保存
function closeModal(){
	var data = getFieldsValue(["modal_work_name","modal_recommend_level","modal_visit_num"],-1);

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