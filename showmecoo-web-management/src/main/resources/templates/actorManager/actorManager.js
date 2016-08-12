$(function(){
	
	actorNavInit();
	actorFormInit();
	actorModalFormInit();

	//模态页面加载完成后回调事件
	$('#actorInfoModal').on('shown.bs.modal',function(){
		actorModalDataInit();
	})
});

amPage = {
	modalType:"",
	modalFields:["name","nick_name","height","age","sex"
		,"type","style","displayed_num","visit_num","fans_num","create_time","image_name"
		,"skilled_style","display_addr","display_price","display_standard","main_image_name"
		,"second_image_name","brief_introduction","level_score"]
};

function actorNavInit(){
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
}

function actorFormInit(){
	var formData = {action:"#",childNodes:[
		{field:"name",name:"艺人名字",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"nick_name",name:"艺人艺名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"type",name:"才艺类型",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"button",name:"查询",childNodes:[
		  {type:"button",style:"margin-top:5px;",onclick:"searchActorData()"}
		]}
	]}
	var c = new FormUI({parentId:"actorForm",id:"afContent",data:formData});
}

function actorModalFormInit(){
	var formData = {childNodes:[
		{field:"name",name:"艺人名字",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"nick_name",name:"艺人艺名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"height",name:"身高",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"age",name:"艺人年龄",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"sex",name:"性别",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"type",name:"艺人类型",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"style",name:"才艺风格",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"displayed_num",name:"出演次数",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"visit_num",name:"被查看次数",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"fans_num",name:"粉丝数",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"create_time",name:"加入时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"image_name",name:"形象照名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"skilled_style",name:"风格",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"display_addr",name:"演出地点",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"display_price",name:"演出费用",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"display_standard",name:"代表演出",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"main_image_name",name:"主形象照名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"second_image_name",name:"副形象照名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"brief_introduction",name:"简介",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"level_score",name:"艺人等级评分",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]}
	]}
	var c1 = new FormUI({parentId:"actorModalForm",id:"amfContent",data:formData});
}

function actorTableDataInit(data){
	var arr = {pager:{totalCount:10,id:"datatable_paginate"},
	data:[{name:"1",nick_name:"2",type:"3",style:"4",roleid:"5"}
	,{name:"11",nick_name:"12",type:"13",style:"14",roleid:"15"}
	,{name:"21",nick_name:"22",type:"23",style:"24",roleid:"25"}
	,{name:"21fda",nick_name:"224132",type:"vc23",style:"2r4",roleid:"25f"}]};

	var table = TABLE_STATIC.get("actorTable");
	table.setData(arr);
}

function actorModalDataInit(){
	var formObj = FormUI_STATIC.get("amfContent");
	formObj.resetTextData(amPage.modalFields);
	
	var table = TABLE_STATIC.get("actorTable");
	var rows = table.getSelectRows();
	if(rows && rows[0]){
		var data = rows[0]["data"];
		var formObj = FormUI_STATIC.get("amfContent");
		formObj.setTextData(data);
	}

	if(amPage.modalType == "add"){
		addActor();
	}
}

function searchActorData(){
	var formObj = FormUI_STATIC.get("afContent");
	var arr = formObj.getTextData(["name","nick_name","type"]);
	var passData = {data:arr,type:"search"}
	actorTableDataInit();
/*
	bsui.ajax({
		url:'test.txt',
		data:passData,
		type:'POST',
		async:false,
		success:function(data){
			//userTableDataInit(data);
		}
	});*/
}

//修改保存
function closeModal(){
	var formObj = FormUI_STATIC.get("amfContent");
	var arr = formObj.getTextData(amPage.modalFields);
	var passData = {data:arr,type:amPage.modalType}
	/*
	bsui.ajax({
		url:'test.txt',
		data:passData,
		type:'POST',
		async:false,
		success:function(data){
			//alert(bsui.encode(data));
		}
	});*/
	amPage.modalType = "";
}

function resetModal(){
	var formObj = FormUI_STATIC.get("amfContent");
	formObj.resetTextData(amPage.modalFields);
}

function actorDetail(){
	var table = TABLE_STATIC.get("actorTable");
	var rows = table.getSelectRows();
}

function addActor(){
	amPage.modalType = "add";
	var formObj = FormUI_STATIC.get("amfContent");
	if(formObj && formObj.resetTextData){
		formObj.resetTextData(amPage.modalFields);
	}
}

function editActor(){
	amPage.modalType = "edit";
}

function delActor(){
	var table = TABLE_STATIC.get("actorTable");
	var rows = table.getSelectRows();
	var passData = {data:rows,type:"del"}
	/*
	bsui.ajax({
		url:'test.txt',
		data:passData,
		type:'POST',
		async:false,
		success:function(data){
			//alert(bsui.encode(data));
		}
	});*/
}