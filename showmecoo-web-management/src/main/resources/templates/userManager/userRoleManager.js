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
	var options = {data:a,parentId:"nav-content",mainPage:"userRoleManager.html"}
	var b = new Nav(options);
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