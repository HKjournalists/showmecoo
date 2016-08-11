$(function(){
	var arr = [{name:"1",nick_name:"2",height:"3",age:"4",sex:"5"}
		,{name:"11",nick_name:"12",height:"13",age:"14",sex:"15"}
		,{name:"21",nick_name:"22",height:"23",age:"24",sex:"25"}
		,{name:"21fda",nick_name:"224132",height:"vc23",age:"2r4",sex:"25f"}];

	var table = TABLE_STATIC.get("actorTable");
	if(table){
		table.setData(arr);
		var data = table.getDataByRowIndex(2);
	}

	//模态页面加载完成后回调事件
	$('#actorInfoModal').on('shown.bs.modal',function(){
		debugger;
		operatorNui({},"clear",["modal_name","modal_nick_name","modal_height","modal_age"]);

		var table = TABLE_STATIC.get("actorTable");
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
	var options = {data:a,parentId:"nav-content",mainPage:"actorManager.html"}
	var b = new Nav(options);
});

//修改保存
function closeModal(){
	var data = getFieldsValue(["modal_name","modal_nick_name","modal_height","modal_age"],-1);

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